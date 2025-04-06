<template>
  <el-card class="checkin-card">
    <h3>访客到访签到</h3>
    <el-form @submit.prevent="handleCheckIn">
      <el-form-item label="访客姓名">
        <el-input v-model="visitorName" />
      </el-form-item>
      <el-form-item label="访客手机号">
        <el-input v-model="visitorPhone" />
      </el-form-item>
      <el-button type="primary" native-type="submit">确认签到</el-button>
    </el-form>
  </el-card>
</template>

<script setup>
import { ref } from 'vue'

const visitorName = ref('')
const visitorPhone = ref('')

const handleCheckIn = () => {
  if (!visitorName.value || !visitorPhone.value) {
    alert('请填写完整信息！')
    return
  }
  alert(`访客 ${visitorName.value} 签到成功！`)
}
</script>

<style scoped>
.checkin-card {
  max-width: 600px;
  margin: 20px auto;
  padding: 20px;
}
</style>