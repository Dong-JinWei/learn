<template>
  <el-card>
    <el-breadcrumb>
      <el-breadcrumb-item :to="{path: '/welcome'}">首页</el-breadcrumb-item>
      <el-breadcrumb-item>图书信息管理</el-breadcrumb-item>
      <el-breadcrumb-item>馆藏信息管理</el-breadcrumb-item>
    </el-breadcrumb>

    <el-row :gutter="10">
      <el-col :span="6">
        <el-input placeholder="请输入内容" v-model="book.bname" clearable @change="listPage()">
        </el-input>
      </el-col>

      <el-col :span="2">
        <el-button type="primary" plain icon="el-icon-search">搜索</el-button>
      </el-col>

      <el-col :span="2">
        <el-button type="primary" plain icon="el-icon-plus" @click="openAddDailog()">添加</el-button>
      </el-col>

      <el-col :span="2">
        <el-link href="http://localhost/tbBook/excel" :underline="false"><el-button type="primary" plain >导出</el-button></el-link>
      </el-col>
    </el-row>

    <el-table :data="tableData" style="width: 100%;" stripe>
      <el-table-column prop="bid" width="65px" label="图书id" align="center"></el-table-column>
      <el-table-column prop="bnum" width="80px" label="图书编号" align="center"></el-table-column>
      <el-table-column prop="bname" label="书名" align="center"></el-table-column>
      <el-table-column prop="author" label="作者" align="center"></el-table-column>
      <el-table-column prop="price" label="价格(元)" align="center"></el-table-column>
      <el-table-column prop="category.catename" label="图书分类" align="center"></el-table-column>
      <el-table-column prop="instruction" label="介绍" :show-overflow-tooltip='true' align="center"></el-table-column>
      <el-table-column prop="quantity" label="数量(本)" align="center"></el-table-column>
      <el-table-column prop="createtime" label="创建时间" align="center"></el-table-column>
      <el-table-column prop="modifytime" label="修改时间" align="center"></el-table-column>
      <el-table-column label="操做" width="150px" align="center">
        <template slot-scope="rows">
          <el-button size="mini" plain type="primary" icon="el-icon-edit" @click="openEditDailog(rows.row)"></el-button>
          <el-button size="mini" plain type="primary" icon="el-icon-delete" @click="remove(rows.row)"></el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="pager.page"
      :page-sizes="[5, 10, 15, 20]" :page-size="pager.size" layout="total, sizes, prev, pager, next, jumper"
      :total="pager.total">
    </el-pagination>

    <!-- 添加对话框 -->
    <el-dialog title="添加图书" :visible.sync="addFlag" destroy-on-close>

      <el-form :rules="rules" ref="book" :model="book">
        <el-row :gutter="10">
          <el-col :span="12">
            <el-form-item label="图书编号" prop="bnum">
              <el-input v-model="book.bnum"></el-input>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="书名" prop="bname">
              <el-input v-model="book.bname"></el-input>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="10">
          <el-col :span="12">
            <el-form-item label="作者" prop="author">
              <el-input v-model="book.author"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="图书分类" prop="cateid">
              <el-select v-model="book.cateid" placeholder="请选择图书类别" style="width: 100%;">
                <el-option v-for="item in category" :key="item.index" :label="item.catename" :value="item.cateid">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="10">
          <el-col :span="12">
            <el-form-item label="图书价格" prop="price">
              <el-input v-model="book.price"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="库存数量" prop="quantity">
              <el-input v-model="book.quantity"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="10">
          <el-col :span="24">
            <el-form-item label="介绍" prop="instruction">
              <el-input type="textarea" v-model="book.instruction"></el-input>
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
    <el-dialog title="修改图书" :visible.sync="editFlag" destroy-on-close>
      <el-form :rules="rules" ref="book" :model="book">
        <el-row :gutter="10">
          <el-col :span="12">
            <el-form-item label="图书编号" prop="bnum">
              <el-input v-model="book.bnum"></el-input>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="书名" prop="bname">
              <el-input v-model="book.bname"></el-input>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="10">
          <el-col :span="12">
            <el-form-item label="作者" prop="author">
              <el-input v-model="book.author"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="图书分类" prop="cateid">
              <el-select v-model="book.cateid" placeholder="请选择图书类别" style="width: 100%;">
                <el-option v-for="item in category" :key="item.index" :label="item.catename" :value="item.cateid">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="10">
          <el-col :span="12">
            <el-form-item label="图书价格" prop="price">
              <el-input v-model="book.price"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="库存数量" prop="quantity">
              <el-input v-model="book.quantity"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="10">
          <el-col :span="24">
            <el-form-item label="介绍" prop="instruction">
              <el-input type="textarea" v-model="book.instruction"></el-input>
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
      book: {
        bid: null,
        bnum: null,
        bname: null,
        price: null,
        author: null,
        instruction: null,
        quantity: null,
        createtime: null,
        modifytime: null,
        cateid: null
      },
      rules: {
        bnum: [{
          required: true,
          message: '请输入图书编号',
          trigger: 'blur'
        }],
        bname: [{
          required: true,
          message: '请输入图书名称',
          trigger: 'blur'
        }],
        price: [{
          required: true,
          message: '请输入图书价格',
          trigger: 'blur'
        }],
        author: [{
          required: true,
          message: '请输入图书作者',
          trigger: 'blur'
        }],
        instruction: [{
          required: true,
          message: '请输入图书介绍',
          trigger: 'blur'
        }],
        quantity: [{
          required: true,
          message: '请输入库存数量',
          trigger: 'blur'
        }],
        cateid: [{
          required: true,
          message: '请输入类别',
          trigger: 'blur'
        }]

      },
      category: [],
      pager: {
        page: 1,
        size: 5,
        total: 0
      },
      addFlag: false,
      editFlag: false
    }
  },
  methods: {
    getCategory () {
      this.$http.get('http://localhost/tbCategory/list')
        .then(response => {
          this.category = response.data.data
        })
    },

    update () {
      this.$refs['book'].validate(valid => {
        if (valid) {
          this.$http.post('http://localhost/tbBook/update?cateid=' + this.book.cateid, this.book)
            .then(response => {
              if (response.data.code == 200) {
                this.$message({
                  message: '恭喜你，修改成功成功',
                  type: 'success'
                })
                this.closeDailog()
                this.listPage()
              } else {
                this.$message.error('修改失败，请重试')
              }
            }).catch(error => {
              this.$message.error('网络错误，请稍后重试 ' + error)
            })
        }
      })
    },

    closeDailog () {
      this.editFlag = false
      this.addFlag = false
      this.book.bname = null
    },
    remove (row) {
      this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$http.post('http://localhost/tbBook/remove?bid=' + row.bid)
          .then(response => {
            if (response.data.code == 200) {
              this.$message({
                message: '恭喜你，删除成功',
                type: 'success'
              })
            } else {
              this.$message.error('删除失败，请重试')
            }
            this.listPage()
          }).catch(error => {
            this.$message.error('网络错误，请稍后重试')
          })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    },
    save () {
      this.$refs['book'].validate(valid => {
        if (valid) {
          this.$http.post('http://localhost/tbBook/save?cateid=' + this.book.cateid, this.book)
            .then(response => {
              if (response.data.code == 200) {
                this.$message({
                  message: '恭喜你，添加成功',
                  type: 'success'
                })
                this.closeDailog()
              } else {
                this.$message.error('添加失败，请重试')
              }
              this.listPage()
            }).catch(error => {
              this.$message.error('网络异常，请稍后重试')
            })
        } else {
          this.$message.error('请将表单填写完整')
        }
      })
    },
    closeDailog () {
      this.editFlag = false
      this.addFlag = false
      this.book = {
        bid: null,
        bnum: null,
        bname: null,
        price: null,
        author: null,
        instruction: null,
        quantity: null,
        createtime: null,
        modifytime: null,
        cateid: null
      }
    },

    openEditDailog (row) {
      this.editFlag = !this.editFlag
      this.book = {
        bid: row.bid,
        bnum: row.bnum,
        bname: row.bname,
        price: row.price,
        author: row.author,
        instruction: row.instruction,
        quantity: row.quantity,
        cateid: row.category.cateid
      }
      this.getCategory()
    },
    openAddDailog () {
      this.book = {}
      this.addFlag = !this.addFlag
      this.getCategory()
    },
    handleSizeChange (val) {
      this.pager.size = val
      this.listPage()
    },
    handleCurrentChange (val) {
      this.pager.page = val
      this.listPage()
    },
    listPage () {
      this.$http.get('http://localhost/tbBook/listPage', {
        params: {
          page: this.pager.page,
          size: this.pager.size,
          bname: this.book.bname
        }
      }).then(response => {
        this.pager.total = response.data.data.total
        this.tableData = response.data.data.rows
      }).catch(error => {
        alert('网络错误')
      })
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

  .el-tooltip__popper {
    width: 300px;
    /* background: #D5DCE5 !important; */
    margin-bottom: -25px !important;
  }
</style>
