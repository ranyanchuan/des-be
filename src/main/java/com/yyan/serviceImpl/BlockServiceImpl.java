package com.yyan.serviceImpl;

import com.yyan.dao.BlockDao;
import com.yyan.pojo.Block;
import com.yyan.service.BlockService;
import com.yyan.utils.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class BlockServiceImpl extends BaseServiceImpl implements BlockService {

    public static int difficulty = 5; // 挖矿难度系数

    @Autowired
    private BlockDao blockDao;

    @Override
    public void insertUser(Block block) {


        String userId=getUserIdSession();//







        // todo 获取主链

        block.setUserId(userId);
        // todo
        block.setPreHash("xxxxx");
        block.setTimeStamp((new Date()).getTime());
        // todo
        block.setNonce(1);
        // todo
        block.setHeight(0);
        // todo
        block.setHash("000222");
        System.out.println("block"+block.toString());
        this.blockDao.insertBlock(block);

        // 添加区块

//        block.setUserId(userId);
//        block.setPreHash("xxxxx");
//        block.setTimeStamp((new Date()).getTime());
//        block.setTimeStamp((new Date()).getTime());













    }

    @Override
    public Map<String, Object> selectListBlock(Map map) {

        List<Block> newList = (List<Block>) this.blockDao.selectListBlock(map);
        Integer count = this.blockDao.countListBlock(map);
        return this.queryListSuccess(newList, count, map); //查询成功

    }
}
