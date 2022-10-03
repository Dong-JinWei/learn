<template>
  <el-card>
    <el-row :gutter="10">
      <el-col :span="6">
        <el-card>
          馆藏数量：
          <el-tag>
            {{allBookQuantity}}
          </el-tag>
          本
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card>借出数量：<el-tag>{{allBorrowsQuantity}}</el-tag> 本
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card>榜一大哥：<el-tag>{{firstName}}</el-tag>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card>大家都在看：<el-tag>{{firstBook}}</el-tag>
        </el-card>
      </el-col>
    </el-row>

    <el-card header="馆藏图书数量详情">
      <el-row :gutter="10">
        <div id="bar" style="width: 100%;height: 350%;"></div>
      </el-row>
    </el-card>

    <el-card header="馆藏图书类型分布情况">
      <el-row :gutter="10" align="center">
        <div id="pie" style="hwidth: 100%;height: 300%;"></div>
      </el-row>
    </el-card>

  </el-card>
</template>

<script>
export default {
  data () {
    return {
      allBookQuantity: null,
      allBorrowsQuantity: null,
      firstName: null,
      firstBook: null
    }
  },
  methods: {
    getFirstBook () {
      this.$http.get('http://localhost/tbBorrows/getFirstBook')
        .then(response => {
          if (response.data.code === 200) {
            this.firstBook = response.data.data
          } else {
            this.$message.error('热门书籍获取失败！')
          }
        }).catch(error => {
          this.$message.error('热门书籍获取失败，网络错误，请稍后重试 ' + error)
        })
    },

    getFirstName () {
      this.$http.get('http://localhost/tbBorrows/getFirstName')
        .then(response => {
          if (response.data.code === 200) {
            this.firstName = response.data.data
          } else {
            this.$message.error('榜一大哥获取失败！')
          }
        }).catch(error => {
          this.$message.error('榜一大哥获取失败，网络错误，请稍后重试 ' + error)
        })
    },
    getAllBorrowQuantity () {
      this.$http.get('http://localhost/tbBorrows/getAllQuantity')
        .then(response => {
          if (response.data.code === 200) {
            this.allBorrowsQuantity = response.data.data
          } else {
            this.$message.error('借阅数量获取失败！')
          }
        }).catch(error => {
          this.$message.error('借阅数量获取失败，网络错误，请稍后重试 ' + error)
        })
    },
    getAllBookQuantity () {
      this.$http.get('http://localhost/tbBook/getAllQuantity')
        .then(response => {
          if (response.data.code === 200) {
            this.allBookQuantity = response.data.data
          } else {
            this.$message.error('馆藏数量获取失败！')
          }
        }).catch(error => {
          this.$message.error('馆藏数量获取失败，网络错误，请稍后重试 ' + error)
        })
    },
    showPie () {
      let myPie = this.$echarts.init(document.getElementById('pie'))
      this.$http.get('http://localhost/tbBook/getCateNum')
        .then(response => {
          if (response.data.code === 200) {
            let myData = response.data.data
            let option = {
              tooltip: {
                trigger: 'item',
                formatter: '{b}:{c}' + '\n\r' + '({d}%)'
              },
              legend: {
                top: '5%',
                left: 'center'
              },
              series: [{
                name: '数据来自',
                type: 'pie',
                radius: ['40%', '70%'],
                avoidLabelOverlap: false,
                itemStyle: {
                  borderRadius: 10,
                  borderColor: '#fff',
                  borderWidth: 2
                },
                label: {
                  show: false,
                  position: 'center'
                },
                emphasis: {
                  label: {
                    show: true,
                    fontSize: '40',
                    fontWeight: 'bold'
                  }
                },
                labelLine: {
                  show: false
                },
                data: myData
              }]
            }
            myPie.setOption(option)
          }
        })
    },
    showBar () {
      let myBar = this.$echarts.init(document.getElementById('bar'))

      var xData = []
      var yData = []
      this.$http.get('http://localhost/tbBook/list')
        .then(response => {
          for (var item of response.data.data) {
            xData.push(item.bname)
            yData.push(item.quantity)
          }
          let option = {
            xAxis: {
              type: 'category',
              data: xData,
              axisLabel: {
                rotate: 40
              }
            },
            yAxis: {
              type: 'value'
            },
            tooltip: {
              formatter: '{b}:{c}' + '\n\r' + '本'
            },
            series: [{
              data: yData,
              type: 'bar',
              showBackground: true,
              backgroundStyle: {
                color: 'rgba(180, 180, 180, 0.2)'
              }
            }]
          }
          myBar.setOption(option)
        }).catch(error => {
          this.$message.error('查询失败' + error)
        })
    }

  },
  mounted () {
    this.showPie()
    this.showBar()
    this.getAllBookQuantity()
    this.getAllBorrowQuantity()
    this.getFirstName()
    this.getFirstBook()
  }
}
</script>

<style>
  .el-card {
    margin-top: 20px;
  }
</style>
