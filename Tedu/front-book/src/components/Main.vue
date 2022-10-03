<template>
  <el-container>
    <el-header>
      <el-row>
        <el-col :span="16">
          <el-link href="#/main" :underline="false" style="font-size: 30px;">图书借阅管理系统</el-link>
        </el-col>
        <el-col :span="8">
          <div id="info">
            {{uname}}
            <el-avatar shape="square" :size="55" :src="images" style="margin: 1px;"></el-avatar>
          </div>
        </el-col>

      </el-row>
    </el-header>
    <el-container>
      <el-aside width="200px">
        <el-menu unique-opened router background-color="#E7EAF1" text-color="#333" active-text-color="#409EFF">
          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-s-tools"></i>
              <span>系统信息管理</span>
            </template>
            <el-menu-item index="/user">
              <i class="el-icon-user"></i>
              <span>用户信息管理</span>
            </el-menu-item>
            <el-menu-item index="/log">
              <i class="el-icon-postcard"></i>
              <span>日志信息管理</span>
            </el-menu-item>
          </el-submenu>

          <el-submenu index="2">
            <template slot="title">
              <i class="el-icon-notebook-1"></i>
              <span>图书信息管理</span>
            </template>
            <el-menu-item index="/book">
              <i class="el-icon-reading"></i>
              <span>馆藏信息管理</span>
            </el-menu-item>
            <el-menu-item index="/category">
              <i class="el-icon-takeaway-box"></i>
              <span>图书类别管理</span>
            </el-menu-item>
          </el-submenu>

          <el-submenu index="3">
            <template slot="title">
              <i class="el-icon-tickets"></i>
              <span>借阅信息管理</span>
            </template>
            <el-menu-item index="/borrow">
              <i class="el-icon-star-off"></i>
              <span>借阅信息管理</span>
            </el-menu-item>
          </el-submenu>
        </el-menu>

      </el-aside>
      <el-main>

        <!-- 路由显示器 -->
        <router-view>

        </router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  data () {
    return {
      uname: null,
      images: null

    }
  },
  methods: {
    show () {
      let userInfo = JSON.parse(sessionStorage.getItem('user'))
      this.uname = userInfo.uname
      this.images = userInfo.images
    },
    note () {
      (function () {
        var a_idx = 0
        window.onclick = function (event) {
          var a = new Array('富强', '民主', '文明', '和谐', '自由', '平等', '公正', '法治', '爱国', '敬业', '诚信', '友善')
          var heart = document.createElement('b') // 创建b元素
          heart.onselectstart = new Function('event.returnValue=false') // 防止拖动
          document.body.appendChild(heart).innerHTML = a[a_idx] // 将b元素添加到页面上
          a_idx = (a_idx + 1) % a.length
          heart.style.cssText = 'position: fixed;left:-100%;' // 给p元素设置样式
          var f = 16, // 字体大小
            x = event.clientX - f / 2, // 横坐标
            y = event.clientY - f, // 纵坐标
            c = randomColor(), // 随机颜色
            a = 1, // 透明度
            s = 1.2 // 放大缩小
          var timer = setInterval(function () { // 添加定时器
            if (a <= 0) {
              document.body.removeChild(heart)
              clearInterval(timer)
            } else {
              heart.style.cssText = 'font-size:16px;cursor: default;position: fixed;color:' +
                  c + ';left:' + x + 'px;top:' + y + 'px;opacity:' + a + ';transform:scale(' +
                  s + ');'
              y--
              a -= 0.016
              s += 0.002
            }
          }, 15)
        }
        // 随机颜色
        function randomColor () {
          return 'rgb(' + (~~(Math.random() * 255)) + ',' + (~~(Math.random() * 255)) + ',' + (~~(Math
            .random() * 255)) + ')'
        }
      }())
    }
  },
  mounted () {
    this.note()
    this.show()
  }
}
</script>

<style>
  .el-header {
    background-color: #B3C0D1;
    color: #333;
    justify-content: space-between;
    align-items: center;
    font-size: 18px;
    line-height: 60px;
  }

  .el-aside {
    background-color: #D3DCE6;
    color: #333;
  }

  .el-main {
    background-color: #E9EEF3;
    color: #333;
  }

  .el-container {
    height: 100%;
  }

  #info {
    float: right;
  }
</style>
