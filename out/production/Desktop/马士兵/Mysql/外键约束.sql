use student;
-- select * from stu;
create table t_class(
  cno int(4) auto_increment,
    constraint pk_cno  primary key (cno),
    cname varchar(10) not null,
    room char(4)
);

insert into t_class values (null,'java001','r803');
insert into t_class values (null,'java002','r133');
insert into t_class values (null,'大数据001','r130');

insert into t_class values (null,'java001','r503'),(null,'大数据001','r130'),(null,'大数据001','r130'),(null,'大数据001','r130'),(null,'大数据001','r130');
insert into t_class values (null,'java002','r130');

insert into t_class values (null,'java001','r503');
insert into t_class values (null,'java002','r130');
insert into t_class values (null,'大数据001','r130');
select * from t_class;

-- 子表 学生表
drop table t_student;
create table t_student(
    sno int(6) primary key auto_increment,
    sname varchar(15) not null ,
    classcno int(4),
    constraint ft_stu_classno foreign key (classcno) references t_class(cno)
);
alter table t_student add constraint ft_stu foreign key (classcno) references t_class(cno);

alter table t_student modify sname varchar(15) not null;


insert into t_student values (null,'zhangsan',5);
insert into t_student values (1002,'lisi',2);
insert into t_student values (null,'wangwu',5);

select * from t_student;
select * from t_class;
-- delete from t_class where cno=4;
insert into t_student values (null,'wangwu',3);

drop table t_class;
drop table t_student;

alter table t_student drop foreign key ft_stu_classno;
alter table t_student add constraint ft_stu foreign key (classcno) references t_class(cno) on DELETE cascade on UPDATE cascade ;

update t_class set cno=1 where cno=5;



