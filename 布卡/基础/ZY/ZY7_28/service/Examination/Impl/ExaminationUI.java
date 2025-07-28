package 布卡.基础.ZY.ZY7_28.service.Examination.Impl;

import 布卡.基础.ZY.ZY7_28.service.Examination.ExaminationUI_In;

import java.util.Scanner;

/**
 * @Author: 赵锐 github ---> xiaorui3
 * @CreateTime: 2025-07-28
 * @Description: 考试系统用户UI
 * @Version: 1.0
 */


public class ExaminationUI implements ExaminationUI_In {
    public void start() {
        System.out.println("============   欢迎进入学生考试系统    ============");
        System.out.println("============  请学员或教师进系统登录   ============");
        System.out.println("============  1.学生登录  2.教师登录   ============");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                ExaminationUI_In studentUI = new StudentUI();
                studentUI.start();
                break;
            case 2:
                ExaminationUI_In teacherUI = new TeacherUI();
                teacherUI.start();
                break;
            default:
                System.out.println("输入错误，请重新输入!");
                start();
                break;
        }
    }
}
