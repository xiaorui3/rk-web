import axios from 'axios';

// 创建axios实例
const api = axios.create({
  // 修改为本地后端地址
  baseURL: 'http://localhost:8080/api',
  timeout: 10000, // 请求超时时间
  // headers: {
  //   'Content-Type': 'application/json',
  // }
});

// 请求拦截器
api.interceptors.request.use(
  config => {
    // 从localStorage获取token
    const token = localStorage.getItem('token');
    if (token) {
      config.headers['Authorization'] = `Bearer ${token}`;
    }
    return config;
  },
  error => {
    return Promise.reject(error);
  }
);

// 响应拦截器
api.interceptors.response.use(
  response => {
    return response.data;
  },
  error => {
    if (error.response) {
      // 处理401未授权错误
      if (error.response.status === 401) {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        window.location.href = '/login';
      }
      return Promise.reject(error.response.data);
    }
    return Promise.reject(error);
  }
);

// 认证相关API
export const authAPI = {
  // 用户登录
  login: (data: { phone: string; password: string }) => {
    return api.post('/auth/login', data);
  },
  // 用户注册
  register: (data: any) => {
    return api.post('/auth/register', data);
  },
  // 获取当前用户信息
  getCurrentUser: () => {
    return api.get('/users/me');
  },
  // 修改密码
  changePassword: (data: { oldPassword: string; newPassword: string }) => {
    return api.post('/users/change-password', data);
  },
  // 更新用户资料
  updateProfile: (data: any) => {
    return api.put('/users/profile', data);
  },
  // 上传头像
  uploadAvatar: (formData: FormData) => {
    return api.post('/users/avatar', formData, {
      headers: {
        'Content-Type': 'multipart/form-data'
      }
    });
  }
};

// 申请相关API
export const applicationAPI = {
  // 提交申请
  submitApplication: (formData: FormData) => {
    return api.post('/applications', formData); // 不要加 headers
  },
  // 获取申请列表
  getApplications: (params: any) => {
    return api.get('/applications', { params });
  },
  // 获取申请详情
  getApplicationById: (id: number) => {
    return api.get(`/applications/${id}`);
  },
  // 取消申请
  cancelApplication: (id: number) => {
    return api.put(`/applications/${id}/cancel`);
  },
  // 上传申请相关文件
  uploadFile: (applicationId: number, formData: FormData) => {
  return api.post(`/applications/${applicationId}/files`, formData); // 同样不要加
},
};

// 管理员相关API
// 申请相关API
// api-service.ts
export const adminAPI = {
  // 获取所有申请（带文件信息）
  getAllApplications: (params: {
    page?: number;
    size?: number;
    status?: string;
  }) => api.get('/applications/all-with-files', { params }),
  
  // 获取申请统计数据
  getApplicationStats: async () => {
    try {
      const response = await api.get('/applications/all-with-files', {
        params: { page: 0, size: 9999, status: 'all' }
      });
      const list = response.content || [];
      return {
        pending: list.filter((a: any) => a.status === 'PENDING').length,
        approved: list.filter((a: any) => a.status === 'APPROVED').length,
        rejected: list.filter((a: any) => a.status === 'REJECTED').length,
        total: list.length,
        todayNew: list.filter((a: any) => {
          const submitDate = new Date(a.submitDate);
          const today = new Date();
          return (
            submitDate.getDate() === today.getDate() &&
            submitDate.getMonth() === today.getMonth() &&
            submitDate.getFullYear() === today.getFullYear()
          );
        }).length,
        weeklyNew: list.filter((a: any) => {
          const submitDate = new Date(a.submitDate);
          const weekAgo = new Date();
          weekAgo.setDate(weekAgo.getDate() - 7);
          return submitDate >= weekAgo;
        }).length,
      };
    } catch (error) {
      console.error('获取统计数据失败', error);
      throw error;
    }
  },

  // 审核单个申请
  reviewApplication: (id: number, data: { status: string; feedback: string }) =>
    api.post(`/applications/${id}/review`, data),

  // 批量审核申请
  batchReviewApplications: (data: {
    ids: number[];
    status: string;
    feedback: string;
  }) => api.post('/applications/batch-review', data),
};


// 通知相关API
export const notificationAPI = {
  // 获取通知列表
  getNotifications: () => {
    return api.get('/notifications');
  },
  // 标记通知为已读
  markAsRead: (id: number) => {
    return api.put(`/notifications/${id}/read`);
  },
  // 标记所有通知为已读
  markAllAsRead: () => {
    return api.put('/notifications/read-all');
  }
};

export default api;