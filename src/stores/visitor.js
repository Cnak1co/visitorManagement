import { defineStore } from 'pinia'
import api from '@/services/api'

export const useVisitorStore = defineStore('visitor', {
  state: () => ({
    appointments: [],
    checkIns: [],
    visitors: [],
  }),
  actions: {
    // 预约登记
    async createAppointment(data) {
      const res = await api.post('/appointments', data)
      this.appointments.push(res.data)
    },
    // 签到登记
    async checkIn(visitorId) {
      if (!visitorId) {
        alert('访客ID不能为空！')
        return
      }
      this.visitors.push(visitorId)
      alert(`访客 ${visitorId} 签到成功！`)
      const res = await api.post('/check-ins', { vid: visitorId })
      this.checkIns.push(res.data)
    }
  }
})