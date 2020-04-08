package com.yyan.service;

import com.yyan.pojo.Block;

import java.util.Map;

public interface BlockService {


    // 添加区块
    void insertUser(Block block);

    // 查询区块
    Map<String, Object> selectListBlock(Map map); // 查询区块


}
