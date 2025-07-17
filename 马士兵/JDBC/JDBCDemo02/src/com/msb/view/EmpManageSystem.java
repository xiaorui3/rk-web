package com.msb.view;

import com.msb.dao.DeptDao;
import com.msb.dao.EmpDao;
import com.msb.dao.impl.DeptDaoImpl;
import com.msb.dao.impl.EmpDaoImpl;
import com.msb.pojo.Dept;
import com.msb.pojo.Emp;

import java.util.List;
import java.util.Scanner;

public class EmpManageSystem {
    private static Scanner sc =new Scanner(System.in);
    public static void main(String[] args) {
        EmpManageSystem empManageSystem = new EmpManageSystem();
        while (true){
            empManageSystem.showMenu();
            int i = sc.nextInt();
            switch(i) {
                case 1:
                    EmpDao empDao =new EmpDaoImpl();
                    List<Emp> all = empDao.findAll();
                    for (int j = 0; j < all.size(); j++) {
                        System.out.println(all.get(j).toString());
                    }
                    break;
                case 2:
                    DeptDao deptDao =new DeptDaoImpl();
                    List<Dept> all1 = deptDao.findAll();
                    all1.forEach(System.out::println);
                    break;
                case 3:break;
                case 4:break;
                case 5:break;
                case 6:break;
                case 7:break;
                default:
                    System.out.println("输入错误！");

            }
        }

    }
    public void showMenu(){
        System.out.println("*****************************");
        System.out.println("* 1. 查询所有员工信息          *");
        System.out.println("* 2. 查询所有部门信息          *");
        System.out.println("* 3. 根据员工工号删除员工信息    *");
        System.out.println("* 4. 根据员工工号修改员工信息    *");
        System.out.println("* 5. 增加一个员工信息          *");
        System.out.println("* 6. 增加一个部门信息          *");
        System.out.println("* 7 . 退出                   *");
        System.out.println("*****************************");
    }
}
