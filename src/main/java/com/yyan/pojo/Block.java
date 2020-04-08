package com.yyan.pojo;

import com.yyan.utils.StringUtil;
import lombok.Data;

import java.util.Date;

@Data
public class Block {

    public String hash; // 当前节点hash
    public String previousHash; // 前节点hash
    private String data; // 数据
    private long timeStamp; //时间搓 1/1/1970.
    private int nonce;


    /**
     * 初始化区块
     * @param data
     * @param previousHash
     */
    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash(); // 当前节点hash
    }


    /**
     * 计算hash值
     * @return hash
     */
    public String calculateHash() {
        String calculatedhash = StringUtil.applySha256(
                previousHash +
                        Long.toString(timeStamp) +
                        Integer.toString(nonce) +
                        data
        );
        return calculatedhash;
    }


    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0"
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Block Mined!!! : " + hash);
    }
}