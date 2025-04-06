<template>
  <div class="home">
    <h1>欢迎您的来访！</h1>
    <p class="subtitle">请选择功能以继续操作</p>
    <div class="function-cards">
      <!-- 线上预约管理卡片 -->
      <el-card class="card" shadow="hover" @click="$router.push('/appointments')">
        <div class="card-content">
          <h3>线上预约管理</h3>
          <p>预约查询、修改、取消</p>
        </div>
      </el-card>

      <!-- 到访签到卡片 -->
      <el-card class="card" shadow="hover" @click="$router.push('/checkin')">
        <div class="card-content">
          <h3>到访签到</h3>
          <p>实时记录访客状态</p>
        </div>
      </el-card>

      <!-- 离开登记卡片 -->
      <el-card class="card" shadow="hover" @click="$router.push('/checkout')">
        <div class="card-content">
          <h3>离开登记</h3>
          <p>实时记录访客状态</p>
        </div>
      </el-card>
    </div>
  </div>
</template>

<script>
export default {
  name: 'VisitorHome',
  mounted() {
    console.log('VisitorHome.vue 已挂载成功！')
  }
}
</script>

<style scoped>
.home {
  margin-top: 0;
  padding-top: 20px; /* 如果需要额外的顶部间距 */
  background: linear-gradient(to bottom, #f0f9ff, #cfe9ff); /* 背景渐变 */
  min-height: calc(100vh - 60px); /* 减去导航栏高度 */
}

.subtitle {
  font-size: 16px;
  color: #666;
  margin-top: 10px;
}

.function-cards {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(250px, 1fr)); /* 响应式布局 */
  gap: 20px;
  margin-top: 30px;
  justify-content: center;
}

.card {
  cursor: pointer;
  transition: transform 0.3s, box-shadow 0.3s;
  text-align: center;
  padding: 20px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  border-radius: 10px; /* 圆角 */
  background: #fff;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

.card:hover {
  transform: translateY(-10px);
  box-shadow: 0 8px 15px rgba(0, 0, 0, 0.2);
}

.card-content h3 {
  font-size: 20px;
  color: #409EFF; /* 蓝色标题 */
  margin-bottom: 10px;
}

.card-content p {
  font-size: 14px;
  color: #666;
}

h1 {
  font-size: 28px;
  color: #333;
  font-weight: bold;
}

@media (max-width: 768px) {
  .home {
    margin-top: 30px;
  }

  h1 {
    font-size: 24px;
  }

  .subtitle {
    font-size: 14px;
  }

  .card-content h3 {
    font-size: 18px;
  }

  .card-content p {
    font-size: 12px;
  }
}
</style>