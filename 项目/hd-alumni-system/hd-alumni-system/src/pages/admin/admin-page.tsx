import { useState, useEffect } from 'react';
import { Card, CardContent, CardDescription, CardHeader, CardTitle } from '@/components/ui/card';
import { Button } from '@/components/ui/button';
import { Badge } from '@/components/ui/badge';
import { Input } from '@/components/ui/input';
import { Textarea } from '@/components/ui/textarea';
import { Label } from '@/components/ui/label';
import { Select, SelectContent, SelectItem, SelectTrigger, SelectValue } from '@/components/ui/select';
import { 
  Table, 
  TableBody, 
  TableCell, 
  TableHead, 
  TableHeader, 
  TableRow 
} from '@/components/ui/table';
import { 
  Dialog,
  DialogContent,
  DialogDescription,
  DialogHeader,
  DialogTitle,
  DialogFooter,
} from '@/components/ui/dialog';
import { Tabs, TabsContent, TabsList, TabsTrigger } from '@/components/ui/tabs';
import { Skeleton } from '@/components/ui/skeleton';
import { adminAPI } from '@/services/api-service';

import { useToast } from '@/hooks/use-toast';
import { useAuth } from '@/contexts/auth-context';
import { 
  Search, 
  Filter, 
  Eye, 
  Clock, 
  CheckCircle, 
  XCircle,
  Calendar,
  FileText,
  AlertTriangle,
  UserCheck,
  Users,
  BarChart,
  CheckCheck,
  X
} from 'lucide-react';

interface Application {
  id: number;
  purpose: string;
  visitDate: string;
  visitTime: string;
  duration: string;
  location: string;
  contactPerson: string;
  contactPhone: string;
  description: string;
  emergencyContact: string;
  emergencyPhone: string;
  status: string;
  submitDate: string;
  reviewDate?: string;
  feedback?: string;
  files: any[]; // 添加文件数组
  applicantName: string; // 新增字段
  studentId: string; // 新增字段
  graduationYear: number; // 新增字段
  major: string; // 新增字段
  reviewerName?: string; // 新增字段
}

interface ApplicationStats {
  pending: number;
  approved: number;
  rejected: number;
  total: number;
  todayNew: number;
  weeklyNew: number;
}

export default function AdminPage() {
  
  const { user } = useAuth();
  const { toast } = useToast();
  const [activeTab, setActiveTab] = useState('pending');
  const [applications, setApplications] = useState<Application[]>([]);
  const [selectedApplication, setSelectedApplication] = useState<Application | null>(null);
  const [detailsOpen, setDetailsOpen] = useState(false);
  const [reviewDialogOpen, setReviewDialogOpen] = useState(false);
  const [loading, setLoading] = useState(true);
  const [searchTerm, setSearchTerm] = useState('');
  const [stats, setStats] = useState<ApplicationStats | null>(null);
  const [reviewData, setReviewData] = useState({
    status: 'APPROVED',
    feedback: ''
  });
  const [pagination, setPagination] = useState({
    page: 0,
    size: 10,
    totalElements: 0,
    totalPages: 0,
    last: false
  });
  const [selectedIds, setSelectedIds] = useState<number[]>([]);
  const [batchReviewDialogOpen, setBatchReviewDialogOpen] = useState(false);

  useEffect(() => {
    fetchApplications();
    fetchStats();
  }, [pagination.page, activeTab]);

  const fetchApplications = async () => {
    setLoading(true);
    try {
      const status = activeTab === 'all' ? undefined : activeTab.toUpperCase();
      const response = await adminAPI.getAllApplications({
        page: pagination.page,
        size: pagination.size,
        status
      });
      
      // 适配新的响应结构
      setApplications(response.content);
      setPagination(prev => ({
        ...prev,
        totalElements: response.totalElements,
        totalPages: response.totalPages,
        last: response.last
      }));
    } catch (error) {
      console.error('获取申请列表失败', error);
      toast({
        title: '获取申请列表失败',
        description: '请稍后再试',
        variant: 'destructive',
      });
    } finally {
      setLoading(false);
    }
  };

  const fetchStats = async () => {
  try {
    const stats = await adminAPI.getApplicationStats();
    setStats(stats);
  } catch (error) {
    console.error('获取统计数据失败', error);
    toast({
      title: '获取统计数据失败',
      description: '请稍后再试',
      variant: 'destructive',
    });
  }
};

  const handleViewDetails = (application: Application) => {
    setSelectedApplication(application);
    setDetailsOpen(true);
  };

  const handleOpenReviewDialog = (application: Application) => {
    setSelectedApplication(application);
    setReviewDialogOpen(true);
  };

  const handleReviewChange = (e: React.ChangeEvent<HTMLTextAreaElement>) => {
    setReviewData(prev => ({ ...prev, feedback: e.target.value }));
  };

  const handleStatusChange = (value: string) => {
    setReviewData(prev => ({ ...prev, status: value }));
  };

  const handleReviewSubmit = async () => {
    if (!selectedApplication) return;
    
    try {
      await adminAPI.reviewApplication(selectedApplication.id, reviewData);
      
      toast({
        title: '审核成功',
        description: '申请审核结果已提交',
      });
      
      // 刷新申请列表
      fetchApplications();
      fetchStats();
      
      // 关闭对话框
      setReviewDialogOpen(false);
      setDetailsOpen(false);
      
      // 重置审核数据
      setReviewData({
        status: 'APPROVED',
        feedback: ''
      });
    } catch (error) {
      toast({
        title: '审核失败',
        description: '请稍后再试',
        variant: 'destructive',
      });
    }
  };

  const handleBatchReview = async () => {
    if (selectedIds.length === 0) return;
    
    try {
      await adminAPI.batchReviewApplications(selectedIds, reviewData);
      
      toast({
        title: '批量审核成功',
        description: `已成功审核 ${selectedIds.length} 条申请`,
      });
      
      // 刷新申请列表
      fetchApplications();
      fetchStats();
      
      // 关闭对话框
      setBatchReviewDialogOpen(false);
      
      // 重置选择和审核数据
      setSelectedIds([]);
      setReviewData({
        status: 'APPROVED',
        feedback: ''
      });
    } catch (error) {
      toast({
        title: '批量审核失败',
        description: '请稍后再试',
        variant: 'destructive',
      });
    }
  };

  const handlePageChange = (newPage: number) => {
    setPagination(prev => ({ ...prev, page: newPage }));
  };

  const handleSelectApplication = (id: number) => {
    setSelectedIds(prev => {
      if (prev.includes(id)) {
        return prev.filter(item => item !== id);
      } else {
        return [...prev, id];
      }
    });
  };

  const handleSelectAll = () => {
    if (selectedIds.length === applications.length) {
      setSelectedIds([]);
    } else {
      setSelectedIds(applications.map(app => app.id));
    }
  };

  const filteredApplications = applications.filter(app => 
    app.purpose.toLowerCase().includes(searchTerm.toLowerCase()) ||
    app.userName.toLowerCase().includes(searchTerm.toLowerCase()) ||
    app.location.toLowerCase().includes(searchTerm.toLowerCase())
  );

  const getStatusText = (status: string) => {
    switch (status) {
      case 'PENDING':
        return '待审核';
      case 'APPROVED':
        return '已通过';
      case 'REJECTED':
        return '已拒绝';
      case 'CANCELLED':
        return '已取消';
      default:
        return status;
    }
  };

  const getStatusColor = (status: string) => {
    switch (status) {
      case 'PENDING':
        return 'bg-yellow-100 text-yellow-800 border-yellow-200';
      case 'APPROVED':
        return 'bg-green-100 text-green-800 border-green-200';
      case 'REJECTED':
        return 'bg-red-100 text-red-800 border-red-200';
      case 'CANCELLED':
        return 'bg-gray-100 text-gray-800 border-gray-200';
      default:
        return 'bg-gray-100 text-gray-800 border-gray-200';
    }
  };

  const getStatusIcon = (status: string) => {
    switch (status) {
      case 'PENDING':
        return <Clock className="w-4 h-4" />;
      case 'APPROVED':
        return <CheckCircle className="w-4 h-4" />;
      case 'REJECTED':
        return <XCircle className="w-4 h-4" />;
      case 'CANCELLED':
        return <AlertTriangle className="w-4 h-4" />;
      default:
        return <AlertTriangle className="w-4 h-4" />;
    }
  };

  const formatDate = (dateString: string) => {
    const date = new Date(dateString);
    return date.toLocaleDateString('zh-CN');
  };

  const renderApplicationTable = () => {
    if (loading) {
      return (
        <div className="space-y-4">
          {[...Array(3)].map((_, i) => (
            <div key={i} className="flex flex-col space-y-3">
              <Skeleton className="h-10 w-full" />
              <Skeleton className="h-4 w-3/4" />
              <Skeleton className="h-4 w-1/2" />
            </div>
          ))}
        </div>
      );
    }

    if (filteredApplications.length === 0) {
      return (
        <div className="text-center py-12">
          <FileText className="w-12 h-12 text-gray-300 mx-auto mb-4" />
          <h3 className="text-lg font-medium text-gray-900">暂无申请记录</h3>
          <p className="text-gray-500 mt-1">当前状态下没有申请记录</p>
        </div>
      );
    }

    return (
      <>
        {activeTab === 'pending' && selectedIds.length > 0 && (
          <div className="bg-blue-50 border border-blue-100 rounded-lg p-4 mb-4 flex items-center justify-between">
            <div className="flex items-center">
              <CheckCheck className="w-5 h-5 text-blue-600 mr-2" />
              <span>已选择 {selectedIds.length} 条申请</span>
            </div>
            <Button
              onClick={() => setBatchReviewDialogOpen(true)}
              className="bg-blue-600 hover:bg-blue-700"
            >
              批量审核
            </Button>
          </div>
        )}

        <div className="overflow-x-auto">
          <Table>
            <TableHeader>
              <TableRow>
                {activeTab === 'pending' && (
                  <TableHead className="w-12">
                    <input
                      type="checkbox"
                      className="rounded border-gray-300"
                      checked={selectedIds.length === applications.length && applications.length > 0}
                      onChange={handleSelectAll}
                    />
                  </TableHead>
                )}
                <TableHead>申请人</TableHead>
                <TableHead>申请目的</TableHead>
                <TableHead>访问时间</TableHead>
                <TableHead>访问地点</TableHead>
                <TableHead>状态</TableHead>
                <TableHead>提交时间</TableHead>
                <TableHead>操作</TableHead>
              </TableRow>
            </TableHeader>
            <TableBody>
              {filteredApplications.map((application) => (
                <TableRow key={application.id}>
                  {activeTab === 'pending' && (
                    <TableCell>
                      <input
                        type="checkbox"
                        className="rounded border-gray-300"
                        checked={selectedIds.includes(application.id)}
                        onChange={() => handleSelectApplication(application.id)}
                      />
                    </TableCell>
                  )}
                  <TableCell className="font-medium">{application.applicantName}</TableCell>
                  <TableCell>{application.purpose}</TableCell>
                  <TableCell>
                    <div className="text-sm">
                      <div>{formatDate(application.visitDate)}</div>
                      <div className="text-gray-500">{application.visitTime}</div>
                    </div>
                  </TableCell>
                  <TableCell>{application.location}</TableCell>
                  <TableCell>
                    <Badge className={`${getStatusColor(application.status)} flex items-center gap-1 w-fit`}>
                      {getStatusIcon(application.status)}
                      {getStatusText(application.status)}
                    </Badge>
                  </TableCell>
                  <TableCell className="text-sm text-gray-600">
                    {formatDate(application.submitDate)}
                  </TableCell>
                  <TableCell>
                    <div className="flex items-center gap-2">
                      <Button
                        variant="ghost"
                        size="sm"
                        onClick={() => handleViewDetails(application)}
                      >
                        <Eye className="w-4 h-4" />
                      </Button>
                      
                      {application.status === 'PENDING' && (
                        <Button
                          variant="ghost"
                          size="sm"
                          className="text-blue-600 hover:text-blue-700 hover:bg-blue-50"
                          onClick={() => handleOpenReviewDialog(application)}
                        >
                          审核
                        </Button>
                      )}
                    </div>
                  </TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>

          {/* 分页 */}
          {pagination.totalPages > 1 && (
            <div className="flex justify-center mt-6">
              <div className="flex items-center gap-2">
                <Button
                  variant="outline"
                  size="sm"
                  onClick={() => handlePageChange(pagination.page - 1)}
                  disabled={pagination.page === 0}
                >
                  上一页
                </Button>
                <span className="text-sm text-gray-600">
                  第 {pagination.page + 1} 页，共 {pagination.totalPages} 页
                </span>
                <Button
                  variant="outline"
                  size="sm"
                  onClick={() => handlePageChange(pagination.page + 1)}
                  disabled={pagination.last}
                >
                  下一页
                </Button>
              </div>
            </div>
          )}
        </div>
      </>
    );
  };

  return (
    <div className="space-y-6">
      {/* 统计卡片 */}
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-4">
        <Card>
          <CardContent className="p-6">
            <div className="flex items-center justify-between">
              <div>
                <p className="text-sm font-medium text-gray-500">待审核申请</p>
                <h3 className="text-2xl font-bold mt-1">{stats?.pending || 0}</h3>
              </div>
              <div className="bg-yellow-100 p-3 rounded-full">
                <Clock className="w-6 h-6 text-yellow-600" />
              </div>
            </div>
          </CardContent>
        </Card>
        
        <Card>
          <CardContent className="p-6">
            <div className="flex items-center justify-between">
              <div>
                <p className="text-sm font-medium text-gray-500">已通过申请</p>
                <h3 className="text-2xl font-bold mt-1">{stats?.approved || 0}</h3>
              </div>
              <div className="bg-green-100 p-3 rounded-full">
                <CheckCircle className="w-6 h-6 text-green-600" />
              </div>
            </div>
          </CardContent>
        </Card>
        
        <Card>
          <CardContent className="p-6">
            <div className="flex items-center justify-between">
              <div>
                <p className="text-sm font-medium text-gray-500">今日新增</p>
                <h3 className="text-2xl font-bold mt-1">{stats?.todayNew || 0}</h3>
              </div>
              <div className="bg-blue-100 p-3 rounded-full">
                <Calendar className="w-6 h-6 text-blue-600" />
              </div>
            </div>
          </CardContent>
        </Card>
        
        <Card>
          <CardContent className="p-6">
            <div className="flex items-center justify-between">
              <div>
                <p className="text-sm font-medium text-gray-500">总申请数</p>
                <h3 className="text-2xl font-bold mt-1">{stats?.total || 0}</h3>
              </div>
              <div className="bg-purple-100 p-3 rounded-full">
                <BarChart className="w-6 h-6 text-purple-600" />
              </div>
            </div>
          </CardContent>
        </Card>
      </div>

      {/* 申请列表卡片 */}
      <Card>
        <CardHeader>
          <CardTitle>进校园申请管理</CardTitle>
          <CardDescription>审核和管理校友的进校园申请</CardDescription>
        </CardHeader>
        <CardContent>
          <Tabs value={activeTab} onValueChange={setActiveTab}>
            <div className="flex flex-col sm:flex-row sm:items-center justify-between gap-4 mb-6">
              <TabsList>
                <TabsTrigger value="pending">待审核</TabsTrigger>
                <TabsTrigger value="approved">已通过</TabsTrigger>
                <TabsTrigger value="rejected">已拒绝</TabsTrigger>
                <TabsTrigger value="all">全部</TabsTrigger>
              </TabsList>
              
              <div className="flex flex-1 sm:max-w-xs">
                <div className="relative w-full">
                  <Search className="absolute left-3 top-3 w-4 h-4 text-gray-400" />
                  <Input
                    placeholder="搜索申请人、目的或地点..."
                    value={searchTerm}
                    onChange={(e) => setSearchTerm(e.target.value)}
                    className="pl-10"
                  />
                </div>
              </div>
            </div>

            <TabsContent value="pending" className="space-y-4">
              {renderApplicationTable()}
            </TabsContent>
            
            <TabsContent value="approved" className="space-y-4">
              {renderApplicationTable()}
            </TabsContent>
            
            <TabsContent value="rejected" className="space-y-4">
              {renderApplicationTable()}
            </TabsContent>
            
            <TabsContent value="all" className="space-y-4">
              {renderApplicationTable()}
            </TabsContent>
          </Tabs>
        </CardContent>
      </Card>

      {/* 申请详情对话框 */}
      <Dialog open={detailsOpen} onOpenChange={setDetailsOpen}>
        <DialogContent className="max-w-2xl max-h-[80vh] overflow-y-auto">
          <DialogHeader>
            <DialogTitle>申请详情</DialogTitle>
            <DialogDescription>
              申请ID: {selectedApplication?.id}
            </DialogDescription>
          </DialogHeader>
          
          {selectedApplication && (
            <div className="space-y-6">
              <div className="grid grid-cols-1 md:grid-cols-2 gap-4">




                 <div>
            <h4 className="text-sm font-medium text-gray-500">申请人</h4>
            <p className="mt-1">{selectedApplication.applicantName}</p>
          </div>
          <div>
            <h4 className="text-sm font-medium text-gray-500">学号</h4>
            <p className="mt-1">{selectedApplication.studentId}</p>
          </div>
          <div>
            <h4 className="text-sm font-medium text-gray-500">毕业年份</h4>
            <p className="mt-1">{selectedApplication.graduationYear}</p>
          </div>
          <div>
            <h4 className="text-sm font-medium text-gray-500">专业</h4>
            <p className="mt-1">{selectedApplication.major}</p>
          </div>




                <div>
                  <h4 className="text-sm font-medium text-gray-500">申请人</h4>
                  <p className="mt-1">{selectedApplication.applicantName}</p>
                </div>
                <div>
                  <h4 className="text-sm font-medium text-gray-500">联系电话</h4>
                  <p className="mt-1">{selectedApplication.studentId}</p>
                </div>
                <div>
                  <h4 className="text-sm font-medium text-gray-500">申请目的</h4>
                  <p className="mt-1">{selectedApplication.purpose}</p>
                </div>
                <div>
                  <h4 className="text-sm font-medium text-gray-500">申请状态</h4>
                  <Badge className={`${getStatusColor(selectedApplication.status)} flex items-center gap-1 w-fit mt-1`}>
                    {getStatusIcon(selectedApplication.status)}
                    {selectedApplication.status}
                  </Badge>
                </div>
                <div>
                  <h4 className="text-sm font-medium text-gray-500">访问日期</h4>
                  <p className="mt-1">{formatDate(selectedApplication.visitDate)}</p>
                </div>
                <div>
                  <h4 className="text-sm font-medium text-gray-500">访问时间</h4>
                  <p className="mt-1">{selectedApplication.visitTime}</p>
                </div>
                <div>
                  <h4 className="text-sm font-medium text-gray-500">停留时长</h4>
                  <p className="mt-1">{selectedApplication.duration}</p>
                </div>
                <div>
                  <h4 className="text-sm font-medium text-gray-500">访问地点</h4>
                  <p className="mt-1">{selectedApplication.location}</p>
                </div>
                {selectedApplication.contactPerson && (
                  <>
                    <div>
                      <h4 className="text-sm font-medium text-gray-500">校内联系人</h4>
                      <p className="mt-1">{selectedApplication.contactPerson}</p>
                    </div>
                    <div>
                      <h4 className="text-sm font-medium text-gray-500">联系人电话</h4>
                      <p className="mt-1">{selectedApplication.contactPhone}</p>
                    </div>
                  </>
                )}
                <div>
                  <h4 className="text-sm font-medium text-gray-500">紧急联系人</h4>
                  <p className="mt-1">{selectedApplication.emergencyContact}</p>
                </div>
                <div>
                  <h4 className="text-sm font-medium text-gray-500">紧急联系电话</h4>
                  <p className="mt-1">{selectedApplication.emergencyPhone}</p>
                </div>
                <div>
                  <h4 className="text-sm font-medium text-gray-500">提交时间</h4>
                  <p className="mt-1">{selectedApplication.submitDate}</p>
                </div>
              </div>

              {selectedApplication.description && (
                <div>
                  <h4 className="text-sm font-medium text-gray-500">详细说明</h4>
                  <p className="mt-1 p-3 bg-gray-50 rounded-md text-gray-700">
                    {selectedApplication.description}
                  </p>
                </div>
              )}

              {selectedApplication.status !== 'PENDING' && (
                <div className="border-t pt-4">
                  <h4 className="font-medium">审核信息</h4>
                  <div className="grid grid-cols-1 md:grid-cols-2 gap-4 mt-2">
                    {selectedApplication.reviewerName && (
                      <div>
                        <h4 className="text-sm font-medium text-gray-500">审核人</h4>
                        <p className="mt-1">{selectedApplication.reviewerName}</p>
                      </div>
                    )}
                    {selectedApplication.reviewDate && (
                      <div>
                        <h4 className="text-sm font-medium text-gray-500">审核时间</h4>
                        <p className="mt-1">{formatDate(selectedApplication.reviewDate)}</p>
                      </div>
                    )}
                  </div>
                  {selectedApplication.feedback && (
                    <div className="mt-2">
                      <h4 className="text-sm font-medium text-gray-500">审核意见</h4>
                      <p className="mt-1 p-3 bg-gray-50 rounded-md text-gray-700">
                        {selectedApplication.feedback}
                      </p>
                    </div>
                  )}
                </div>
              )}

              {selectedApplication.status === 'PENDING' && (
                <div className="flex justify-end gap-2">
                  <Button
                    variant="outline"
                    onClick={() => setDetailsOpen(false)}
                  >
                    关闭
                  </Button>
                  <Button
                    className="bg-blue-600 hover:bg-blue-700"
                    onClick={() => {
                      setDetailsOpen(false);
                      handleOpenReviewDialog(selectedApplication);
                    }}
                  >
                    审核申请
                  </Button>
                </div>
              )}
            </div>
          )}
        </DialogContent>
      </Dialog>

      {/* 审核对话框 */}
      <Dialog open={reviewDialogOpen} onOpenChange={setReviewDialogOpen}>
        <DialogContent>
          <DialogHeader>
            <DialogTitle>审核申请</DialogTitle>
            <DialogDescription>
              请选择审核结果并填写审核意见
            </DialogDescription>
          </DialogHeader>
          
          <div className="space-y-4 py-4">
            <div className="space-y-2">
              <Label htmlFor="status">审核结果</Label>
              <Select
                value={reviewData.status}
                onValueChange={handleStatusChange}
              >
                <SelectTrigger>
                  <SelectValue placeholder="选择审核结果" />
                </SelectTrigger>
                <SelectContent>
                  <SelectItem value="APPROVED">
                    <div className="flex items-center">
                      <CheckCircle className="w-4 h-4 text-green-600 mr-2" />
                      通过
                    </div>
                  </SelectItem>
                  <SelectItem value="REJECTED">
                    <div className="flex items-center">
                      <XCircle className="w-4 h-4 text-red-600 mr-2" />
                      拒绝
                    </div>
                  </SelectItem>
                </SelectContent>
              </Select>
            </div>
            
            <div className="space-y-2">
              <Label htmlFor="feedback">审核意见</Label>
              <Textarea
                id="feedback"
                placeholder="请填写审核意见（选填）"
                value={reviewData.feedback}
                onChange={handleReviewChange}
                rows={4}
              />
            </div>
          </div>
          
          <DialogFooter>
            <Button
              variant="outline"
              onClick={() => setReviewDialogOpen(false)}
            >
              取消
            </Button>
            <Button
              className={reviewData.status === 'APPROVED' ? 'bg-green-600 hover:bg-green-700' : 'bg-red-600 hover:bg-red-700'}
              onClick={handleReviewSubmit}
            >
              {reviewData.status === 'APPROVED' ? '通过申请' : '拒绝申请'}
            </Button>
          </DialogFooter>
        </DialogContent>
      </Dialog>

      {/* 批量审核对话框 */}
      <Dialog open={batchReviewDialogOpen} onOpenChange={setBatchReviewDialogOpen}>
        <DialogContent>
          <DialogHeader>
            <DialogTitle>批量审核申请</DialogTitle>
            <DialogDescription>
              您正在批量审核 {selectedIds.length} 条申请
            </DialogDescription>
          </DialogHeader>
          
          <div className="space-y-4 py-4">
            <div className="space-y-2">
              <Label htmlFor="status">审核结果</Label>
              <Select
                value={reviewData.status}
                onValueChange={handleStatusChange}
              >
                <SelectTrigger>
                  <SelectValue placeholder="选择审核结果" />
                </SelectTrigger>
                <SelectContent>
                  <SelectItem value="APPROVED">
                    <div className="flex items-center">
                      <CheckCircle className="w-4 h-4 text-green-600 mr-2" />
                      通过
                    </div>
                  </SelectItem>
                  <SelectItem value="REJECTED">
                    <div className="flex items-center">
                      <XCircle className="w-4 h-4 text-red-600 mr-2" />
                      拒绝
                    </div>
                  </SelectItem>
                </SelectContent>
              </Select>
            </div>
            
            <div className="space-y-2">
              <Label htmlFor="feedback">审核意见</Label>
              <Textarea
                id="feedback"
                placeholder="请填写审核意见（选填）"
                value={reviewData.feedback}
                onChange={handleReviewChange}
                rows={4}
              />
            </div>
          </div>
          
          <DialogFooter>
            <Button
              variant="outline"
              onClick={() => setBatchReviewDialogOpen(false)}
            >
              取消
            </Button>
            <Button
              className={reviewData.status === 'APPROVED' ? 'bg-green-600 hover:bg-green-700' : 'bg-red-600 hover:bg-red-700'}
              onClick={handleBatchReview}
            >
              {reviewData.status === 'APPROVED' ? '批量通过' : '批量拒绝'}
            </Button>
          </DialogFooter>
        </DialogContent>
      </Dialog>
    </div>
  );
}