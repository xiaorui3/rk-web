package com.example.rk.controller;


import com.example.rk.mapper.SuperMailSendUserMapper;
import com.example.rk.pojo.SuperMailSendUser;
import com.example.rk.service.SuperMailSendUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;

@Controller
public class SuperMailSendUserController {
    @Autowired
    private SuperMailSendUserService superMailSendUserService;
    public HashMap<String,String> getListTFMap(){
        HashMap<String,String> map=new HashMap<String,String>();
        List<SuperMailSendUser> list =superMailSendUserService.getSuperMailSendUsers();
        for(SuperMailSendUser superMailSendUser:list){
            map.put(superMailSendUser.getEmail(),superMailSendUser.getName());
        }
        return map;
    }



}
