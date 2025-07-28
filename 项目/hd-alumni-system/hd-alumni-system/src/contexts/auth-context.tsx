import { createContext, useContext, useState, useEffect, ReactNode } from 'react';
import { authAPI } from '@/services/api-service';

interface User {
  id: number;
  name: string;
  email: string;
  phone: string;
  avatarUrl?: string;
  role: string;
  graduationYear?: string;
  major?: string;
  studentId?: string;
}

interface AuthContextType {
  user: User | null;
  isAuthenticated: boolean;
  isAdmin: boolean;
  loading: boolean;
  login: (phone: string, password: string) => Promise<void>;
  register: (userData: any) => Promise<void>;
  logout: () => void;
  updateUserInfo: (userData: Partial<User>) => void;
}

const AuthContext = createContext<AuthContextType | undefined>(undefined);

// 使用命名导出而不是默认导出
export function AuthProvider({ children }: { children: ReactNode }) {
  const [user, setUser] = useState<User | null>(null);
  const [loading, setLoading] = useState(true);

  // useEffect(() => {
  //   // 检查本地存储中是否有用户信息
  //   const storedUser = localStorage.getItem('user');
  //   const token = localStorage.getItem('token');

  //   if (storedUser && token) {
  //     setUser(JSON.parse(storedUser));
  //     setLoading(false);
  //   } else {
  //     setLoading(false);
  //   }

  //   // 如果有token，验证token有效性并获取最新用户信息
  //   if (token) {
  //     fetchCurrentUser();
  //   }
  // }, []);


  useEffect(() => {
  const storedUser = localStorage.getItem('user');
  const token = localStorage.getItem('token');

  if (storedUser && storedUser !== 'undefined' && token) {
    try {
      setUser(JSON.parse(storedUser));
    } catch {
      // 解析失败，视为无效
      localStorage.removeItem('user');
      localStorage.removeItem('token');
    }
  }

  // 如果 token 存在，再向后端验证一次
  if (token) {
    fetchCurrentUser();
  } else {
    setLoading(false);
  }
}, []);


  const fetchCurrentUser = async () => {
    try {
      const response = await authAPI.getCurrentUser();
      const userData = response;
      setUser(userData);
      localStorage.setItem('user', JSON.stringify(userData));
     
      console.log('当前用户信息:',  localStorage.getItem('user'));
    } catch (error) {
      console.error('获取用户信息失败', error);
      // 如果token无效，清除本地存储
      logout();
    } finally {
      setLoading(false);
    }
  };

  const login = async (phone: string, password: string) => {
    setLoading(true);
    try {
      const response = await authAPI.login({ phone, password });
      // const { token, user } = response.data;
      const { token, user } = response;
      
      // 保存token和用户信息到本地存储
      localStorage.setItem('token', token);
      localStorage.setItem('user', JSON.stringify(user));
      
      setUser(user);
    } catch (error) {
      console.error('登录失败', error);
      throw error;
    } finally {
      setLoading(false);
    }
  };

  const register = async (userData: any) => {
    setLoading(true);
    try {
      await authAPI.register(userData);
    } catch (error) {
      console.error('注册失败', error);
      throw error;
    } finally {
      setLoading(false);
    }
  };

  const logout = () => {
    // 清除本地存储和状态
    localStorage.removeItem('token');
    localStorage.removeItem('user');
    setUser(null);
  };

  const updateUserInfo = (userData: Partial<User>) => {
    if (user) {
      const updatedUser = { ...user, ...userData };
      setUser(updatedUser);
      localStorage.setItem('user', JSON.stringify(updatedUser));
    }
  };

  const isAuthenticated = !!user;
  const isAdmin = user?.role === 'ADMIN';

  return (
    <AuthContext.Provider
      value={{
        user,
        isAuthenticated,
        isAdmin,
        loading,
        login,
        register,
        logout,
        updateUserInfo
      }}
    >
      {children}
    </AuthContext.Provider>
  );
}

// 将useAuth定义为单独的命名导出函数
export function useAuth() {
  const context = useContext(AuthContext);
  if (context === undefined) {
    throw new Error('useAuth must be used within an AuthProvider');
  }
  return context;
}