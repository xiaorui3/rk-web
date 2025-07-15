use student;
select * from student.t_student;

-- 插入
insert into t_student values (1,'赵锐','男','20','2025-7-8','科技三班','3505469466@qq.com','99');
insert into t_student values (2,'赵锐','男','20',now(),'科技三班','3505469466@qq.com');
insert into t_student (sno,sname,sex) values (3,'张三','男');
insert into t_student (sno,sname,sex,enterdate) values (4,'张三','男','4164-5-5');
insert into t_student (sno,sname,sex,enterdate) values (5,'张三','男','4164-5-5');
-- 修改表中数据
update student.t_student set sex = '女';
update student.t_student set sex = '女' where sno=2;

-- 删除

delete from t_student where sno=2;

-- 查看
select  * from t_student;

-- 修改表结构 增加一列
alter table t_student add score double(5,2);
select  * from t_student;
-- alter table score rename t_student;
update t_student set score = 123.5 where sno=1;