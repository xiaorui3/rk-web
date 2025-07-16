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
insert into emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7500,'ALLEN','SALESMAN',7698,'1981-02-20',1600,300,50);
insert into emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (7510,'ALLEN','SALESMAN',7698,'1981-02-20',1600,300,200);

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



-- select distinct sal from emp;




-- --- where语句

select * from emp where deptno = 20;
select * from emp where job in ('CLERK','ANALYST');

select * from emp where ename like '%A%';

select * from emp where comm IS not NULL;


-- 函数
select empno,ename,lower(ename),upper(ename),sal from emp;
select max(sal),min(sal),count(sal),sum(sal),avg(sal) from emp;

select ename,length(ename) from emp;


-- 字符串
select ename,length(ename) ,substring(ename,2,3) from emp;
-- 数值函数
select abs(-5),ceil(5.330),floor(5.9),round(3.14) from dual;
select abs(-5),ceil(5.330),floor(5.9),round(3.14);
-- 日期与时间函数
select curtime(),curdate(),now() from dual;


-- 流程
select empno,ename,sal,if(sal>=2500,'高薪','底薪') as '薪资登记' from emp;
select empno,ename,sal,comm,sal+ifnull(comm,0) ,job from emp;

-- case
select empno,ename,job ,
       case job
            when 'CLERK' then '店员'
            when 'ANALYST' then '分析员'
            when 'MANAGER' then '经理'
            when 'SALESMAN' then '业务员'
            else '其他职位'
end as '职位',
     sal from emp;

select ename,job,sal,
       case
            when sal<=1000 then '太低了'
            when sal >1000 and sal < 3000 then '还可以'
            when sal >=3000 then '高薪啊'
           else '无'

end as '薪资等级'
from emp;

-- 其他函数
select database(),user(),version() from dual;

-- 分组
select * from emp;
select deptno ,avg(sal) from emp group by deptno having avg(sal)>1000;
select deptno ,avg(sal) from emp where job<>'MANAGER' group by deptno having avg(sal)>1000;

-- 多表 内连接
-- 查询员工的编号 姓名 部门编号
select * from emp;
select empno, ename,deptno from emp;
-- 查询员工的编号 姓名 部门编号 部门名称
select * from dept;
select * from emp join dept;
-- 自然连接 自动匹配同名列
select * from emp natural join dept;

select emp.empno,emp.comm,emp.ename,emp.deptno,dept.deptno,dept.dname,dept.loc from emp natural join dept order by emp.deptno;

select * from emp join dept using(deptno);
select * from emp as e  join dept as d on(e.deptno=d.deptno);

-- 交叉连接 cross join
-- 自然连接 natural join
-- 内连接 using()
-- 内连接 on()
-- 综合来看 on()比较用的最多
select * from emp as e  join dept as d on(e.deptno=d.deptno) where sal>=3000;

select * from emp e left outer join dept d on (e.deptno=d.deptno);

select * from emp e left outer join dept d on (e.deptno=d.deptno)
union -- 并集
select * from emp e right outer join dept d on (e.deptno=d.deptno);


select deptno from emp where ename='CLARK';
select sal from emp where ename='CLARK';
select * from emp where deptno=(select deptno from emp where ename='CLARK');
select ename,sal from emp where deptno=(select deptno from emp where ename='CLARK') and sal<(select sal from emp where ename='CLARK');
