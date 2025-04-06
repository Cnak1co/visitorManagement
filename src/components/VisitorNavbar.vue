<template>
  <el-menu
    class="navbar-container"
    mode="horizontal"
    background-color="#6cb4f0" 
    text-color="#fff" 
    active-text-color="#FFD700" 
    :router="true"
  >
    <!-- 系统标题 -->
    <router-link to="/" class="logo-link">
      <span class="system-title">访客管理系统</span>
    </router-link>

    <!-- 导航菜单 -->
    <div class="menu-items">
      <el-menu-item index="/">
        首页
      </el-menu-item>
      <el-menu-item index="/appointments">
        预约管理
      </el-menu-item>
      <el-menu-item index="/checkin">
        签到登记
      </el-menu-item>
      <el-menu-item index="/checkout">
        签退登记
      </el-menu-item>
    </div>

    <!-- 用户功能区 -->
    <div class="user-area">
      <template v-if="authStore.user">
        <el-dropdown>
          <span class="user-info">
            <el-avatar :size="32" :src="authStore.user.avatar" />
            <span class="username">{{ authStore.user.uRealname }}</span>
          </span>
          <template #dropdown>
            <el-dropdown-menu>
              <el-dropdown-item>个人中心</el-dropdown-item>
              <el-dropdown-item divided @click="handleLogout">
                退出登录
              </el-dropdown-item>
            </el-dropdown-menu>
          </template>
        </el-dropdown>
      </template>
      <template v-else>
        <el-button link @click="$router.push('/login')">登录</el-button>
        <el-divider direction="vertical" />
        <el-button link @click="$router.push('/register')">注册</el-button>
      </template>
    </div>
  </el-menu>
</template>

<script setup>
import { useAuthStore } from '@/stores/auth'
import { useRouter } from 'vue-router'

const authStore = useAuthStore()
const router = useRouter()

// 注销处理
const handleLogout = () => {
  authStore.logout()
  router.push('/login')
}
</script>

<style lang="scss" scoped>
.navbar-container {
  display: flex;
  align-items: center;
  padding: 0 20px;
  position: fixed;
  top: 0;
  width: 100%;
  z-index: 1000;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  background-color: #6cb4f0; /* 深蓝色背景 */

  .logo-link {
    display: flex;
    align-items: center;
    margin-right: auto;
    .system-title {
      color: #fff; /* 白色文字 */
      font-size: 20px;
      font-weight: bold;
      margin-left: 10px;
    }
  }

  .menu-items {
    flex: 1;
    display: flex;
    justify-content: center;
    :deep(.el-menu-item) {
      padding: 0 25px;
      cursor: pointer;
      color: #fff; /* 白色文字 */
    }
  }

  .user-area {
    margin-left: auto;
    display: flex;
    align-items: center;
    .user-info {
      display: flex;
      align-items: center;
      cursor: pointer;
      .username {
        color: #fff; /* 白色文字 */
        margin-left: 8px;
        font-size: 14px;
      }
    }
    .el-button {
      color: #fff; /* 白色文字 */
      &:hover {
        color: #FFD700; /* 激活状态为金黄色 */
      }
    }
  }
}

@media (max-width: 768px) {
  .navbar-container {
    padding: 0 10px;
    .menu-items {
      display: none;
    }
    .system-title {
      font-size: 16px !important;
    }
  }
}

.navbar-container {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 60px; /* 导航栏高度 */
  background-color: #6cb4f0; /* 导航栏背景色 */
  z-index: 1000;
  box-shadow: 0 2px 12px rgba(0, 0, 0, 0.1);
}
</style>