package 布卡.基础.ZY.ZY7_28.service.Examination.Impl;

import 布卡.基础.ZY.ZY7_28.mepper.DataBase;
import 布卡.基础.ZY.ZY7_28.mepper.Impl.EXDataBase.EX_TABLE;
import 布卡.基础.ZY.ZY7_28.mepper.Impl.EXDataBase.ExaminationData;
import 布卡.基础.ZY.ZY7_28.service.Examination.Exadmination_Super;
import 布卡.基础.ZY.ZY7_28.service.Examination.ExaminationUI_In;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class StudentUI extends Exadmination_Super implements ExaminationUI_In  {
    private final String  UID="STU-K7F2P9";
    @Override
    public void start() {
        super.clear();
        DataBase db=new ExaminationData();
        Scanner sc = new Scanner(System.in);
        System.out.println("============   欢迎进入学生考试系统    ============");
        System.out.println("============     注册还是登录        ============");
        System.out.println("============     1.注册  2.登录     ============");
        String next = sc.next();
        switch (next) {
            case "1":
                System.out.println("请输入注册令牌（请找教师获取）：");
                String token = sc.next();
                if (!token.matches("^STU-[A-Z0-9]{6}$")) {
                    System.out.println("无效的注册令牌，请联系教师获取！");
                    this.start();
                    return;
                }
                System.out.println("请输入用户名（2-10位字符）：");
                String name = sc.next();
                if (name.length() < 2 || name.length() > 10) {
                    System.out.println("用户名格式错误！请使用2-10位字符");
                    this.start();
                    return;
                }
                System.out.println("请输入密码（6-16位，包含数字和字母）：");
                String password = sc.next();
                boolean hasLetter = false;
                boolean hasDigit = false;
                for (char c : password.toCharArray()) {
                    if (Character.isLetter(c)) hasLetter = true;
                    if (Character.isDigit(c)) hasDigit = true;
                }
                if (password.length() < 6 || password.length() > 16 || !hasLetter || !hasDigit) {
                    System.out.println("密码格式错误！请使用6-16位且包含数字和字母");
                    this.start();
                    return;
                }
                System.out.println("请输入学号（6-10位数字）：");
                String stuId = sc.next();
                if (!stuId.matches("^\\d{6,10}$")) {
                    System.out.println("学号格式错误！请使用6-10位数字");
                    this.start();
                    return;
                }
                boolean exists = false;
                for (EX_TABLE item : EX_TABLE.getTable()) {
                    if (stuId.equals(item.getStuId())) {
                        exists = true;
                        break;
                    }
                }
                if (exists) {
                    System.out.println("该学号已注册，请直接登录！");
                    this.start();
                    return;
                }
                EX_TABLE student = new EX_TABLE();
                student.setName(name);
                student.setPassword(password);
                student.setStuId(stuId);
                EX_TABLE.getTable().add(student);
                try {
                    File studentFile = new File("布卡\\基础\\ZY\\ZY7_28\\mepper\\Impl\\EXDataBase\\students.xiaorui");
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(studentFile, true))) {
                        bw.write(stuId + "-" + password + "-" + name);
                        bw.newLine();
                        bw.flush();
                    }
                    System.out.println("注册成功！信息已保存！");
                } catch (IOException e) {
                    System.out.println("注册成功，但信息保存失败：" + e.getMessage());
                }

                System.out.println("即将跳转到登录界面...");
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.start();
                break;
            case "2":
                System.out.println("============     学生登录        ============");
                System.out.println("请输入学号：");
                String loginStuId = sc.next();
                System.out.println("请输入密码：");
                String loginPwd = sc.next();
                boolean loginSuccess = false;
                for (EX_TABLE item : EX_TABLE.getTable()) {
                    if (loginStuId.equals(item.getStuId()) && loginPwd.equals(item.getPassword())) {
                        loginSuccess = true;
                        break;
                    }
                }
                /**
                 * 考试逻辑
                 */

                //第一题 格式：（1 . xxx ）
                //               A.xxx
                //               B.xxx
                //               C.xxx
                //               D.xxx
                //学生选择完所有题后

                //计算所有题的分数
                //并给出准确率
                if (loginSuccess) {
                    System.out.println("登录成功！");
                    System.out.println("现在开始考试：");
                    ArrayList<EX_TABLE> questions = new ArrayList<>();
                    for (EX_TABLE item : EX_TABLE.getTable()) {
                        if (item.getTopic() != null && item.getOptions() != null && item.getAnswer() != null) {
                            questions.add(item);
                        }
                    }
                    if (questions.isEmpty()) {
                        System.out.println("当前没有可用试题，请联系教师添加！");
                        this.start();
                        return;
                    }
                    int total = questions.size();
                    int score = 0;
                    int correct = 0;
                    for (int i = 0; i < questions.size(); i++) {
                        EX_TABLE q = questions.get(i);
                        System.out.println("\n" + (i + 1) + ". " + q.getTopic());
                        String[] opts = q.getOptions();
                        if (opts != null && opts.length >= 4) {
                            System.out.println("A. " + opts[0]);
                            System.out.println("B. " + opts[1]);
                            System.out.println("C. " + opts[2]);
                            System.out.println("D. " + opts[3]);
                        }
                        System.out.print("请输入你的答案(A/B/C/D)：");
                        String userAns = sc.next().toUpperCase();
                        while (!userAns.matches("[ABCD]")) {
                            System.out.print("输入错误，请重新输入(A/B/C/D)：");
                            userAns = sc.next().toUpperCase();
                        }
                        if (userAns.equals(q.getAnswer())) {
                            correct++;
                            score++;
                            System.out.println("回答正确！");
                        } else {
                            System.out.println("回答错误，正确答案是：" + q.getAnswer());
                        }
                    }
                    double accuracy = (double) correct / total * 100;
                    System.out.println("\n============ 考试结束 ============");
                    System.out.println("总题数：" + total);
                    System.out.println("正确题数：" + correct);
                    System.out.println("得分：" + score + "分");
                    System.out.println("准确率：" + String.format("%.2f", accuracy) + "%");
                    System.out.println("==================================");
                    System.out.println("输入任意键返回主菜单...");
                    sc.next();
                    this.start();
                } else {
                    System.out.println("学号或密码错误！");
                    this.start();
                }
                break;
            default:
                System.out.println("输入错误，请重新输入!");
                this.start();
                break;
        }
    }
}