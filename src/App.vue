<!-- App.vue -->
<template>
  <div id="app">
    <VisitorNavbar />
    <div class="content-box">
      <router-view v-slot="{ Component }">
        <component :is="Component" />
        
      </router-view>
    </div>
  </div>
</template>

<script>
import VisitorNavbar from './components/VisitorNavbar.vue'

export default {
  name: 'App',
  components: {
    VisitorNavbar,

  },
}
</script>

<style>
/* 全局过渡动画 */
.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.3s;
}
.fade-enter-from,
.fade-leave-to {
  opacity: 0;
}

/* 为导航栏留出空间 */
#app {
  padding-top: 60px; /* 导航栏高度 */
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  background: linear-gradient(to bottom, #f0f9ff, #cfe9ff); /* 背景渐变 */
  min-height: 100vh;
}
</style>