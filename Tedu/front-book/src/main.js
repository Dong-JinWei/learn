// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import axios from 'axios'
import App from './App'
import router from './router'
import './assets/css/main.css'
import * as echarts from 'echarts'


Vue.config.productionTip = false
Vue.use(ElementUI)
Vue.prototype.$http = axios
/* eslint-disable no-new */
Vue.prototype.$echarts = echarts


new Vue({
  el: '#app',
  router,
  components: {
    App
  },
  template: '<App/>'
})
