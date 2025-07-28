package 布卡.基础.ZY.ZY7_28.service.ATM;

/**
 * @Author: 赵锐 github ---> xiaorui3
 * @CreateTime: 2025-07-28
 * @Description: ATM
 * @Version: 1.0
 */


import 布卡.基础.ZY.ZY7_28.mepper.Impl.ATMDataBase.ATMDataBase;
import 布卡.基础.ZY.ZY7_28.mepper.Impl.ATMDataBase.ATMDataBaseImpl;
import 布卡.基础.ZY.ZY7_28.mepper.Impl.ATMDataBase.ATM_TABLE;

import java.util.Scanner;

public class ATM {
    private ATMDataBase db = new ATMDataBaseImpl();
    private Scanner sc = new Scanner(System.in);
    private ATM_TABLE currentUser = null;

    public void start() {
        while (true) {
            if (currentUser == null) {
                System.out.println("1.注册 2.登录 3.退出");
                String choice = sc.next();
                switch (choice) {
                    case "1":
                        register();
                        break;
                    case "2":
                        login();
                        break;
                    case "3":
                        System.out.println("再见！");
                        return;
                    default:
                        System.out.println("输入错误");
                }
            } else {
                System.out.println("1.存款 2.取款 3.查询余额 4.退出登录");
                String choice = sc.next();
                switch (choice) {
                    case "1":
                        deposit();
                        break;
                    case "2":
                        withdraw();
                        break;
                    case "3":
                        System.out.println("当前余额：" + currentUser.getBalance());
                        break;
                    case "4":
                        currentUser = null;
                        System.out.println("已退出登录");
                        break;
                    default:
                        System.out.println("输入错误");
                }
            }
        }
    }

    private void register() {
        System.out.println("请输入账号：");
        String account = sc.next();
        System.out.println("请输入密码：");
        String password = sc.next();

        if (db.select(account) != null) {
            System.out.println("账号已存在");
            return;
        }

        ATM_TABLE user = new ATM_TABLE(account, password, 0);
        db.insert(user);
        System.out.println("注册成功");
    }

    private void login() {
        System.out.println("请输入账号：");
        String account = sc.next();
        System.out.println("请输入密码：");
        String password = sc.next();

        ATM_TABLE user = db.select(account);
        if (user != null && user.getPassword().equals(password)) {
            currentUser = user;
            System.out.println("登录成功");
        } else {
            System.out.println("账号或密码错误");
        }
    }

    private void deposit() {
        System.out.println("请输入存款金额：");
        double amount = sc.nextDouble();
        if (amount <= 0) {
            System.out.println("金额必须大于0");
            return;
        }
        currentUser.setBalance(currentUser.getBalance() + amount);
        db.update(currentUser);
        System.out.println("存款成功");
    }

    private void withdraw() {
        System.out.println("请输入取款金额：");
        double amount = sc.nextDouble();
        if (amount <= 0) {
            System.out.println("金额必须大于0");
            return;
        }
        if (amount > currentUser.getBalance()) {
            System.out.println("余额不足");
            return;
        }
        currentUser.setBalance(currentUser.getBalance() - amount);
        db.update(currentUser);
        System.out.println("取款成功");
    }

    public static void main(String[] args) {
        new ATM().start();
    }
}