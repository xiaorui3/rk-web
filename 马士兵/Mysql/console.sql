create database student;



use student;

create table t_student(
    sno int(6) not null primary key ,
    sname varchar(10),
    sex char(1),
    age int(3),
    enterdate date,
    classname varchar(10),
    email varchar(15)
    );

desc t_student;

select * from t_student;

show create table t_student;

show create database student;

