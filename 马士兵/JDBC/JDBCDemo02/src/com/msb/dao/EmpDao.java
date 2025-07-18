package com.msb.dao;

import com.msb.pojo.Emp;

import java.util.List;

public interface EmpDao {


    /**
     * 向数据库Emp表中增加一条数据方法
     * @param emp 要增加的数据封装成Emp类对象
     * @return 增加成功，返回更改多少行的值
     */
    int addEmp(Emp emp);

    /**
     * 向数据库Emp 根据员工编号删除对应员工信息的方法
     * @param empno 员工的编号
     * @return 删除成功的话，返回一个大于零的整数
     */
    int deleteByEmpno(int empno);

    /**
     * 查询所有员工信息
     * @return Emp类型的所有员工表
     */
    List<Emp> findAll();

}
