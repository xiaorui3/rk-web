/*
 创建一个学生表
 包含学号，姓名，性别，年龄，入学日期，班级，email

 */

create database student;
use student;
create table t_student(
    sno int(10),
    sname varchar(20),
    sex varchar(1),
    sage int(3),
    ruxue date,
    class varchar(10),
    email varchar(30)
);
drop table t_student;
create table t_student(
    sno int(10) not null primary key auto_increment,
    sname varchar(20) not null ,
    sex varchar(1) default '男' check ( sex='男'||sex='女' ),
    sage int(3) check ( sage>=18 and sage<=50 ),
    ruxue date,
    class varchar(10),
    email varchar(30) unique

);

alter table t_student modify sno int(10) primary key auto_increment;

show create table t_student;

insert into t_student (sname,sex) values ('lisi','男');
select * from t_student;

create table t_student(
    sno int(10) auto_increment,
    sname varchar(20) not null ,
    sex varchar(1) default '男',
    sage int(3) ,
    ruxue date,
    class varchar(10),
    email varchar(30),
    constraint pk_stu primary key key(sno),
    constraint ck_stu_sex check ( sex='男'|| sex='女' ),
    constraint ck_stu_age check ( sage>=18 and sage<=50 ),
    constraint que_email unique (email)
);

desc t_student;