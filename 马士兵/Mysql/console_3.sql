-- 创建数据库
create database stu;
-- 创建表
use stu;
create table t_stu(
    sno varchar(20) not null primary key ,
    sname varchar(10) ,
    sage int(4)
);
-- 查询表
select * from t_stu;
-- 修改表结构
alter table t_stu add score double(5,2);
select * from t_stu;
-- 插入数据
insert into t_stu values ('1','213',123,88.8);
select * from t_stu;
-- 修改数据
update t_stu set sname='zhangsan' where sno=1;
select * from t_stu;
-- 删除数据
delete from t_stu where sno=1;
select * from t_stu;
-- 查询表
select * from t_stu;

alter table t_stu add sex varchar(1);
select * from t_stu;
insert into t_stu values ('2','213',123,88.83213,'男');
select * from t_stu;

update t_stu set sname='lisi' where sno=2;
select * from t_stu;

alter table t_stu drop sex;
select * from t_stu;

-- 增加一列放到前面
alter table t_stu add sex varchar(1) first ;
select * from t_stu;
alter table t_stu drop sex;
-- 中间加入
alter table t_stu drop ssex;
alter table t_stu add sex varchar(1);
alter table t_stu modify sex varchar(2);
alter table t_stu change sex ssex varchar(2);
select * from t_stu;
alter table t_stu drop ssex;
alter table t_stu add  sex varchar(1) after sname;
alter table t_stu add  sexx varchar(1) first ;
select * from t_stu;

update t_stu set sexx='1',
                 sname='zhangsan',
                 sex='男',
                 sage=18 where sno=1;

update t_stu set sexx=2;
update t_stu set sexx=1 where sno=1;
update t_stu set sex='女' where sno=2;



-- 删除表
drop table  t_stu;

