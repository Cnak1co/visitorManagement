import { defineStore } from 'pinia'

export const useAuthStore = defineStore('auth', {
  state: () => ({
    user: null, // 当前用户信息
  }),
  actions: {
    login(user) {
      this.user = user
    },
    logout() {
      this.user = null
    },
  },
})