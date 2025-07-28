import { useState, useEffect } from 'react';
import { Outlet, NavLink, useNavigate, useLocation } from 'react-router-dom';
import { Button } from '@/components/ui/button';
import { Avatar, AvatarFallback, AvatarImage } from '@/components/ui/avatar';
import { 
  DropdownMenu, 
  DropdownMenuContent, 
  DropdownMenuItem, 
  DropdownMenuLabel, 
  DropdownMenuSeparator, 
  DropdownMenuTrigger 
} from '@/components/ui/dropdown-menu';
import { 
  Sheet, 
  SheetContent, 
  SheetTrigger 
} from '@/components/ui/sheet';
import { useToast } from '@/hooks/use-toast';
import { useAuth } from '@/contexts/auth-context';
import { notificationAPI } from '@/services/api-service';
import { 
  Home, 
  FileText, 
  ClipboardList, 
  User, 
  LogOut, 
  Menu, 
  Bell, 
  Settings,
  ShieldCheck
} from 'lucide-react';
import { useMobile } from '@/hooks/use-mobile';

export default function Layout() {
  const { user, logout, isAdmin } = useAuth();
  const { toast } = useToast();
  const navigate = useNavigate();
  const location = useLocation();
  const isMobile = useMobile();
  const [unreadCount, setUnreadCount] = useState(0);
  const [sidebarOpen, setSidebarOpen] = useState(false);

  // 获取未读通知数量
  useEffect(() => {
    const fetchUnreadCount = async () => {
      try {
        // 修改这里，使用正确的API方法
        const response = await notificationAPI.getNotifications();
        // 计算未读通知数量
        const notifications = response?.data || [];
        const unread = Array.isArray(notifications) ? 
          notifications.filter((notification: any) => !notification.isRead).length : 0;
        setUnreadCount(unread);
      } catch (error) {
        console.error('获取未读通知数量失败', error);
      }
    };

    fetchUnreadCount();
    
    // 每分钟更新一次未读通知数量
    const interval = setInterval(fetchUnreadCount, 60000);
    
    return () => clearInterval(interval);
  }, []);

  const handleLogout = () => {
    logout();
    toast({
      title: '已退出登录',
      description: '您已成功退出系统',
    });
    navigate('/login');
  };

  // 导航项目
  const navItems = [
    { path: '/dashboard', label: '首页', icon: <Home className="w-5 h-5" /> },
    { path: '/application', label: '申请进校园', icon: <FileText className="w-5 h-5" /> },
    { path: '/applications', label: '我的申请', icon: <ClipboardList className="w-5 h-5" /> },
    { path: '/profile', label: '个人中心', icon: <User className="w-5 h-5" /> },
  ];

  // 如果是管理员，添加管理后台入口
  if (isAdmin) {
    navItems.push({ 
      path: '/admin', 
      label: '管理后台', 
      icon: <ShieldCheck className="w-5 h-5" /> 
    });
  }

  // 获取当前页面标题
  const getCurrentPageTitle = () => {
    const currentItem = navItems.find(item => item.path === location.pathname);
    return currentItem ? currentItem.label : '黑河学院校友会';
  };

  return (
    <div className="min-h-screen bg-gray-50 flex flex-col">
      {/* 顶部导航栏 */}
      <header className="bg-white border-b shadow-sm sticky top-0 z-10">
        <div className="container mx-auto px-4 h-16 flex items-center justify-between">
          {/* 左侧菜单按钮和标题 */}
          <div className="flex items-center gap-3">
            {isMobile && (
              <Sheet open={sidebarOpen} onOpenChange={setSidebarOpen}>
                <SheetTrigger asChild>
                  <Button variant="ghost" size="icon">
                    <Menu className="w-5 h-5" />
                  </Button>
                </SheetTrigger>
                <SheetContent side="left" className="w-64 p-0">
                  <div className="py-6 px-4 bg-blue-600 text-white">
                    <h2 className="text-xl font-bold">黑河学院校友会</h2>
                    <p className="text-sm text-blue-100">进校园申请系统</p>
                  </div>
                  <nav className="p-4">
                    <ul className="space-y-2">
                      {navItems.map((item) => (
                        <li key={item.path}>
                          <NavLink
                            to={item.path}
                            className={({ isActive }) =>
                              `flex items-center gap-3 px-4 py-2 rounded-md transition-colors ${
                                isActive
                                  ? 'bg-blue-50 text-blue-600 font-medium'
                                  : 'text-gray-700 hover:bg-gray-100'
                              }`
                            }
                            onClick={() => setSidebarOpen(false)}
                          >
                            {item.icon}
                            {item.label}
                          </NavLink>
                        </li>
                      ))}
                    </ul>
                  </nav>
                </SheetContent>
              </Sheet>
            )}
            <h1 className="text-xl font-bold text-gray-900">
              {getCurrentPageTitle()}
            </h1>
          </div>

          {/* 右侧用户信息和通知 */}
          <div className="flex items-center gap-2">
            {/* 通知按钮 */}
            <Button 
              variant="ghost" 
              size="icon" 
              className="relative"
              onClick={() => navigate('/notifications')}
            >
              <Bell className="w-5 h-5" />
              {unreadCount > 0 && (
                <span className="absolute top-0 right-0 w-4 h-4 bg-red-500 text-white text-xs rounded-full flex items-center justify-center">
                  {unreadCount > 9 ? '9+' : unreadCount}
                </span>
              )}
            </Button>

            {/* 用户头像和下拉菜单 */}
            <DropdownMenu>
              <DropdownMenuTrigger asChild>
                <Button variant="ghost" className="relative h-8 w-8 rounded-full">
                  <Avatar className="h-8 w-8">
                    <AvatarImage src={user?.avatarUrl} alt={user?.name} />
                    <AvatarFallback className="bg-blue-100 text-blue-600">
                      {user?.name?.charAt(0)}
                    </AvatarFallback>
                  </Avatar>
                </Button>
              </DropdownMenuTrigger>
              <DropdownMenuContent align="end">
                <DropdownMenuLabel>
                  <div className="flex flex-col">
                    <span>{user?.name}</span>
                    <span className="text-xs text-gray-500">{user?.email}</span>
                  </div>
                </DropdownMenuLabel>
                <DropdownMenuSeparator />
                <DropdownMenuItem onClick={() => navigate('/profile')}>
                  <User className="w-4 h-4 mr-2" />
                  个人中心
                </DropdownMenuItem>
                <DropdownMenuItem onClick={() => navigate('/profile/settings')}>
                  <Settings className="w-4 h-4 mr-2" />
                  账号设置
                </DropdownMenuItem>
                <DropdownMenuSeparator />
                <DropdownMenuItem onClick={handleLogout}>
                  <LogOut className="w-4 h-4 mr-2" />
                  退出登录
                </DropdownMenuItem>
              </DropdownMenuContent>
            </DropdownMenu>
          </div>
        </div>
      </header>

      {/* 主要内容区域 */}
      <div className="flex flex-1">
        {/* 侧边栏导航 (仅在非移动设备上显示) */}
        {!isMobile && (
          <aside className="w-64 bg-white border-r shadow-sm">
            <div className="py-6 px-4 bg-blue-600 text-white">
              <h2 className="text-xl font-bold">黑河学院校友会</h2>
              <p className="text-sm text-blue-100">进校园申请系统</p>
            </div>
            <nav className="p-4">
              <ul className="space-y-2">
                {navItems.map((item) => (
                  <li key={item.path}>
                    <NavLink
                      to={item.path}
                      className={({ isActive }) =>
                        `flex items-center gap-3 px-4 py-2 rounded-md transition-colors ${
                          isActive
                            ? 'bg-blue-50 text-blue-600 font-medium'
                            : 'text-gray-700 hover:bg-gray-100'
                        }`
                      }
                    >
                      {item.icon}
                      {item.label}
                    </NavLink>
                  </li>
                ))}
              </ul>
            </nav>
          </aside>
        )}

        {/* 页面内容 */}
        <main className="flex-1 p-6 overflow-auto">
          <Outlet />
        </main>
      </div>
    </div>
  );
}