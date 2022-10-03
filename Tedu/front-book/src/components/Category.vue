<template>
  <el-card>
    <!-- 面包屑组件 -->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/welcome' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>图书信息管理</el-breadcrumb-item>
      <el-breadcrumb-item>图书类别管理</el-breadcrumb-item>
    </el-breadcrumb>

    <!-- 表格数据组件 -->
    <el-row :gutter="10">
      <el-col :span="6">
        <el-input placeholder="请输入查询图书类别查询" v-model="category.catename" clearable @change="listPage">
        </el-input>
      </el-col>
      <el-col :span="2">
          <el-button type="primary" plain icon="el-icon-search">搜索</el-button>
      </el-col>
      <el-col :span="2">
        <el-button type="primary" plain @click="openAddDialog()" icon="el-icon-plus">添加</el-button>
      </el-col>
    </el-row>
    <el-table :data="tableData" style="width: 100%;" stripe>
      <el-table-column width="150px" prop="cateid" label="图书类别id" />
      <el-table-column prop="catename" label="图书类别名称" />
      <el-table-column prop="createtime" label="创建时间" />
      <el-table-column prop="modifytime" label="修改时间" />
      <el-table-column label="操" align="right">
        <template slot-scope="rows">
          <el-button size="mini" plain type="primary" icon="el-icon-edit" @click="openEditDailog(rows.row)"></el-button>
        </template>
      </el-table-column>
      <el-table-column label="做" align="left">
        <template slot-scope="rows">
          <el-button size="mini" plain type="primary" icon="el-icon-delete" @click="remove(rows.row)"></el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="pager.page"
      :page-sizes="[5, 10, 15, 20]" :page-size="pager.size" layout="total, sizes, prev, pager, next, jumper"
      :total="pager.total">
    </el-pagination>

    <!--添加对话框组件-->
    <el-dialog title="添加" :visible.sync="addFlag">
      <el-form>
        <el-form-item label="图书类别名称">
          <el-input v-model="category.catename"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="closeDialog">取 消</el-button>
        <el-button type="primary" @click="save()">保 存</el-button>
      </div>
    </el-dialog>

    <!--修改对话框组件-->
    <el-dialog title="修改" :visible.sync="editFlag">
      <el-form>
        <el-form-item label="图书类别名称">
          <el-input v-model="category.catename"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="closeDialog">取 消</el-button>
        <el-button type="primary" @click="update()">保 存</el-button>
      </div>
    </el-dialog>
  </el-card>

</template>

<script>
  export default {
    data() {
      return {
        addFlag: false,
        editFlag: false,
        tableData: [],
        pager: { // 封装一个分页对象
          page: 1,
          size: 5,
          total: 0

        },
        category: {
          cateid: null,
          catename: ''
        }
      }
    },
    methods: {
      closeDialog() {
        this.editFlag = false;
        this.addFlag = false;
        this.category = {
          cateid: null,
          catename: null
        }
      },
      openEditDialog(row) {
        this.editFlag = !this.editFlag;
        this.category = {
          cateid: row.cateid,
          catename: row.catename
        }
      },
      update() {
        this.$http.post('http://localhost/tbCategory/update', this.category)
          .then(response => {
            if (response.data.code == 200) {
              this.$message({
                message: '恭喜你，修改成功成功',
                type: 'success'
              });
              this.editFlag = false;
            } else {
              this.$message.error('修改失败，请重试');
            }
            this.category = {
              cateid: null,
              catename: null
            }
            listPage();
          })
          .catch(error => {
            this.$message.error('网络错误，请稍后重试 ')
          })
      },

      remove(row) {
        this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$http.post('http://localhost/tbCategory/remove?cateid=' + row.cateid)
            .then(response => {
              if (response.data.code == 200) {
                this.$message({
                  message: '恭喜你，删除成功',
                  type: 'success'
                });
              } else {
                this.$message.error('删除失败，请重试');
              }
              this.listPage();
            }).catch(error => {
              this.$message.error('网络错误，请稍后重试');
            })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });

      },
      save() {
        this.$http.post('http://localhost/tbCategory/save', this.category)
          .then(response => {
            if (response.data.code == 200) {
              this.$message({
                message: '恭喜你，添加成功',
                type: 'success'
              });
            } else {
              this.$message.error('添加失败，请重试');
            }
          }).catch(error => {
            this.$message.error('网络异常，请稍后重试');
          })
        this.openAddDialog();
        this.category = {
          cateid: null,
          catename: null
        }
        this.listPage();
      },
      openAddDialog() {
        this.addFlag = !this.addFlag;
      },
      listPage() {
        this.$http.get('http://localhost/tbCategory/listPage', {
          params: {
            page: this.pager.page,
            size: this.pager.size,
            cname: this.category.catename
          }
        }).then(response => {
          this.pager.total = response.data.data.total;
          this.tableData = response.data.data.rows
        }).catch(error => {
          alert('网络异常');
        })
      },
      handleSizeChange(val) {
        this.pager.size = val;
        this.listPage();
      },
      handleCurrentChange(val) {
        this.pager.page = val;
        this.listPage();
      }
    },

    mounted() {
      this.listPage();
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
</style>
