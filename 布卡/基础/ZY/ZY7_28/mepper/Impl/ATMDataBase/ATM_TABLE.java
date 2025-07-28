package 布卡.基础.ZY.ZY7_28.mepper.Impl.ATMDataBase;

/**
 * @Author: 赵锐 github ---> xiaorui3
 * @CreateTime: 2025-07-28
 * @Description: ATM_TABLE.java
 * @Version: 1.0
 */


import java.io.Serializable;

public class ATM_TABLE implements Serializable {
    private String account;
    private String password;
    private double balance;

    public ATM_TABLE(String account, String password, double balance) {
        this.account = account;
        this.password = password;
        this.balance = balance;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}