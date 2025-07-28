import { useState, useEffect } from 'react';
import { Card, CardContent, CardDescription, CardHeader, CardTitle } from '@/components/ui/card';
import { Button } from '@/components/ui/button';
import { Badge } from '@/components/ui/badge';
import { Input } from '@/components/ui/input';
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
} from '@/components/ui/dialog';
import { Skeleton } from '@/components/ui/skeleton';
import { applicationAPI } from '@/services/api-service';
import { useToast } from '@/hooks/use-toast';
import { 
  Search, 
  Filter, 
  Eye, 
  Clock, 
  CheckCircle, 
  XCircle,
  Calendar,
  FileText,
  AlertTriangle
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
  statusText: string;
  submitDate: string;
  reviewDate?: string;
  reviewer?: string;
  feedback?: string;
}

export default function ApplicationListPage() {
  const { toast } = useToast();
  const [applications, setApplications] = useState<Application[]>([]);
  const [selectedApplication, setSelectedApplication] = useState<Application | null>(null);
  const [detailsOpen, setDetailsOpen] = useState(false);
  const [loading, setLoading] = useState(true);
  const [searchTerm, setSearchTerm] = useState('');
  const [statusFilter, setStatusFilter] = useState('all');
  const [pagination, setPagination] = useState({
    page: 0,
    size: 10,
    totalElements: 0,
    totalPages: 0,
    last: false
  });

  useEffect(() => {
    fetchApplications();
  }, [pagination.page, statusFilter]);

  const fetchApplications = async () => {
    setLoading(true);
    try {
      const params = {
        page: pagination.page,
        size: pagination.size,
        status: statusFilter !== 'all' ? statusFilter : undefined
      };
      
      const response = await applicationAPI.getApplications(params);
      
      setApplications(response.content || []);
      setPagination(prev => ({
        ...prev,
        totalElements: response.totalElements || 0,
        totalPages: response.totalPages || 0,
        last: response.last || false
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

  const handleViewDetails = (application: Application) => {
    setSelectedApplication(application);
    setDetailsOpen(true);
  };

  const handleCancelApplication = async (id: number) => {
    try {
      await applicationAPI.cancelApplication(id);
      toast({
        title: '申请已取消',
        description: '您的申请已成功取消',
      });
      fetchApplications();
    } catch (error) {
      toast({
        title: '取消申请失败',
        description: '请稍后再试',
        variant: 'destructive',
      });
    }
  };

  const handlePageChange = (newPage: number) => {
    setPagination(prev => ({ ...prev, page: newPage }));
  };

  const filteredApplications = applications.filter(app => 
    app.purpose.toLowerCase().includes(searchTerm.toLowerCase()) ||
    app.location.toLowerCase().includes(searchTerm.toLowerCase())
  );

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

  return (
    <div className="space-y-6">
      <Card>
        <CardHeader>
          <CardTitle>我的申请</CardTitle>
          <CardDescription>查看您的进校园申请记录</CardDescription>
        </CardHeader>
        <CardContent>
          {/* 搜索和筛选 */}
          <div className="flex flex-col sm:flex-row gap-4 mb-6">
            <div className="flex-1">
              <div className="relative">
                <Search className="absolute left-3 top-3 w-4 h-4 text-gray-400" />
                <Input
                  placeholder="搜索申请目的或地点..."
                  value={searchTerm}
                  onChange={(e) => setSearchTerm(e.target.value)}
                  className="pl-10"
                />
              </div>
            </div>
            <Select value={statusFilter} onValueChange={setStatusFilter}>
              <SelectTrigger className="w-full sm:w-48">
                <SelectValue placeholder="选择状态" />
              </SelectTrigger>
              <SelectContent>
                <SelectItem value="all">全部状态</SelectItem>
                <SelectItem value="PENDING">待审核</SelectItem>
                <SelectItem value="APPROVED">已通过</SelectItem>
                <SelectItem value="REJECTED">已拒绝</SelectItem>
                <SelectItem value="CANCELLED">已取消</SelectItem>
              </SelectContent>
            </Select>
          </div>

          {/* 申请列表 */}
          {loading ? (
            <div className="space-y-4">
              {[...Array(3)].map((_, i) => (
                <div key={i} className="flex flex-col space-y-3">
                  <Skeleton className="h-10 w-full" />
                  <Skeleton className="h-4 w-3/4" />
                  <Skeleton className="h-4 w-1/2" />
                </div>
              ))}
            </div>
          ) : filteredApplications.length > 0 ? (
            <div className="overflow-x-auto">
              <Table>
                <TableHeader>
                  <TableRow>
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
                      <TableCell className="font-medium">{application.purpose}</TableCell>
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
                          {application.statusText}
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
                              className="text-red-600 hover:text-red-700 hover:bg-red-50"
                              onClick={() => handleCancelApplication(application.id)}
                            >
                              取消
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
          ) : (
            <div className="text-center py-12">
              <FileText className="w-12 h-12 text-gray-300 mx-auto mb-4" />
              <h3 className="text-lg font-medium text-gray-900">暂无申请记录</h3>
              <p className="text-gray-500 mt-1">您还没有提交过进校园申请</p>
              <Button 
                className="mt-4 bg-blue-600 hover:bg-blue-700"
                onClick={() => window.location.href = '/application'}
              >
                立即申请
              </Button>
            </div>
          )}
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
                  <h4 className="text-sm font-medium text-gray-500">申请目的</h4>
                  <p className="mt-1">{selectedApplication.purpose}</p>
                </div>
                <div>
                  <h4 className="text-sm font-medium text-gray-500">申请状态</h4>
                  <Badge className={`${getStatusColor(selectedApplication.status)} flex items-center gap-1 w-fit mt-1`}>
                    {getStatusIcon(selectedApplication.status)}
                    {selectedApplication.statusText}
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

              {selectedApplication.status !== 'PENDING' && selectedApplication.status !== 'CANCELLED' && (
                <div className="border-t pt-4">
                  <h4 className="font-medium">审核信息</h4>
                  <div className="grid grid-cols-1 md:grid-cols-2 gap-4 mt-2">
                    {selectedApplication.reviewer && (
                      <div>
                        <h4 className="text-sm font-medium text-gray-500">审核人</h4>
                        <p className="mt-1">{selectedApplication.reviewer}</p>
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
                <div className="flex justify-end">
                  <Button
                    variant="destructive"
                    onClick={() => {
                      handleCancelApplication(selectedApplication.id);
                      setDetailsOpen(false);
                    }}
                  >
                    取消申请
                  </Button>
                </div>
              )}
            </div>
          )}
        </DialogContent>
      </Dialog>
    </div>
  );
}