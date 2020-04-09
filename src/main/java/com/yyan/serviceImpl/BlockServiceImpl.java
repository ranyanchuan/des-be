package com.yyan.serviceImpl;

import com.yyan.dao.BlockDao;
import com.yyan.pojo.Block;
import com.yyan.service.BlockService;
import com.yyan.utils.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class BlockServiceImpl extends BaseServiceImpl implements BlockService {

    public static int difficulty = 5; // 挖矿难度系数

    @Autowired
    private BlockDao blockDao;

    @Override
    public void insertUser(Block block) {
        // todo 获取主链
        // 添加区块
        String userId=getUserIdSession();//

        this.blockDao.insertBlock(block);
    }

    @Override
    public Map<String, Object> selectListBlock(Map map) {

        List<Block> newList = (List<Block>) this.blockDao.selectListBlock(map);
        Integer count = this.blockDao.countListBlock(map);
        return this.queryListSuccess(newList, count, map); //查询成功

    }
}
