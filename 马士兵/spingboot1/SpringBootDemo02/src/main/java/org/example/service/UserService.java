package org.example.service;

import org.example.pojo.User;

import java.util.List;

public interface UserService {
    public List<User> selectAllUser();
    public User selectUserByName(int id);
}
