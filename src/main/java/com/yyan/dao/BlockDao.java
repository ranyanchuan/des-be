package com.yyan.dao;

import com.yyan.pojo.Block;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface BlockDao {

    //  添加区块
    void insertBlock(Block block);

    // 查询区块
    Map<String, Object> selectListBlock(Map map);
    Integer countListBlock(Map map); // 查询区块数量

}
