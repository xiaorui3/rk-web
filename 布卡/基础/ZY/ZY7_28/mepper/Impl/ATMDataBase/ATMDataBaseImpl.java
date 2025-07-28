package 布卡.基础.ZY.ZY7_28.mepper.Impl.ATMDataBase;

/**
 * @Author: 赵锐 github ---> xiaorui3
 * @CreateTime: 2025-07-28
 * @Description: ATMDataBaseImpl.java
 * @Version: 1.0
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ATMDataBaseImpl implements ATMDataBase {
    private static final String FILE_PATH = "布卡\\基础\\ZY\\ZY7_28\\mepper\\Impl\\ATMDataBase\\users.dat";

    @Override
    public void insert(ATM_TABLE user) {
        List<ATM_TABLE> users = loadUsers();
        users.add(user);
        saveUsers(users);
    }

    @Override
    public ATM_TABLE select(String account) {
        List<ATM_TABLE> users = loadUsers();
        for (ATM_TABLE user : users) {
            if (user.getAccount().equals(account)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void update(ATM_TABLE user) {
        List<ATM_TABLE> users = loadUsers();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getAccount().equals(user.getAccount())) {
                users.set(i, user);
                break;
            }
        }
        saveUsers(users);
    }

    @Override
    public void delete(String account) {
        List<ATM_TABLE> users = loadUsers();
        users.removeIf(user -> user.getAccount().equals(account));
        saveUsers(users);
    }

    @SuppressWarnings("unchecked")
    private List<ATM_TABLE> loadUsers() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<ATM_TABLE>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    private void saveUsers(List<ATM_TABLE> users) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}