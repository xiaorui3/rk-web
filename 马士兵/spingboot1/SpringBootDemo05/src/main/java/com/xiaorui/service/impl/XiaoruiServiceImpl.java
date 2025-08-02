package com.xiaorui.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaorui.mapper.xiaoRuiMapper;
import com.xiaorui.pojo.xiaorui;
import com.xiaorui.service.XiaoruiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Qualifier
public class XiaoruiServiceImpl implements XiaoruiService {
    @Autowired
    private xiaoRuiMapper xiaoRuiMapper;
    @Override
    public xiaorui selectOne(int id) {
        return xiaoRuiMapper.selectOneUser(id);
    }

    @Override
    public int save(xiaorui xiaorui) {
        return xiaoRuiMapper.saveUser(xiaorui);
    }

    @Override
    public int update(xiaorui xiaorui) {
        return xiaoRuiMapper.updateUser(xiaorui);
    }

    @Override
    public int delete(int id) {
        return xiaoRuiMapper.deleteUser(id);
    }

    @Override
    public PageInfo<xiaorui> selectAll(int pageNum, int pageSize) {
        System.out.println("查询数据库的Service层---01");
        PageHelper.startPage(pageNum, pageSize);
        System.out.println("查询数据库的Service层---02");
        List<xiaorui> users = xiaoRuiMapper.selectAllUser();
        PageInfo<xiaorui> p =new PageInfo<>(users);
        return p;
    }

    @Override
    public List<xiaorui> selectAllUserTable() {
        return xiaoRuiMapper.selectAllUserTable();
    }
}
