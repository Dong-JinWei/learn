<template>

  <el-card class="box-card">
    <div slot="header" class="header-card">
      <span>图书借阅管理系统</span>
    </div>
    <el-form :model="user" :rules="rules" ref="user">
      <el-form-item prop="uname">
        <el-input suffix-icon="el-icon-user-solid" v-model="user.uname" clearable placeholder="请输入用户名称"></el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input suffix-icon="el-icon-s-goods" v-model="user.password" clearable type="password" placeholder="请输入密码">
        </el-input>
      </el-form-item>
      <el-button type="success" plain @click="login">登录</el-button>
    </el-form>

  </el-card>
</template>

<script>
export default {
  data () {
    return {
      rules: {
        uname: [{
          required: true,
          message: '请输入用户名称',
          trigger: 'blur'
        }],
        password: [{
          required: true,
          message: '请输入密码',
          trigger: 'blur'
        }]
      },
      user: {
        uname: '',
        password: ''
      }
    }
  },
  methods: {
    login () {
      this.$refs['user'].validate((valid) => {
        if (valid) {
          this.$http.get('http://localhost:80/tbUser/login', {
            params: {
              uname: this.user.uname,
              password: this.user.password
            }
          })
            .then(response => {
              console.log(response)
              if (response.data.message === 'no') {
                this.$message.error('不存在此用户，请检查用户名是否正确')
              } else if (response.data.message === 'error') {
                this.$message.error('密码错误，请重新输入')
              } else {
                sessionStorage.setItem('user', JSON.stringify(response.data.data))
                this.$router.push('/welcome')
              }
            })
            .catch(e => {
              this.$message.error('网络异常，请稍后重试')
            })
        }
      })
    }
  }
}
</script>

<style scoped>
  .box-card {
    width: 550px;
    height: 280px;
    border-radius: 10px;
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
    box-shadow: 10px 20px 30px #888888;
  }

  .login-form {
    position: absolute;
    bottom: 0px;
    width: 100%;
    padding: 0px 20px;
    box-sizing: border-box;
  }

  .el-button {
    display: flex;
    justify-content: center;
    width: 100%;
    font-weight: bold;
    height: 40px;
    font-size: 18px;
    border-radius: 10px;
  }

  .header-card {
    display: flex;
    justify-content: center;
    font-size: 18px;
  }

  .el-input {
    border-radius: 10px;
    height: 50px;
    font-size: 18px;
    border-bottom-color: green;

  }
</style>
