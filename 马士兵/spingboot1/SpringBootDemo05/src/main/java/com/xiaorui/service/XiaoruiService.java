package com.xiaorui.service;

import com.github.pagehelper.PageInfo;
import com.xiaorui.pojo.xiaorui;

import java.util.List;

public interface XiaoruiService {
    xiaorui selectOne(int id);
    int save(xiaorui xiaorui);
    int update(xiaorui xiaorui);
    int delete(int id);
    PageInfo<xiaorui> selectAll(int  pageNum, int pageSize);

    List<xiaorui> selectAllUserTable();
}
