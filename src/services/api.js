import axios from 'axios'

const api = axios.create({
  baseURL: 'http://your-springboot-api.com'
})

// 拦截器处理Token等
api.interceptors.request.use(config => {
  config.headers.Authorization = `Bearer ${localStorage.getItem('token')}`
  return config
})

export default api