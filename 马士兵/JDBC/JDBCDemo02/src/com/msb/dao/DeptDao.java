package com.msb.dao;

import com.msb.pojo.Dept;

import java.util.List;

public interface DeptDao {


    /**
     * 查询所有部门表
     * @return 返回部门Dept类型的表
     */
    List<Dept> findAll();
}
