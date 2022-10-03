<template>
  <el-card>
    <el-breadcrumb>
      <el-breadcrumb-item :to="{path: '/welcome'}">首页</el-breadcrumb-item>
      <el-breadcrumb-item>借阅信息管理</el-breadcrumb-item>
      <el-breadcrumb-item>借阅信息管理</el-breadcrumb-item>
    </el-breadcrumb>

    <el-row :gutter="10">
      <el-col :span="6">
        <el-input placeholder="请输入借阅人或图书名查询" v-model="borrows.names" clearable @change="listPage()">
        </el-input>
      </el-col>

      <el-col :span="2">
        <el-button type="primary" plain icon="el-icon-search">搜索</el-button>
      </el-col>

      <el-col :span="2">
        <el-button type="primary" plain icon="el-icon-plus" @click="openAddDailog()">登记</el-button>
      </el-col>
    </el-row>

    <el-table :data="tableData" style="width: 100%;" stripe>
      <el-table-column align="center" prop="tbBook.bname" label="借阅图书"></el-table-column>
      <el-table-column align="center" prop="names" label="借阅者"></el-table-column>
      <el-table-column align="center" prop="outtime" label="借出时间"></el-table-column>
      <el-table-column align="center" prop="intime" label="归还时间"></el-table-column>
      <el-table-column align="center" prop="quantity" label="借阅数量">
        <template slot-scope="rows">
          <el-tag>{{rows.row.quantity}} 本</el-tag>
        </template>
      </el-table-column>
      <el-table-column align="center" prop="stat" label="状态">
        <template slot-scope="rows">
          <el-tag type="success" v-if="rows.row.stat===1">已归还</el-tag>
          <el-tag type="danger" v-else-if="rows.row.stat===0">未归还</el-tag>
          <el-tag type="danger" v-else>错误</el-tag>
        </template>
      </el-table-column>
      <el-table-column align="center" width="150px" label="操做">
        <template slot-scope="rows">
          <el-button size="mini" plain type="primary" icon="el-icon-edit" @click="openEditDailog(rows.row)">
          </el-button>
          <el-button size="mini" plain type="primary" icon="el-icon-refresh-left" @click="giveback(rows.row)">
          </el-button>
        </template>
      </el-table-column>

    </el-table>
    <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="pager.page"
      :page-sizes="[5, 10, 15, 20]" :page-size="pager.size" layout="total, sizes, prev, pager, next, jumper"
      :total="pager.total">
    </el-pagination>

    <!-- 添加对话框 -->
    <el-dialog title="登记借阅信息" :visible.sync="addFlag" destroy-on-close>
      <el-form>

        <el-row :gutter="10">
          <el-col :span="12">
            <el-form-item label="图书名称">
              <el-select v-model="borrows.bid" placeholder="请选择图书" style="width: 100%;">
                <el-option v-for="item in book" :label="item.bname" :value="item.bid">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="借阅者">
              <el-select v-model="borrows.names" placeholder="请选择借阅者" style="width: 100%;">
                <el-option v-for="item in user" :label="item.uname" :value="item.uname">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="10">
          <el-col :span="12">

            <el-form-item label="借出时间">
              <el-date-picker v-model="borrows.outtime" type="date" placeholder="选择日期" format="yyyy 年 MM 月 dd 日"
                value-format="yyyy-MM-dd" style="width: 100%;" :picker-options="pickerOptions">
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="借阅数量">
              <el-input-number style="width: 100%;" v-model="borrows.quantity"></el-input-number>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="closeDailog">取 消</el-button>
        <el-button type="primary" @click="save()">确 定</el-button>
      </div>
    </el-dialog>

    <!-- 修改对话框 -->
    <el-dialog title="修改借阅信息" :visible.sync="editFlag" destroy-on-close>
      <el-form>

        <el-row :gutter="10">
          <el-col :span="12">
            <el-form-item label="图书名称">
              <el-select v-model="borrows.bid" placeholder="请选择图书" style="width: 100%;">
                <el-option v-for="item in book" :label="item.bname" :value="item.bid">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="借阅者">
              <el-select v-model="borrows.names" placeholder="请选择借阅者" style="width: 100%;">
                <el-option v-for="item in user" :label="item.uname" :value="item.uname">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="10">
          <el-col :span="12">

            <el-form-item label="借出时间">
              <el-date-picker v-model="borrows.outtime" type="date" placeholder="选择日期" format="yyyy 年 MM 月 dd 日"
                value-format="yyyy-MM-dd" style="width: 100%;" :picker-options="pickerOptions">
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="借阅数量">
              <el-input-number style="width: 100%;" v-model="borrows.quantity"></el-input-number>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="closeDailog">取 消</el-button>
        <el-button type="primary" @click="update()">确 定</el-button>
      </div>
    </el-dialog>

  </el-card>
</template>

<script>
export default {
  data () {
    return {
      tableData: [],
      pickerOptions: {
        disabledDate (time) {
          return time.getTime() > Date.now()
        }
      },
      pager: {
        page: 1,
        size: 5,
        total: 0
      },
      borrows: {
        boid: null,
        bid: null,
        names: null,
        outtime: null,
        initme: null,
        quantity: null,
        stat: null
      },
      addFlag: false,
      editFlag: false,
      user: [],
      book: []
    }
  },
  methods: {
    changeStat (row) {
      if (this.borrows.quantity <= 0) {
        this.borrows.stat = 1
      } else {
        this.borrows.stat = 0
      }

      this.borrows = {
        boid: row.boid,
        bid: row.bid,
        names: row.names,
        outtime: row.outtime,
        initme: row.initme,
        quantity: row.quantity,
        stat: row.stat
      }

      this.$http.post('http://localhost/tbBorrows/changeStat', this.borrows)
    },
    giveback (row) {
      if (row.quantity <= 0) {
        this.$message.error('此书以全部归还，无需再次归还')
      } else {
        this.borrows = {
          boid: row.boid,
          bid: row.tbBook.bid,
          quantity: row.quantity - 1
        }
        console.log(this.borrows)
        this.$http.post('http://localhost/tbBorrows/giveback?bid=' + this.borrows.bid, this.borrows)
          .then(response => {
            if (response.data.code === 200) {
              this.$message({
                message: '恭喜你，归还成功',
                type: 'success'
              })
              this.changeStat(this.borrows)
              this.closeDailog()
              this.listPage()
            }
          }).catch(error => {
            this.$message.error('网络错误，请稍后重试' + error)
          })
      }
    },

    update () {
      this.$http.post('http://localhost/tbBorrows/update?bid=' + this.borrows.bid, this.borrows)
        .then(response => {
          if (response.data.code === 200) {
            this.$message({
              message: '恭喜你，修改成功',
              type: 'success'
            })
            this.changeStat(this.borrows)
            this.closeDailog()
            this.listPage()
          } else {
            this.$message.error('修改失败，请重试')
          }
        }).catch(error => {
          this.$message.error('网络错误，请稍后重试 ' + error)
        })
    },
    remove (row) {
      this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$http.post('http://localhost/tbBorrows/remove?boid=' + row.boid)
          .then(response => {
            if (response.data.code === 200) {
              this.$message({
                message: '恭喜你，删除成功',
                type: 'success'
              })
            } else {
              this.$message.error('删除失败，请重试')
            }
            this.listPage()
          }).catch(error => {
            this.$message.error('网络错误，请稍后重试' + error)
          })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    },
    save () {
      this.$http.post('http://localhost/tbBorrows/save?bid=' + this.borrows.bid, this.borrows)
        .then(response => {
          if (response.data.code === 200) {
            this.$message({
              message: '恭喜你，添加成功',
              type: 'success'
            })
            this.changeStat(this.borrows)
            this.closeDailog()
            this.listPage()
          } else {
            this.$message.error('添加失败，请重试')
          }
        }).catch(error => {
          this.$message.error('网络异常，请稍后重试' + error)
        })
    },
    getUserList () {
      this.$http.get('http://localhost/tbUser/list')
        .then(response => {
          this.user = response.data.data
          console.log(this.user[0].uname)
        })
    },
    getBookList () {
      this.$http.get('http://localhost/tbBook/list')
        .then(response => {
          this.book = response.data.data
        })
    },
    listPage () {
      this.$http.get('http://localhost/tbBorrows/listPage', {
        params: {
          page: this.pager.page,
          size: this.pager.size,
          keywords: this.borrows.names
        }
      }).then(response => {
        this.pager.total = response.data.data.total
        this.tableData = response.data.data.rows
      }).catch(error => {
        alert('网络错误' + error)
      })
    },
    handleSizeChange (val) {
      this.pager.size = val
      this.listPage()
    },
    handleCurrentChange (val) {
      this.pager.page = val
      this.listPage()
    },
    closeDailog () {
      this.addFlag = false
      this.editFlag = false
      this.borrows = {}
      this.user = {}
      this.book = {}
    },
    openAddDailog () {
      this.borrows = {
        boid: null,
        bid: null,
        names: null,
        outtime: null,
        initme: null,
        quantity: null,
        stat: null
      }
      this.addFlag = !this.addFlag
      this.getBookList()
      this.getUserList()
    },
    openEditDailog (row) {
      this.editFlag = !this.editFlag
      this.getBookList()
      this.getUserList()
      this.borrows = {
        boid: row.boid,
        bid: row.tbBook.bid,
        names: row.names,
        outtime: row.outtime,
        initme: row.initme,
        quantity: row.quantity
      }
    }
  },
  mounted () {
    this.listPage()
  }
}
</script>

<style>
  .el-pagination {
    margin-top: 20px;
  }

  .el-breadcrumb {
    margin-bottom: 20px;
  }

  .el-form-item {
    margin: 4px;
  }
</style>
