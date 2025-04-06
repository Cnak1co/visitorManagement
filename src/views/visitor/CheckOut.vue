<template>
  <el-card class="checkout-card">
    <h3>访客离开登记</h3>
    <el-form @submit.prevent="handleCheckOut">
      <el-form-item label="访客姓名">
        <el-input v-model="visitorName" />
      </el-form-item>
      <el-button type="primary" native-type="submit">确认离开</el-button>
    </el-form>
  </el-card>
</template>

<script setup>
import { ref } from 'vue'

const visitorName = ref('')

const handleCheckOut = () => {
  if (!visitorName.value) {
    alert('请填写访客姓名！')
    return
  }
  alert(`访客 ${visitorName.value} 离开登记成功！`)
}
</script>

<style scoped>
.checkout-card {
  max-width: 600px;
  margin: 20px auto;
  padding: 20px;
}
</style>