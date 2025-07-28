import { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { Card, CardContent, CardDescription, CardHeader, CardTitle } from '@/components/ui/card';
import { Button } from '@/components/ui/button';
import { Badge } from '@/components/ui/badge';
import { Skeleton } from '@/components/ui/skeleton';
import { useAuth } from '@/contexts/auth-context';
import { applicationAPI, notificationAPI } from '@/services/api-service';
import { 
  FileText, 
  ClipboardList, 
  User, 
  Clock, 
  CheckCircle, 
  XCircle, 
  Calendar,
  Bell,
  ArrowRight
} from 'lucide-react';

interface ApplicationStats {
  pending: number;
  approved: number;
  rejected: number;
  total: number;
}

interface Notification {
  id: number;
  title: string;
  content: string;
  type: string;
  read: boolean;
  createdAt: string;
}

export default function DashboardPage() {
  const { user } = useAuth();
  const navigate = useNavigate();
  const [stats, setStats] = useState<ApplicationStats | null>(null);
  const [notifications, setNotifications] = useState<Notification[]>([]);
  const [loading, setLoading] = useState({
    stats: true,
    notifications: true
  });

  useEffect(() => {
    // 获取申请统计数据
    const fetchStats = async () => {
      try {
        // 获取不同状态的申请数量
        const pendingResponse = await applicationAPI.getApplications({ status: 'PENDING', page: 0, size: 1 });
        const approvedResponse = await applicationAPI.getApplications({ status: 'APPROVED', page: 0, size: 1 });
        const rejectedResponse = await applicationAPI.getApplications({ status: 'REJECTED', page: 0, size: 1 });
        const allResponse = await applicationAPI.getApplications({ page: 0, size: 1 });

        setStats({
          pending: pendingResponse.totalElements || 0,
          approved: approvedResponse.totalElements || 0,
          rejected: rejectedResponse.totalElements || 0,
          total: allResponse.totalElements || 0
        });
      } catch (error) {
        console.error('获取申请统计数据失败', error);
        // 设置默认值，避免界面错误
        setStats({
          pending: 0,
          approved: 0,
          rejected: 0,
          total: 0
        });
      } finally {
        setLoading(prev => ({ ...prev, stats: false }));
      }
    };

    // 获取最新通知
    const fetchNotifications = async () => {
      try {
        const response = await notificationAPI.getNotifications();
        setNotifications(Array.isArray(response) ? response.slice(0, 5) : []);
      } catch (error) {
        console.error('获取通知失败', error);
        setNotifications([]);
      } finally {
        setLoading(prev => ({ ...prev, notifications: false }));
      }
    };

    fetchStats();
    fetchNotifications();
  }, []);

  // 获取通知时间显示
  const getTimeDisplay = (dateString: string) => {
    const date = new Date(dateString);
    const now = new Date();
    const diffInHours = Math.floor((now.getTime() - date.getTime()) / (1000 * 60 * 60));
    
    if (diffInHours < 24) {
      return `${diffInHours}小时前`;
    } else {
      return `${Math.floor(diffInHours / 24)}天前`;
    }
  };

  // 获取通知类型显示
  const getNotificationTypeDisplay = (type: string) => {
    switch (type) {
      case 'SYSTEM':
        return '系统通知';
      case 'APPLICATION':
        return '申请通知';
      case 'REVIEW':
        return '审核通知';
      default:
        return '通知';
    }
  };



  return (
    <div className="space-y-6">
      {/* 欢迎区域 */}
      <Card className="bg-gradient-to-r from-blue-600 to-blue-500 text-white">
        <CardContent className="p-6">
          <h2 className="text-2xl font-bold mb-2">欢迎回来，{user?.name}</h2>
          <p className="text-blue-100">
            欢迎使用黑河学院校友会进校园申请系统
          </p>
        </CardContent>
      </Card>

      {/* 快捷功能卡片 */}
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-4">
        <Card className="hover:shadow-md transition-shadow cursor-pointer" onClick={() => navigate('/application')}>
          <CardContent className="p-6 flex items-center gap-4">
            <div className="bg-blue-100 p-3 rounded-full">
              <FileText className="w-6 h-6 text-blue-600" />
            </div>
            <div>
              <h3 className="font-medium">新建申请</h3>
              <p className="text-sm text-gray-500">申请进入校园</p>
            </div>
          </CardContent>
        </Card>

        <Card className="hover:shadow-md transition-shadow cursor-pointer" onClick={() => navigate('/applications')}>
          <CardContent className="p-6 flex items-center gap-4">
            <div className="bg-green-100 p-3 rounded-full">
              <ClipboardList className="w-6 h-6 text-green-600" />
            </div>
            <div>
              <h3 className="font-medium">我的申请</h3>
              <p className="text-sm text-gray-500">查看申请记录</p>
            </div>
          </CardContent>
        </Card>

        <Card className="hover:shadow-md transition-shadow cursor-pointer" onClick={() => navigate('/profile')}>
          <CardContent className="p-6 flex items-center gap-4">
            <div className="bg-purple-100 p-3 rounded-full">
              <User className="w-6 h-6 text-purple-600" />
            </div>
            <div>
              <h3 className="font-medium">个人中心</h3>
              <p className="text-sm text-gray-500">管理个人信息</p>
            </div>
          </CardContent>
        </Card>

        <Card className="hover:shadow-md transition-shadow cursor-pointer" onClick={() => navigate('/notifications')}>
          <CardContent className="p-6 flex items-center gap-4">
            <div className="bg-amber-100 p-3 rounded-full">
              <Bell className="w-6 h-6 text-amber-600" />
            </div>
            <div>
              <h3 className="font-medium">通知中心</h3>
              <p className="text-sm text-gray-500">查看系统通知</p>
            </div>
          </CardContent>
        </Card>
      </div>

      {/* 申请状态概览 */}
      <Card>
        <CardHeader>
          <CardTitle className="flex items-center gap-2">
            <Calendar className="w-5 h-5" />
            申请状态概览
          </CardTitle>
          <CardDescription>您的进校园申请统计信息</CardDescription>
        </CardHeader>
        <CardContent>
          {loading.stats ? (
            <div className="grid grid-cols-2 md:grid-cols-4 gap-4">
              {[...Array(4)].map((_, i) => (
                <div key={i} className="space-y-2">
                  <Skeleton className="h-10 w-full" />
                  <Skeleton className="h-4 w-20" />
                </div>
              ))}
            </div>
          ) : (
            <div className="grid grid-cols-2 md:grid-cols-4 gap-4">
              <div className="bg-yellow-50 border border-yellow-100 rounded-lg p-4">
                <div className="flex items-center gap-2 mb-1">
                  <Clock className="w-4 h-4 text-yellow-600" />
                  <span className="text-sm font-medium text-yellow-600">待审核</span>
                </div>
                <p className="text-2xl font-bold">{stats?.pending || 0}</p>
              </div>
              
              <div className="bg-green-50 border border-green-100 rounded-lg p-4">
                <div className="flex items-center gap-2 mb-1">
                  <CheckCircle className="w-4 h-4 text-green-600" />
                  <span className="text-sm font-medium text-green-600">已通过</span>
                </div>
                <p className="text-2xl font-bold">{stats?.approved || 0}</p>
              </div>
              
              <div className="bg-red-50 border border-red-100 rounded-lg p-4">
                <div className="flex items-center gap-2 mb-1">
                  <XCircle className="w-4 h-4 text-red-600" />
                  <span className="text-sm font-medium text-red-600">已拒绝</span>
                </div>
                <p className="text-2xl font-bold">{stats?.rejected || 0}</p>
              </div>
              
              <div className="bg-blue-50 border border-blue-100 rounded-lg p-4">
                <div className="flex items-center gap-2 mb-1">
                  <FileText className="w-4 h-4 text-blue-600" />
                  <span className="text-sm font-medium text-blue-600">总申请</span>
                </div>
                <p className="text-2xl font-bold">{stats?.total || 0}</p>
              </div>
            </div>
          )}
          
          <div className="mt-4 flex justify-end">
            <Button 
              variant="outline" 
              size="sm" 
              className="text-blue-600"
              onClick={() => navigate('/applications')}
            >
              查看所有申请
              <ArrowRight className="w-4 h-4 ml-1" />
            </Button>
          </div>
        </CardContent>
      </Card>

      {/* 最新通知 */}
      <Card>
        <CardHeader>
          <CardTitle className="flex items-center gap-2">
            <Bell className="w-5 h-5" />
            最新通知
          </CardTitle>
          <CardDescription>系统和申请相关的通知</CardDescription>
        </CardHeader>
        <CardContent>
          {loading.notifications ? (
            <div className="space-y-4">
              {[...Array(3)].map((_, i) => (
                <div key={i} className="flex gap-4">
                  <Skeleton className="h-10 w-10 rounded-full" />
                  <div className="space-y-2 flex-1">
                    <Skeleton className="h-4 w-3/4" />
                    <Skeleton className="h-3 w-full" />
                  </div>
                </div>
              ))}
            </div>
          ) : notifications.length > 0 ? (
            <div className="space-y-4">
              {notifications.map(notification => (
                <div key={notification.id} className="flex items-start gap-4 p-3 rounded-lg hover:bg-gray-50 transition-colors">
                  <div className={`w-10 h-10 rounded-full flex items-center justify-center ${
                    notification.type === 'SYSTEM' ? 'bg-blue-100 text-blue-600' :
                    notification.type === 'APPLICATION' ? 'bg-green-100 text-green-600' :
                    'bg-amber-100 text-amber-600'
                  }`}>
                    <Bell className="w-5 h-5" />
                  </div>
                  <div className="flex-1">
                    <div className="flex items-center justify-between mb-1">
                      <h4 className="font-medium flex items-center gap-2">
                        {notification.title}
                        {!notification.read && (
                          <Badge variant="default" className="bg-red-500 text-white text-xs">新</Badge>
                        )}
                      </h4>
                      <span className="text-xs text-gray-500">{getTimeDisplay(notification.createdAt)}</span>
                    </div>
                    <p className="text-sm text-gray-600 line-clamp-2">{notification.content}</p>
                    <div className="mt-1">
                      <Badge variant="outline" className="text-xs">
                        {getNotificationTypeDisplay(notification.type)}
                      </Badge>
                    </div>
                  </div>
                </div>
              ))}
            </div>
          ) : (
            <div className="text-center py-8 text-gray-500">
              <Bell className="w-12 h-12 mx-auto text-gray-300 mb-2" />
              <p>暂无通知</p>
            </div>
          )}
          
          <div className="mt-4 flex justify-end">
            <Button 
              variant="outline" 
              size="sm" 
              className="text-blue-600"
              onClick={() => navigate('/notifications')}
            >
              查看所有通知
              <ArrowRight className="w-4 h-4 ml-1" />
            </Button>
          </div>
        </CardContent>
      </Card>
    </div>
  );
}