import { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { Card, CardContent, CardDescription, CardHeader, CardTitle } from '@/components/ui/card';
import { Button } from '@/components/ui/button';
import { Input } from '@/components/ui/input';
import { Label } from '@/components/ui/label';
import { Tabs, TabsContent, TabsList, TabsTrigger } from '@/components/ui/tabs';
import { Avatar, AvatarFallback, AvatarImage } from '@/components/ui/avatar';
import { useToast } from '@/hooks/use-toast';
import { useAuth } from '@/contexts/auth-context';
import { authAPI } from '@/services/api-service';
import { 
  User, 
  Mail, 
  Phone, 
  GraduationCap, 
  Calendar, 
  BookOpen,
  Lock,
  Save,
  Upload
} from 'lucide-react';

export default function ProfilePage() {
  const { user, updateUserInfo } = useAuth();
  const { toast } = useToast();
  const navigate = useNavigate();
  const [activeTab, setActiveTab] = useState('info');
  const [isLoading, setIsLoading] = useState(false);
  const [avatarFile, setAvatarFile] = useState<File | null>(null);
  const [avatarPreview, setAvatarPreview] = useState<string | null>(null);
  
  const [profileData, setProfileData] = useState({
    name: user?.name || '',
    email: user?.email || '',
    phone: user?.phone || '',
    studentId: user?.studentId || '',
    graduationYear: user?.graduationYear || new Date().getFullYear(),
    major: user?.major || ''
  });
  
  const [passwordData, setPasswordData] = useState({
    currentPassword: '',
    newPassword: '',
    confirmPassword: ''
  });

  const handleProfileChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setProfileData(prev => ({ ...prev, [name]: value }));
  };

  const handlePasswordChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setPasswordData(prev => ({ ...prev, [name]: value }));
  };

  const handleAvatarChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    if (e.target.files && e.target.files[0]) {
      const file = e.target.files[0];
      setAvatarFile(file);
      
      // 创建预览URL
      const reader = new FileReader();
      reader.onloadend = () => {
        setAvatarPreview(reader.result as string);
      };
      reader.readAsDataURL(file);
    }
  };

  const handleUpdateProfile = async () => {
    setIsLoading(true);
    
    try {
      // 更新个人信息
      await authAPI.updateProfile(profileData);
      
      // 如果有头像文件，上传头像
      if (avatarFile) {
        const formData = new FormData();
        formData.append('file', avatarFile);
        await authAPI.uploadAvatar(formData);
      }
      
      // 更新本地用户信息
      updateUserInfo({
        ...user,
        ...profileData,
        avatarUrl: avatarPreview || user?.avatarUrl
      });
      
      toast({
        title: '个人信息更新成功',
        description: '您的个人信息已成功更新',
      });
    } catch (error: any) {
      toast({
        title: '更新失败',
        description: error.response?.data?.message || '请检查您的信息并稍后再试',
        variant: 'destructive',
      });
    } finally {
      setIsLoading(false);
    }
  };

  const handleChangePassword = async () => {
    // 密码验证
    if (!passwordData.currentPassword || !passwordData.newPassword || !passwordData.confirmPassword) {
      toast({
        title: '请填写完整信息',
        description: '所有密码字段都是必填项',
        variant: 'destructive',
      });
      return;
    }

    if (passwordData.newPassword !== passwordData.confirmPassword) {
      toast({
        title: '密码不匹配',
        description: '新密码和确认密码不一致',
        variant: 'destructive',
      });
      return;
    }

    if (passwordData.newPassword.length < 6) {
      toast({
        title: '密码太短',
        description: '新密码长度至少为6个字符',
        variant: 'destructive',
      });
      return;
    }

    setIsLoading(true);
    
    try {
      await authAPI.changePassword({
        oldPassword: passwordData.currentPassword,
        newPassword: passwordData.newPassword
      });
      
      toast({
        title: '密码修改成功',
        description: '您的密码已成功修改，请使用新密码登录',
      });
      
      // 清空密码表单
      setPasswordData({
        currentPassword: '',
        newPassword: '',
        confirmPassword: ''
      });
    } catch (error: any) {
      toast({
        title: '密码修改失败',
        description: error.response?.data?.message || '请检查您的当前密码是否正确',
        variant: 'destructive',
      });
    } finally {
      setIsLoading(false);
    }
  };

  return (
    <div className="space-y-6">
      <Card>
        <CardHeader>
          <CardTitle>个人中心</CardTitle>
          <CardDescription>查看和管理您的个人信息</CardDescription>
        </CardHeader>
        <CardContent>
          <Tabs value={activeTab} onValueChange={setActiveTab}>
            <TabsList className="mb-6">
              <TabsTrigger value="info">基本信息</TabsTrigger>
              <TabsTrigger value="security">安全设置</TabsTrigger>
            </TabsList>
            
            {/* 基本信息标签 */}
            <TabsContent value="info" className="space-y-6">
              {/* 头像上传 */}
              <div className="flex flex-col items-center sm:flex-row sm:items-start gap-6">
                {/* <div className="flex flex-col items-center">
                  <Avatar className="w-24 h-24 border-2 border-gray-200">
                    <AvatarImage src={avatarPreview || user?.avatarUrl} />
                    <AvatarFallback className="text-2xl bg-blue-100 text-blue-600">
                      {user?.name?.charAt(0)}
                    </AvatarFallback>
                  </Avatar>
                  <div className="mt-4">
                    <input
                      type="file"
                      id="avatar-upload"
                      className="hidden"
                      accept="image/*"
                      onChange={handleAvatarChange}
                    />
                    <label htmlFor="avatar-upload">
                      <Button
                        variant="outline"
                        size="sm"
                        className="cursor-pointer"
                        type="button"
                        asChild
                      >
                        <span>
                          <Upload className="w-4 h-4 mr-2" />
                          更换头像
                        </span>
                      </Button>
                    </label>
                  </div>
                </div> */}

                <div className="flex-1 space-y-4">
                  <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                    <div className="space-y-2">
                      <Label htmlFor="name">姓名</Label>
                      <div className="relative">
                        <User className="absolute left-3 top-3 h-4 w-4 text-gray-500" />
                        <Input
                          id="name"
                          name="name"
                          placeholder="您的真实姓名"
                          className="pl-10"
                          value={profileData.name}
                          onChange={handleProfileChange}
                          disabled={isLoading}
                        />
                      </div>
                    </div>
                    
                    <div className="space-y-2">
                      <Label htmlFor="email">邮箱</Label>
                      <div className="relative">
                        <Mail className="absolute left-3 top-3 h-4 w-4 text-gray-500" />
                        <Input
                          id="email"
                          name="email"
                          type="email"
                          placeholder="您的邮箱地址"
                          className="pl-10"
                          value={profileData.email}
                          onChange={handleProfileChange}
                          disabled={isLoading}
                        />
                      </div>
                    </div>
                    
                    <div className="space-y-2">
                      <Label htmlFor="phone">手机号</Label>
                      <div className="relative">
                        <Phone className="absolute left-3 top-3 h-4 w-4 text-gray-500" />
                        <Input
                          id="phone"
                          name="phone"
                          placeholder="您的手机号码"
                          className="pl-10"
                          value={profileData.phone}
                          onChange={handleProfileChange}
                          disabled={isLoading}
                        />
                      </div>
                    </div>
                    
                    <div className="space-y-2">
                      <Label htmlFor="studentId">学号</Label>
                      <div className="relative">
                        <GraduationCap className="absolute left-3 top-3 h-4 w-4 text-gray-500" />
                        <Input
                          id="studentId"
                          name="studentId"
                          placeholder="您的学号"
                          className="pl-10"
                          value={profileData.studentId}
                          onChange={handleProfileChange}
                          disabled={isLoading}
                        />
                      </div>
                    </div>
                    
                    <div className="space-y-2">
                      <Label htmlFor="graduationYear">毕业年份</Label>
                      <div className="relative">
                        <Calendar className="absolute left-3 top-3 h-4 w-4 text-gray-500" />
                        <Input
                          id="graduationYear"
                          name="graduationYear"
                          type="number"
                          placeholder="您的毕业年份"
                          className="pl-10"
                          value={profileData.graduationYear}
                          onChange={handleProfileChange}
                          disabled={isLoading}
                        />
                      </div>
                    </div>
                    
                    <div className="space-y-2">
                      <Label htmlFor="major">专业</Label>
                      <div className="relative">
                        <BookOpen className="absolute left-3 top-3 h-4 w-4 text-gray-500" />
                        <Input
                          id="major"
                          name="major"
                          placeholder="您的专业"
                          className="pl-10"
                          value={profileData.major}
                          onChange={handleProfileChange}
                          disabled={isLoading}
                        />
                      </div>
                    </div>
                  </div>
                  
                  <div className="flex justify-end">
                    <Button 
                      onClick={handleUpdateProfile} 
                      disabled={isLoading}
                      className="bg-blue-600 hover:bg-blue-700"
                    >
                      <Save className="w-4 h-4 mr-2" />
                      {isLoading ? '保存中...' : '保存修改'}
                    </Button>
                  </div>
                </div>
              </div>
            </TabsContent>
            
            {/* 安全设置标签 */}
            <TabsContent value="security" className="space-y-6">
              <Card>
                <CardHeader>
                  <CardTitle className="text-lg">修改密码</CardTitle>
                  <CardDescription>定期更新您的密码以保护账号安全</CardDescription>
                </CardHeader>
                <CardContent className="space-y-4">
                  <div className="space-y-2">
                    <Label htmlFor="currentPassword">当前密码</Label>
                    <div className="relative">
                      <Lock className="absolute left-3 top-3 h-4 w-4 text-gray-500" />
                      <Input
                        id="currentPassword"
                        name="currentPassword"
                        type="password"
                        placeholder="请输入当前密码"
                        className="pl-10"
                        value={passwordData.currentPassword}
                        onChange={handlePasswordChange}
                        disabled={isLoading}
                      />
                    </div>
                  </div>
                  
                  <div className="space-y-2">
                    <Label htmlFor="newPassword">新密码</Label>
                    <div className="relative">
                      <Lock className="absolute left-3 top-3 h-4 w-4 text-gray-500" />
                      <Input
                        id="newPassword"
                        name="newPassword"
                        type="password"
                        placeholder="请设置新密码"
                        className="pl-10"
                        value={passwordData.newPassword}
                        onChange={handlePasswordChange}
                        disabled={isLoading}
                      />
                    </div>
                  </div>
                  
                  <div className="space-y-2">
                    <Label htmlFor="confirmPassword">确认新密码</Label>
                    <div className="relative">
                      <Lock className="absolute left-3 top-3 h-4 w-4 text-gray-500" />
                      <Input
                        id="confirmPassword"
                        name="confirmPassword"
                        type="password"
                        placeholder="请再次输入新密码"
                        className="pl-10"
                        value={passwordData.confirmPassword}
                        onChange={handlePasswordChange}
                        disabled={isLoading}
                      />
                    </div>
                  </div>
                  
                  <div className="flex justify-end">
                    <Button 
                      onClick={handleChangePassword} 
                      disabled={isLoading}
                      className="bg-blue-600 hover:bg-blue-700"
                    >
                      {isLoading ? '提交中...' : '修改密码'}
                    </Button>
                  </div>
                </CardContent>
              </Card>
            </TabsContent>
          </Tabs>
        </CardContent>
      </Card>
    </div>
  );
}