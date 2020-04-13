package com.yyan.serviceImpl;

import com.yyan.dao.BlockDao;
import com.yyan.pojo.Block;
import com.yyan.service.BlockService;
import com.yyan.utils.BaseServiceImpl;
import com.yyan.utils.FileUtil;
import com.yyan.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class BlockServiceImpl extends BaseServiceImpl implements BlockService {

    public static int difficulty = 2; // 挖矿难度系数 5

    @Autowired
    private BlockDao blockDao;

    @Override
    public void insertBlock(Block block) {

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

//        block.setFileUrl(filePath); //  设置文件路径

        // 设置访问路径
        String filePath = new String("src/main/resources/static/images/" + block.getFileUrl());
        block.setTimeStamp((new Date()).getTime());

        String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0"
        Integer nonce = 0;
        String base64File = FileUtil.encryptToBase64(filePath);
        String hash = calHash(block, base64File);

        // 工作量证明 挖矿
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            block.setNonce(nonce);
            hash = calHash(block, base64File);
            System.out.println("hash=====" + hash);
        }
        block.setHash(hash);
        // 添加区块
        this.blockDao.insertBlock(block);

    }


    /**
     * 计算hash值
     *
     * @return hash
     */
    public String calHash(Block block, String base64File) {

        return StringUtil.applySha256(
                block.getPreHash() +
                        Long.toString(block.getTimeStamp()) +
                        Integer.toString(block.getNonce()) +
                        base64File

        );

    }


    @Override
    public Map<String, Object> selectListBlock(Map map) {

        List<Block> newList = this.blockDao.selectListBlock(checkPageSize(map));

        Integer count = this.blockDao.countListBlock(map);
        return this.queryListSuccess(newList, count, map); //查询成功

    }
}
