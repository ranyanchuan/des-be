package com.yyan.serviceImpl;

import com.yyan.dao.BlockDao;
import com.yyan.pojo.Block;
import com.yyan.service.BlockService;
import com.yyan.utils.BaseServiceImpl;
import com.yyan.utils.StringUtil;
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

        // 获取主链
        Block endBlock = blockDao.selectEndBlock();
        // 用户 id
        String userId = getUserIdToken();
        block.setUserId(userId);

        if (endBlock == null) { // 创世区块
            block.setHeight(0);
            block.setPreHash("0");
        } else {
            block.setHeight(endBlock.getHeight() + 1);
            block.setPreHash(endBlock.getHash());
        }

        block.setTimeStamp((new Date()).getTime());

        String hash=calHash(block);
        String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0"

        Integer nonce=0;
        // 工作量证明 挖矿
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            block.setNonce(nonce);
            hash =calHash(block);
        }
        block.setHash(hash);

        System.out.println("block" + block.toString());
        // 添加区块
        this.blockDao.insertBlock(block);

    }


    /**
     * 计算hash值
     *
     * @return hash
     */
    public String calHash(Block block) {

        return StringUtil.applySha256(
                block.getPreHash() +
                        Long.toString(block.getTimeStamp()) +
                        Integer.toString(block.getNonce()) +
                        block.getFileUrl()
        );

    }




    @Override
    public Map<String, Object> selectListBlock(Map map) {

        List<Block> newList = (List<Block>) this.blockDao.selectListBlock(map);
        Integer count = this.blockDao.countListBlock(map);
        return this.queryListSuccess(newList, count, map); //查询成功

    }
}
