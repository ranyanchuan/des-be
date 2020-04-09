package com.yyan.service;

import com.yyan.pojo.Block;

import java.io.FileNotFoundException;
import java.util.Map;

public interface BlockService {


    // 添加区块
    void insertUser(Block block) throws FileNotFoundException;

    // 查询区块
    Map<String, Object> selectListBlock(Map map); // 查询区块


}
