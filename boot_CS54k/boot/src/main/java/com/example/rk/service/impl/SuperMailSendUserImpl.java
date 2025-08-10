package com.example.rk.service.impl;

import com.example.rk.mapper.SuperMailSendUserMapper;
import com.example.rk.pojo.SuperMailSendUser;
import com.example.rk.service.SuperMailSendUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class SuperMailSendUserImpl implements SuperMailSendUserService {
    @Autowired
    private SuperMailSendUserMapper superMailSendUserMapper;
    @Override
    public int selectMaxSize() {
        return superMailSendUserMapper.maxSize();
    }

    @Override
    @Transactional
    public int insertSuperMailSendUser(SuperMailSendUser superMailSendUser) {
        return superMailSendUserMapper.insert(superMailSendUser);
    }

    @Override
    public List<SuperMailSendUser> getSuperMailSendUsers() {
        return superMailSendUserMapper.getSuperMailSendUsers();
    }
}
