package com.msb.Test01;

import com.msb.dao.EmpDao;
import com.msb.dao.impl.EmpDaoImpl;
import com.msb.pojo.Emp;

import java.util.Date;

public class test1 {
    public static void main(String[] args) {
        Emp emp=new Emp(7937,"JHON","MANAGER",7839,new Date(),3000,1000,30);
        EmpDao empDao =new EmpDaoImpl();
        int i = empDao.addEmp(emp);
        System.out.println(i);

        int i1 = empDao.deleteByEmpno(7935);
        System.out.println(i1);

    }
}
