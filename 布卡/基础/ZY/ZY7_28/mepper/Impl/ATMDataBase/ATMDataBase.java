package 布卡.基础.ZY.ZY7_28.mepper.Impl.ATMDataBase;

/**
 * @Author: 赵锐 github ---> xiaorui3
 * @CreateTime: 2025-07-28
 * @Description: ATMDataBase.java
 * @Version: 1.0
 */


public interface ATMDataBase {
    void insert(ATM_TABLE user);
    ATM_TABLE select(String account);
    void update(ATM_TABLE user);
    void delete(String account);
}