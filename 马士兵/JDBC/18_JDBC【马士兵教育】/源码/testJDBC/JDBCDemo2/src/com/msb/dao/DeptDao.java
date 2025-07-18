package com.msb.dao;

import com.msb.pojo.Dept;

import java.util.List;

/**
 * @Author: Ma HaiYang
 * @Description: MircoMessage:Mark_7001
 */
public interface DeptDao {
    /**
     * 查询全部门的方法
     * @return Dept对象封装的List集合
     */
    List<Dept> findAll();

    int addDept(Dept dept);
}
