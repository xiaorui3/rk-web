package com.example.rk.service;

import com.example.rk.pojo.SuperMailSendUser;

import java.util.List;

public interface SuperMailSendUserService {
    int selectMaxSize();
    int insertSuperMailSendUser(SuperMailSendUser superMailSendUser);
    List<SuperMailSendUser> getSuperMailSendUsers();
}
