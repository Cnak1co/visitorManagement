<template>
  <div class="appointment-management">
    <!-- 标题 -->
    <h1 class="title">预约管理</h1>
    <p class="subtitle">管理访客预约信息，支持查询、创建和修改</p>

    <!-- 搜索与操作栏 -->
    <div class="toolbar">
      <el-input
        v-model="searchKeyword"
        placeholder="搜索预约"
        clearable
        class="search-input"
      />
      <el-button type="primary" @click="queryAppointments">查询预约</el-button>
      <el-button type="success" @click="showCreateDialog">创建预约</el-button>
    </div>

    <!-- 预约表格 -->
    <el-table :data="filteredAppointments" stripe border class="appointment-table">
      <el-table-column prop="visitorName" label="访客姓名" align="center" />
      <el-table-column prop="date" label="预约日期" align="center" />
      <el-table-column prop="purpose" label="来访目的" align="center" />
      <el-table-column prop="status" label="状态" align="center">
        <template #default="{ row }">
          <el-tag :type="statusTagType(row.status)">
            {{ row.status }}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center">
        <template #default="{ row }">
          <el-button size="small" @click="editAppointment(row)">修改</el-button>
          <el-button type="danger" size="small" @click="cancelAppointment(row)">取消</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- 新建/编辑预约弹窗 -->
    <el-dialog v-model="dialogVisible" :title="dialogTitle" width="500px">
      <el-form :model="form" label-width="100px">
        <el-form-item label="访客姓名" required>
          <el-input v-model="form.visitorName" />
        </el-form-item>
        <el-form-item label="预约日期" required>
          <el-date-picker v-model="form.date" type="datetime" />
        </el-form-item>
        <el-form-item label="来访目的" required>
          <el-input v-model="form.purpose" placeholder="请输入来访目的" />
        </el-form-item>
      </el-form>
      <template #footer>
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="submitForm">确认</el-button>
      </template>
    </el-dialog>
  </div>
</template>

<script setup>
import { ref, computed } from 'vue'
import { ElMessage } from 'element-plus'

// 模拟数据
const appointments = ref([
  { id: 1, visitorName: '张三', date: '2023-10-05 14:00', purpose: '商务洽谈', status: '预约中' },
  { id: 2, visitorName: '李四', date: '2023-10-06 10:30', purpose: '面试', status: '已签到' }
])

const searchKeyword = ref('')
const dialogVisible = ref(false)
const form = ref({ id: null, visitorName: '', date: '', purpose: '' })

// 查询预约
const queryAppointments = () => {
  if (!searchKeyword.value) {
    ElMessage.warning('请输入搜索关键词')
    return
  }
  ElMessage.success(`查询成功，关键词：${searchKeyword.value}`)
}

// 计算属性：过滤预约
const filteredAppointments = computed(() => {
  return appointments.value.filter(app =>
    app.visitorName.includes(searchKeyword.value)
  )
})

// 状态标签类型
const statusTagType = (status) => {
  switch (status) {
    case '预约中': return 'info'
    case '已签到': return 'success'
    case '已离开': return 'warning'
    default: return 'info'
  }
}

// 表单提交
const submitForm = () => {
  if (!form.value.visitorName || !form.value.date || !form.value.purpose) {
    ElMessage.error('请填写完整信息')
    return
  }
  if (form.value.id) {
    // 更新逻辑
    const index = appointments.value.findIndex(a => a.id === form.value.id)
    appointments.value[index] = { ...form.value }
  } else {
    // 新增逻辑，默认状态为“预约中”
    appointments.value.push({ ...form.value, id: Date.now(), status: '预约中' })
  }
  dialogVisible.value = false
}

// 打开弹窗
const showCreateDialog = () => {
  form.value = { id: null, visitorName: '', date: '', purpose: '' }
  dialogVisible.value = true
}

// 编辑预约
const editAppointment = (row) => {
  form.value = { ...row }
  dialogVisible.value = true
}

// 取消预约
const cancelAppointment = (row) => {
  appointments.value = appointments.value.filter(a => a.id !== row.id)
  ElMessage.success('预约已取消')
}
</script>

<style scoped>
.appointment-management {
  text-align: center;
  padding: 20px;
}

.title {
  font-size: 24px;
  color: #333;
  margin-bottom: 10px;
}

.subtitle {
  font-size: 14px;
  color: #666;
  margin-bottom: 20px;
}

.toolbar {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 10px;
  margin-bottom: 20px;
}

.search-input {
  width: 300px; /* 设置搜索框宽度 */
  max-width: 100%; /* 确保在小屏幕上不会超出 */
}

.appointment-table {
  margin-top: 20px;
}
</style>