package com.yyan.pojo;

import com.yyan.utils.StringUtil;
import lombok.Data;

import java.util.Date;

@Data
public class Block {

    public String id; // 区块 id
    public String userId; // 创建人
    public String preHash; // 前节点hash
    private String fileUrl; //  加密文件路径
    private long timeStamp; //时间搓 1/1/1970.
    private int nonce; // 随机数
    public String hash; // 当前节点hash
    public Integer height; // 区块高度

    private Date createTime;  // 创建时间
    private Date updateTime;  // 修改时间


    /**
     * 初始化区块
     *
     * @param data
     * @param preHash
     */
    public Block(String data, String preHash) {
        this.fileUrl = data;
        this.preHash = preHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash(); // 当前节点hash
        System.out.println("this.hash"+this.hash);
    }


    /**
     * 计算hash值
     *
     * @return hash
     */
    public String calculateHash() {
        String calculatedhash = StringUtil.applySha256(
                preHash +
                        Long.toString(timeStamp) +
                        Integer.toString(nonce) +
                        fileUrl
        );
        return calculatedhash;
    }


    /**
     * 工作量证明
     */

    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0"
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Block Mined!!! : " + hash);
    }
}