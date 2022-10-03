import Vue from 'vue'
import Router from 'vue-router'
import Main from '../components/Main.vue'
import User from '../components/User.vue'
import Book from '../components/Book.vue'
import Log from '../components/Log.vue'
import Borrow from '../components/Borrow.vue'
import Category from '../components/Category.vue'
import Welcome from '../components/Welcome.vue'
import Login from '../components/Login.vue'


Vue.use(Router)

let router = new Router({
  routes: [{
      path: '/',
      redirect: '/login'
    },
    {
      path: '/login',
      component: Login
    },
    {
      path: '/main',
      component: Main,
      redirect: "/welcome",
      children: [{
        path: '/user',
        component: User
      }, {
        path: '/log',
        component: Log
      }, {
        path: '/book',
        component: Book
      }, {
        path: '/borrow',
        component: Borrow
      }, {
        path: '/category',
        component: Category
      }, {
        path: '/welcome',
        component: Welcome
      }]
    }
  ]
})

router.beforeEach((to, from, next) => {
  if (to.path == '/login') {
    next();
  } else {
    if (sessionStorage.getItem("user") != null) {
      next();
    } else {
      alert('请登录后使用！')
      next({
        path: '/login'
      })
    }
  }
})

export default router
