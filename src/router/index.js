import { createRouter, createWebHistory } from 'vue-router'
import VisitorHome from '@/views/visitor/VisitorHome.vue'
console.log(VisitorHome) // 没有报错说明别名生效
const router = createRouter({
  history: createWebHistory(),
  routes :[
    {
      path: '/',
      name: 'Home',
      component: () => import('@/views/visitor/VisitorHome.vue'),
    },
    {
      path: '/appointments',
      name: 'Appointments',
      component: () => import('@/views/visitor/VisitorAppointment.vue'),
    },
    {
      path: '/checkin',
      name: 'CheckIn',
      component: () => import('@/views/visitor/CheckIn.vue'),
    },
    {
      path: '/checkout',
      name: 'CheckOut',
      component: () => import('@/views/visitor/CheckOut.vue'),
    },
  ]
})

export default router