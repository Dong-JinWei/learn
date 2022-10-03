<template>
  <el-card>
    <el-breadcrumb>
      <el-breadcrumb-item :to="{path:'/welcome'}">首页</el-breadcrumb-item>
      <el-breadcrumb-item>系统信息管理</el-breadcrumb-item>
      <el-breadcrumb-item>日志信息管理</el-breadcrumb-item>
    </el-breadcrumb>
    <el-table :data="tableData" style="width: 100%;" stripe>
      <el-table-column prop="methods" type="expand">
        <template slot-scope="props">
          <el-form label-position="left" style="margin-left: 60px;" inline class="demo-table-expand">
            <el-tag type="info">
              <el-form-item label="操作方法">
                <span>{{props.row.methods}}</span>
              </el-form-item>
            </el-tag>

          </el-form>
        </template>
      </el-table-column>
      <el-table-column prop="ip" label="操作 IP" />
      <el-table-column prop="ddesc" label="操作描述" />
      <el-table-column prop="createtime" label="操作时间" />
    </el-table>
    <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="pager.page"
      :page-sizes="[5, 10, 15, 20]" :page-size="pager.size" layout="total, sizes, prev, pager, next, jumper"
      :total="pager.total">
    </el-pagination>
  </el-card>
</template>

<script>
  export default {
    data() {
      return {
        tableData: [],
        pager: {
          page: 1,
          size: 10,
          total: 0
        }
      }
    },
    methods: {
      handleSizeChange(val) {
        this.pager.size = val;
        this.listPage();
      },
      handleCurrentChange(val) {
        this.pager.page = val;
        this.listPage();
      },
      listPage() {
        this.$http.get('http://localhost/tbLog/listPage', {
          params: {
            page: this.pager.page,
            size: this.pager.size
          }
        }).then(response => {
          console.log("++");
          console.log(response);
          this.pager.total = response.data.data.total
          this.tableData = response.data.data.rows
        }).catch(error => {
          alert('网络异常');
        })
      }
    },
    mounted() {
      this.listPage();
    }
  }
</script>

<style>
  .el-pagination .el-breadcrumb {
    margin-top: 20px;
  }

  .el-breadcrumb {
    margin-bottom: 10px;
  }
</style>
