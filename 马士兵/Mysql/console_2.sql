-- 创建数据库
create database stu;
use stu;
-- 创建表
create table t_stu(
    sno varchar(20) not null primary key ,
    sname varchar(100),
    sage int(3)
);
-- 增加一列
alter table t_stu add score double(5,2);

-- 插入数据
insert into t_stu values ('1','zhangsan',18,'52.2');
insert into t_stu values ('2','lisi',28,'72.6');
insert into t_stu values ('3','lisi',28,'72.6');
-- 查询数据
select * from t_stu;
--  修改数据
update t_stu set sname='wangwu' where sno=2;
-- 删除数据
delete from t_stu where sno=3;

drop database  stu;


