import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { Card, CardContent, CardDescription, CardFooter, CardHeader, CardTitle } from '@/components/ui/card';
import { Button } from '@/components/ui/button';
import { Input } from '@/components/ui/input';
import { Label } from '@/components/ui/label';
import { Textarea } from '@/components/ui/textarea';
import { useToast } from '@/hooks/use-toast';
import { applicationAPI } from '@/services/api-service';
import { 
  Calendar, 
  Clock, 
  MapPin, 
  FileText, 
  Phone, 
  AlertCircle,
  Upload,
  X,
  FileIcon
} from 'lucide-react';

export default function ApplicationPage() {
  const navigate = useNavigate();
  const { toast } = useToast();
  const [step, setStep] = useState(1);
  const [isLoading, setIsLoading] = useState(false);
  const [files, setFiles] = useState<File[]>([]);
  
  const [formData, setFormData] = useState({
    purpose: '',
    visitDate: '',
    visitTime: '',
    duration: '',
    location: '',
    contactPerson: '',
    contactPhone: '',
    description: '',
    emergencyContact: '',
    emergencyPhone: ''
  });

  const handleChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) => {
    const { name, value } = e.target;
    setFormData(prev => ({ ...prev, [name]: value }));
  };

  const handleFileChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    if (e.target.files) {
      const newFiles = Array.from(e.target.files);
      setFiles(prev => [...prev, ...newFiles]);
    }
  };

  const removeFile = (index: number) => {
    setFiles(prev => prev.filter((_, i) => i !== index));
  };

  const handleNextStep = () => {
    // 表单验证
    if (step === 1) {
      if (!formData.purpose || !formData.visitDate || !formData.visitTime || !formData.duration || !formData.location) {
        toast({
          title: '请填写完整信息',
          description: '所有带*的字段都是必填项',
          variant: 'destructive',
        });
        return;
      }
    } else if (step === 2) {
      if (!formData.emergencyContact || !formData.emergencyPhone) {
        toast({
          title: '请填写完整信息',
          description: '紧急联系人和电话是必填项',
          variant: 'destructive',
        });
        return;
      }

      // 手机号格式验证
      const phoneRegex = /^1[3-9]\d{9}$/;
      if (formData.emergencyPhone && !phoneRegex.test(formData.emergencyPhone)) {
        toast({
          title: '手机号格式错误',
          description: '请输入正确的手机号码',
          variant: 'destructive',
        });
        return;
      }

      if (formData.contactPhone && !phoneRegex.test(formData.contactPhone)) {
        toast({
          title: '手机号格式错误',
          description: '请输入正确的手机号码',
          variant: 'destructive',
        });
        return;
      }
    }

    setStep(prev => prev + 1);
  };

  const handlePrevStep = () => {
    setStep(prev => prev - 1);
  };

  // const handleSubmit = async () => {
  //   setIsLoading(true);
    
  //   try {
  //     // 修改这里，使用正确的API方法
  //     await applicationAPI.submitApplication({
  //       ...formData,
  //       visitDateTime: `${formData.visitDate}T${formData.visitTime}:00`
  //     });
      
  //     // 如果有文件，上传文件
  //     if (files.length > 0) {
  //       const formData = new FormData();
  //       files.forEach(file => {
  //         formData.append('files', file);
  //       });
  //       // 这里需要获取申请ID，但由于我们没有实际的后端，所以这里只是示例
  //       await applicationAPI.uploadFile(applicationId, formData);
  //     }
      
  //     toast({
  //       title: '申请提交成功',
  //       description: '您的进校园申请已成功提交，请等待审核',
  //     });
      
  //     navigate('/applications');
  //   } catch (error: any) {
  //     toast({
  //       title: '申请提交失败',
  //       description: error.response?.data?.message || '请检查您的信息并稍后再试',
  //       variant: 'destructive',
  //     });
  //   } finally {
  //     setIsLoading(false);
  //   }
  // };

  const handleSubmit = async () => {
  setIsLoading(true);

  try {
    const payload = new FormData();

    // 1) 表单字段 → JSON Blob
    payload.append(
      'application',
      new Blob(
        [
          JSON.stringify({
            purpose: formData.purpose,
            visitDate: formData.visitDate,
            visitTime: formData.visitTime,
            duration: formData.duration,
            location: formData.location,
            contactPerson: formData.contactPerson,
            contactPhone: formData.contactPhone,
            description: formData.description,
            emergencyContact: formData.emergencyContact,
            emergencyPhone: formData.emergencyPhone,
          }),
        ],
        { type: 'application/json' }
      )
    );

    // 2) 文件
    files.forEach((file) => payload.append('files', file));

    // 3) 发送
    await applicationAPI.submitApplication(payload);

    toast({ title: '申请提交成功', description: '请等待审核' });
    navigate('/applications');
  } catch (error: any) {
    toast({
      title: '申请提交失败',
      description: error.response?.data?.message || '请稍后重试',
      variant: 'destructive',
    });
  } finally {
    setIsLoading(false);
  }
};

  return (
    <div className="max-w-3xl mx-auto">
      <Card className="shadow-md">
        <CardHeader>
          <CardTitle>进校园申请</CardTitle>
          <CardDescription>请填写以下信息申请进入校园</CardDescription>
        </CardHeader>
        <CardContent>
          {/* 进度指示器 */}
          <div className="mb-8">
            <div className="flex items-center justify-between">
              <div className="flex flex-col items-center">
                <div className={`w-8 h-8 rounded-full flex items-center justify-center ${
                  step >= 1 ? 'bg-blue-600 text-white' : 'bg-gray-200 text-gray-500'
                }`}>
                  1
                </div>
                <span className="text-xs mt-1">基本信息</span>
              </div>
              <div className={`flex-1 h-1 mx-2 ${step >= 2 ? 'bg-blue-600' : 'bg-gray-200'}`}></div>
              <div className="flex flex-col items-center">
                <div className={`w-8 h-8 rounded-full flex items-center justify-center ${
                  step >= 2 ? 'bg-blue-600 text-white' : 'bg-gray-200 text-gray-500'
                }`}>
                  2
                </div>
                <span className="text-xs mt-1">附加信息</span>
              </div>
              <div className={`flex-1 h-1 mx-2 ${step >= 3 ? 'bg-blue-600' : 'bg-gray-200'}`}></div>
              <div className="flex flex-col items-center">
                <div className={`w-8 h-8 rounded-full flex items-center justify-center ${
                  step >= 3 ? 'bg-blue-600 text-white' : 'bg-gray-200 text-gray-500'
                }`}>
                  3
                </div>
                <span className="text-xs mt-1">确认提交</span>
              </div>
            </div>
          </div>

          {/* 步骤1：基本信息 */}
          {step === 1 && (
            <div className="space-y-4">
              <div className="space-y-2">
                <Label htmlFor="purpose">
                  访问目的 <span className="text-red-500">*</span>
                </Label>
                <Input
                  id="purpose"
                  name="purpose"
                  placeholder="请简述您的访问目的"
                  value={formData.purpose}
                  onChange={handleChange}
                />
              </div>

              <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                <div className="space-y-2">
                  <Label htmlFor="visitDate">
                    访问日期 <span className="text-red-500">*</span>
                  </Label>
                  <div className="relative">
                    <Calendar className="absolute left-3 top-3 h-4 w-4 text-gray-500" />
                    <Input
                      id="visitDate"
                      name="visitDate"
                      type="date"
                      className="pl-10"
                      value={formData.visitDate}
                      onChange={handleChange}
                    />
                  </div>
                </div>

                <div className="space-y-2">
                  <Label htmlFor="visitTime">
                    访问时间 <span className="text-red-500">*</span>
                  </Label>
                  <div className="relative">
                    <Clock className="absolute left-3 top-3 h-4 w-4 text-gray-500" />
                    <Input
                      id="visitTime"
                      name="visitTime"
                      type="time"
                      className="pl-10"
                      value={formData.visitTime}
                      onChange={handleChange}
                    />
                  </div>
                </div>
              </div>

              <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                <div className="space-y-2">
                  <Label htmlFor="duration">
                    停留时长 <span className="text-red-500">*</span>
                  </Label>
                  <Input
                    id="duration"
                    name="duration"
                    placeholder="例如：2小时、半天、1天"
                    value={formData.duration}
                    onChange={handleChange}
                  />
                </div>

                <div className="space-y-2">
                  <Label htmlFor="location">
                    访问地点 <span className="text-red-500">*</span>
                  </Label>
                  <div className="relative">
                    <MapPin className="absolute left-3 top-3 h-4 w-4 text-gray-500" />
                    <Input
                      id="location"
                      name="location"
                      placeholder="例如：图书馆、教学楼"
                      className="pl-10"
                      value={formData.location}
                      onChange={handleChange}
                    />
                  </div>
                </div>
              </div>
            </div>
          )}

          {/* 步骤2：附加信息 */}
          {step === 2 && (
            <div className="space-y-4">
              <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                <div className="space-y-2">
                  <Label htmlFor="contactPerson">
                    校内联系人
                  </Label>
                  <Input
                    id="contactPerson"
                    name="contactPerson"
                    placeholder="如有校内联系人请填写"
                    value={formData.contactPerson}
                    onChange={handleChange}
                  />
                </div>

                <div className="space-y-2">
                  <Label htmlFor="contactPhone">
                    联系人电话
                  </Label>
                  <div className="relative">
                    <Phone className="absolute left-3 top-3 h-4 w-4 text-gray-500" />
                    <Input
                      id="contactPhone"
                      name="contactPhone"
                      placeholder="联系人手机号"
                      className="pl-10"
                      value={formData.contactPhone}
                      onChange={handleChange}
                    />
                  </div>
                </div>
              </div>

              <div className="space-y-2">
                <Label htmlFor="description">
                  详细说明
                </Label>
                <Textarea
                  id="description"
                  name="description"
                  placeholder="请详细描述您的访问目的和计划"
                  rows={4}
                  value={formData.description}
                  onChange={handleChange}
                />
              </div>

              <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                <div className="space-y-2">
                  <Label htmlFor="emergencyContact">
                    紧急联系人 <span className="text-red-500">*</span>
                  </Label>
                  <Input
                    id="emergencyContact"
                    name="emergencyContact"
                    placeholder="请填写紧急联系人姓名"
                    value={formData.emergencyContact}
                    onChange={handleChange}
                  />
                </div>

                <div className="space-y-2">
                  <Label htmlFor="emergencyPhone">
                    紧急联系电话 <span className="text-red-500">*</span>
                  </Label>
                  <div className="relative">
                    <Phone className="absolute left-3 top-3 h-4 w-4 text-gray-500" />
                    <Input
                      id="emergencyPhone"
                      name="emergencyPhone"
                      placeholder="紧急联系人手机号"
                      className="pl-10"
                      value={formData.emergencyPhone}
                      onChange={handleChange}
                    />
                  </div>
                </div>
              </div>

              {/* <div className="space-y-2">
                <Label>
                  上传文件（选填）
                </Label>
                <div className="border-2 border-dashed border-gray-300 rounded-lg p-6 text-center">
                  <input
                    type="file"
                    id="file-upload"
                    className="hidden"
                    multiple
                    onChange={handleFileChange}
                  />
                  <label
                    htmlFor="file-upload"
                    className="cursor-pointer flex flex-col items-center justify-center"
                  >
                    <Upload className="h-10 w-10 text-gray-400 mb-2" />
                    <p className="text-sm text-gray-600">点击上传文件或拖拽文件到此处</p>
                    <p className="text-xs text-gray-500 mt-1">
                      支持格式：JPG、JPEG、PNG、PDF，单个文件不超过5MB
                    </p>
                  </label>
                </div>

                {files.length > 0 && (
                  <div className="mt-4 space-y-2">
                    <Label>已上传文件</Label>
                    <div className="space-y-2">
                      {files.map((file, index) => (
                        <div
                          key={index}
                          className="flex items-center justify-between bg-gray-50 p-2 rounded-md"
                        >
                          <div className="flex items-center">
                            <FileIcon className="h-4 w-4 text-blue-600 mr-2" />
                            <span className="text-sm truncate max-w-[200px]">
                              {file.name}
                            </span>
                            <span className="text-xs text-gray-500 ml-2">
                              {(file.size / 1024).toFixed(1)} KB
                            </span>
                          </div>
                          <Button
                            variant="ghost"
                            size="sm"
                            onClick={() => removeFile(index)}
                          >
                            <X className="h-4 w-4 text-gray-500" />
                          </Button>
                        </div>
                      ))}
                    </div>
                  </div>
                )}
              </div> */}
            </div>
          )}

          {/* 步骤3：确认提交 */}
          {step === 3 && (
            <div className="space-y-6">
              <div className="bg-blue-50 border border-blue-100 rounded-lg p-4 flex items-start">
                <AlertCircle className="h-5 w-5 text-blue-600 mr-2 mt-0.5" />
                <div>
                  <h4 className="font-medium text-blue-800">提交前请确认</h4>
                  <p className="text-sm text-blue-700 mt-1">
                    请确认您填写的信息准确无误，提交后将由管理员审核，审核结果将通过系统通知您。
                  </p>
                </div>
              </div>

              <div className="space-y-4">
                <h4 className="font-medium">基本信息</h4>
                <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                  <div>
                    <p className="text-sm text-gray-500">访问目的</p>
                    <p className="font-medium">{formData.purpose}</p>
                  </div>
                  <div>
                    <p className="text-sm text-gray-500">访问时间</p>
                    <p className="font-medium">{formData.visitDate} {formData.visitTime}</p>
                  </div>
                  <div>
                    <p className="text-sm text-gray-500">停留时长</p>
                    <p className="font-medium">{formData.duration}</p>
                  </div>
                  <div>
                    <p className="text-sm text-gray-500">访问地点</p>
                    <p className="font-medium">{formData.location}</p>
                  </div>
                </div>

                <h4 className="font-medium mt-4">附加信息</h4>
                <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                  {formData.contactPerson && (
                    <>
                      <div>
                        <p className="text-sm text-gray-500">校内联系人</p>
                        <p className="font-medium">{formData.contactPerson}</p>
                      </div>
                      <div>
                        <p className="text-sm text-gray-500">联系人电话</p>
                        <p className="font-medium">{formData.contactPhone}</p>
                      </div>
                    </>
                  )}
                  <div>
                    <p className="text-sm text-gray-500">紧急联系人</p>
                    <p className="font-medium">{formData.emergencyContact}</p>
                  </div>
                  <div>
                    <p className="text-sm text-gray-500">紧急联系电话</p>
                    <p className="font-medium">{formData.emergencyPhone}</p>
                  </div>
                </div>

                {formData.description && (
                  <div>
                    <p className="text-sm text-gray-500">详细说明</p>
                    <p className="bg-gray-50 p-3 rounded-md text-gray-700 mt-1">
                      {formData.description}
                    </p>
                  </div>
                )}

                {files.length > 0 && (
                  <div>
                    <p className="text-sm text-gray-500">上传文件</p>
                    <div className="mt-1 space-y-1">
                      {files.map((file, index) => (
                        <div key={index} className="flex items-center">
                          <FileIcon className="h-4 w-4 text-blue-600 mr-2" />
                          <span className="text-sm">{file.name}</span>
                        </div>
                      ))}
                    </div>
                  </div>
                )}
              </div>
            </div>
          )}
        </CardContent>
        <CardFooter className="flex justify-between">
          {step > 1 ? (
            <Button
              variant="outline"
              onClick={handlePrevStep}
              disabled={isLoading}
            >
              上一步
            </Button>
          ) : (
            <div></div>
          )}
          
          {step < 3 ? (
            <Button onClick={handleNextStep}>下一步</Button>
          ) : (
            <Button 
              onClick={handleSubmit} 
              disabled={isLoading}
              className="bg-blue-600 hover:bg-blue-700"
            >
              {isLoading ? '提交中...' : '提交申请'}
            </Button>
          )}
        </CardFooter>
      </Card>
    </div>
  );
}