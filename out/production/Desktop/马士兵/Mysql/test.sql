create database stu;
use stu;
/*
   创建一个学生表
    包含学号，姓名，性别，年龄，入学日期，班级，email
  */
create table t_stu(
    sno int(20) primary key not null auto_increment,
    sname varchar(10) not null ,
    sex varchar(1) default '男' check ( sex = '男'||sex='女' ),
    sage int(3) check ( sage>=18||sage<=50 ),
    ruxuedate date,
    class varchar(10),
    email varchar(20) unique
);

insert t_stu values (1,'zhangsan1','男',19,now(),'java','3505469466@qq.com');
select * from t_stu;
update t_stu set sage='20' where sno=1;
select * from t_stu;
insert t_stu values (2,'zhangsan2','男',19,now(),'java','3505469436@qq.com');
select * from t_stu;
delete from t_stu where sno=2;
select * from t_stu;

alter table t_stu add xiaorui varchar(1);
alter table t_stu add xiaorui2 varchar(1) first ;
alter table t_stu add xiaorui3 varchar(1) after class;
select * from t_stu;
alter table t_stu drop xiaorui;
alter table t_stu drop xiaorui3;
alter table t_stu drop xiaorui2;
select * from t_stu;
