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
                case 3:
                    System.out.print("请输入员工的工号: ");
                    EmpDao empDao1 =new EmpDaoImpl();
                    int i1 = empDao1.deleteByEmpno(sc.nextInt());
                    System.out.println(i1>1?"删除成功！":"删除失败！");
                    break;
                case 4:
                    System.out.println("请输入部门的编号");
                    DeptDao deptDao1 =new DeptDaoImpl();
                    boolean b = deptDao1.deleteByDeptno(sc.nextInt());
                    System.out.println(b?"删除成功！":"删除失败！");
                    break;
                case 5:

                    break;
                case 6:
                    System.out.println("请输入一个部门的信息: ");
                    Dept dept =new Dept();
                    System.out.print("请输入部门的编号: ");
                    dept.setDeptno(sc.nextInt());
                    System.out.print("请输入部门的名称: ");
                    dept.setLoc(sc.next());
                    System.out.println("请输入部门的位置: ");
                    dept.setDname(sc.next());
                    DeptDao deptDao2 =new DeptDaoImpl();
                    boolean b1 = deptDao2.addByDeptno(dept);
                    System.out.println(b1?"添加成功！":"添加失败！");
                    break;
                case 7:
                    System.exit(0);
                    break;
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
