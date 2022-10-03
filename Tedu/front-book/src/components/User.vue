<template>
  <el-card>
    <el-breadcrumb>
      <el-breadcrumb-item :to="{path: '/welcome'}">首页</el-breadcrumb-item>
      <el-breadcrumb-item>系统信息管理</el-breadcrumb-item>
      <el-breadcrumb-item>户信息管理</el-breadcrumb-item>
    </el-breadcrumb>

    <!-- 表格数据组件 -->
    <el-row :gutter="10">
      <el-col :span="6">
        <el-input placeholder="请输入内容" v-model="user.uname" clearable @change="listPage()">
        </el-input>
      </el-col>

      <el-col :span="2">
        <el-button type="primary" plain icon="el-icon-search">搜索</el-button>
      </el-col>

      <el-col :span="2">
        <el-button type="primary" plain icon="el-icon-plus" @click="openAddDailog()">添加</el-button>
      </el-col>
    </el-row>
    <el-table :data="tableData" style="width: 100%;" stripe>
      <el-table-column prop="uid" label="用户id" />
      <el-table-column prop="uname" label="用户名称" />
      <el-table-column prop="password" label="密码" />
      <el-table-column label="头像" prop="images">
        <template slot-scope="scope">
          <el-avatar shape="square" :src="scope.row.images"></el-avatar>
        </template>
      </el-table-column>
      <el-table-column prop="sex" label="性别" />
      <el-table-column prop="createtime" label="创建时间" />
      <el-table-column prop="modifytime" label="修改时间" />
      <el-table-column prop="stat" label="状态">
        <template slot-scope="scope">
          <el-switch v-model="scope.row.stat" active-color="#13ce66" inactive-color="#ff4949" :active-value="0"
            :inactive-value="1" @change="changeStat(scope.row)">
          </el-switch>
        </template>
      </el-table-column>

      <el-table-column width="80px" label="操" align="right">
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

    <!-- 添加对话框 -->
    <el-dialog title="添加用户" :visible.sync="addFlag" destroy-on-close>
      <el-form :rules="rules" :model="user" ref="user">
        <el-form-item label="用户名称" prop="uname">
          <el-input v-model="user.uname"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input v-model="user.password"></el-input>
        </el-form-item>
        <el-form-item label="性别" style="text-align: center;" prop="sex">
          <template>
            <el-radio v-model="user.sex" label="男">男</el-radio>
            <el-radio v-model="user.sex" label="女">女</el-radio>
          </template>
        </el-form-item>
        <el-form-item label="头像">
          <el-upload t class="avatar-uploader" action="http://localhost/tbUser/getImagesUrl"
            :on-success="handleAvatarSuccess" :show-file-list="false">
            <img v-if="user.images" :src="user.images" class="avatar">
            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
          </el-upload>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="closeDailog">取 消</el-button>
        <el-button type="primary" @click="save()">确 定</el-button>
      </div>
    </el-dialog>

    <!-- 修改对话框 -->
    <el-dialog title="修改用户" :visible.sync="editFlag" destroy-on-close>
      <el-form :rules="rules" :model="user" ref="user">
        <el-form-item label="用户名称" prop="uname">
          <el-input v-model="user.uname"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input v-model="user.password"></el-input>
        </el-form-item>
        <el-form-item label="性别" style="text-align: center;" prop="sex">
          <template>
            <el-radio v-model="user.sex" label="男">男</el-radio>
            <el-radio v-model="user.sex" label="女">女</el-radio>
          </template>
        </el-form-item>

        <el-form-item label="头像">
          <el-upload t class="avatar-uploader" action="http://localhost/tbUser/uploadImages" :data="user"
            :on-success="handleAvatarSuccess" :show-file-list="false">
            <img v-if="user.images" :src="user.images" class="avatar">
            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
          </el-upload>
        </el-form-item>
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
      value: 0,
      pager: {
        page: 1,
        size: 5,
        total: 0
      },
      user: {
        uid: null,
        uname: null,
        password: null,
        images: null,
        sex: null,
        stat: null
      },
      addFlag: false,
      editFlag: false,
      rules: {
        uname: [{
          required: true,
          message: '请输入用户名称',
          trigger: 'blur'
        }],
        password: [{
          required: true,
          message: '请输入用户密码',
          trigger: 'blur'
        }],
        images: [{
          required: true,
          message: '请上传头像',
          trigger: 'blur'
        }],
        sex: [{
          required: true,
          message: '请输选择性别',
          trigger: 'blur'
        }]

      }
    }
  },
  methods: {
    // 上传成功后，显示图片
    handleAvatarSuccess (res, file) {
      this.user.images = URL.createObjectURL(file.raw)
    },
    changeStat (row) {
      this.user = {
        uid: row.uid,
        stat: row.stat
      }
      this.$http.post('http://localhost/tbUser/changeStat', this.user)
        .then(response => {
          if (response.data.code === 200) {
            this.$message({
              message: '恭喜你，修改成功成功',
              type: 'success'
            })
            this.listPage()
          } else {
            this.$message.error('修改失败，请重试')
          }
        }).catch(error => {
          this.$message.error('网络错误，请稍后重试 ')
        })
    },
    openEditDailog (row) {
      this.editFlag = !this.editFlag
      this.user = {
        uid: row.uid,
        uname: row.uname,
        password: row.password,
        images: row.images,
        sex: row.sex
      }
    },
    update () {
      this.$refs['user'].validate(valid => {
        if (valid) {
          this.$http.post('http://localhost/tbUser/update', this.user)
            .then(response => {
              if (response.data.code === 200) {
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
    remove (row) {
      this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$http.post('http://localhost/tbUser/remove?uid=' + row.uid)
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
      this.$refs['user'].validate(valid => {
        if (valid) {
          this.$http.post('http://localhost/tbUser/save', this.user)
            .then(response => {
              if (response.data.code === 200) {
                this.$message({
                  message: '恭喜你，添加成功',
                  type: 'success'
                })
                this.closeDailog()
                this.listPage()
              } else {
                this.$message.error('添加失败，请重试')
              }
            }).catch(error => {
              this.$message.error('网络异常，请稍后重试 ' + error)
            })
        }
      })
    },
    closeDailog () {
      this.user = {
        uid: null,
        uname: null,
        password: null,
        images: null,
        sex: null,
        stat: null
      }
      this.addFlag = false
      this.editFlag = false
    },
    openAddDailog () {
      this.addFlag = !this.addFlag
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
      this.$http.get('http://localhost/tbUser/listPage', {
        params: {
          page: this.pager.page,
          size: this.pager.size,
          uname: this.user.uname
        }
      }).then(response => {
        this.pager.total = response.data.data.total
        this.tableData = response.data.data.rows
      }).catch(error => {
        alert(error + ' 网络错误')
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
    margin: 8px;
  }

  /* 头像上传 */
  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }

  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }

  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }

  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
</style>
