create database bumen;
use bumen;
create table DEPT(
    deptno int(2) not null ,
    dname varchar(14),
    loc varchar(13)
);
alter table DEPT add constraint pk_dept primary key (deptno);

create table emp(
    empno int(4) primary key ,
    ename varchar(10),
    job varchar(9),
    mgr int (4),
    hiredate date,
    sal double(7,2),
    comm double(7,2),
    deptno int(2)
);

alter table emp add constraint pk_emp foreign key (deptno) references DEPT(deptno);

create table salgrade(
    grade int primary key ,
    losal double(7,2),
    hisal double(7,2)
);

create table bonus(
    ename varchar(10),
    job varchar(9),
    sal double(7,2),
    comm double(7,2)
);

insert into dept(deptno, dname, loc) VALUES (10,'ACCOUNTING','NEW YORK');
insert into dept(deptno, dname, loc) VALUES (20,'RESEARCH','DALLAS');
insert into dept(deptno, dname, loc) VALUES (30,'SALES','CHICAGO');
insert into dept(deptno, dname, loc) VALUES (40,'OPERATIONS','BOSTON');
insert into dept(deptno, dname, loc) VALUES (50,'TESTING','BEIJING');
insert into dept(deptno, dname, loc) VALUES (60,'DEVELOPMENT','SHANGHAI');
insert into dept(deptno, dname, loc) VALUES (70,'MANUFACTURING','SHENZHEN');
insert into dept(deptno, dname, loc) VALUES (80,'HUMAN','HANGZHOU');

insert into emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7839,'KING','PRESIDENT',null,'1981-11-17',5000,null,10);
insert into emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7698,'BLAKE','MANAGER',7839,'1981-05-01',2850,null,30);
insert into emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7782,'CLARK','MANAGER',7839,'1981-06-09',2450,null,10);
insert into emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7566,'JONES','MANAGER',7839,'1981-04-02',2975,null,20);
insert into emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7788,'SCOTT','ANALYST',7566,'1987-04-19',3000,null,20);
insert into emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7902,'FORD','ANALYST',7566,'1981-12-03',3000,null,20);
insert into emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7369,'SMITH','CLERK',7902,'1980-12-17',800,null,20);
insert into emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7499,'ALLEN','SALESMAN',7698,'1981-02-20',1600,300,30);


insert into salgrade(grade, losal, hisal) VALUES (1,700,1200);
insert into salgrade(grade, losal, hisal) VALUES (2,1201,1400);
insert into salgrade(grade, losal, hisal) VALUES (3,1401,2000);
insert into salgrade(grade, losal, hisal) VALUES (4,2001,3000);
insert into salgrade(grade, losal, hisal) VALUES (5,3001,9999);

-- 部门表
select * from dept;

select  * from emp;
-- 员工
select * from salgrade;

select * from bonus;

select  * from emp where sal>2000;

select empno 员工编号, ename 员工姓名, job 职位, sal 薪资 from emp;

-- 去重
select distinct job from emp;
select distinct job,deptno from emp;

-- 排序  默认情况下按照升序排序 asc 升序 desc 降序
select * from emp order by sal desc ;
--
select * from emp order by sal ,deptno desc ;