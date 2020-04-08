package com.yyan.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.Base64;

public class FileUtil {

    public static void main(String[] args) {
        try {
            //此处我测试的是我本机jdk源码文件的MD5值
            String filePath = "C:\\Program Files\\Java\\jdk1.7.0_45\\src.zip";
            FileInputStream fis = new FileInputStream(filePath);
            String md5Hashcode = fileHashCode(fis);

            System.out.println(md5Hashcode + "：文件的md5值");

            //System.out.println(-100 & 0xff);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * java获取文件的SHA-256值
     *
     * @param fis 输入流
     * @return
     */
    public static String fileHashCode(FileInputStream fis) {
        try {
            //SHA-256,如果想使用SHA-1或MD5，则传入SHA-1,MD5
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            //分多次将一个文件读入，对于大型文件而言，比较推荐这种方式，占用内存比较少。
            byte[] buffer = new byte[1024];
            int length = -1;
            while ((length = fis.read(buffer, 0, 1024)) != -1) {
                md.update(buffer, 0, length);
            }
            fis.close();
            //转换并返回包含16个元素字节数组,返回数值范围为-128到127
            byte[] bytes = md.digest();
            BigInteger bigInt = new BigInteger(1, bytes);//1代表绝对值
            return bigInt.toString(16);//转换为16进制
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


    public String encryptToBase64(String filePath) {
        if (filePath == null) {
            return null;
        }
        try {
            byte[] b = Files.readAllBytes(Paths.get(filePath));
            return Base64.getEncoder().encodeToString(b);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


}
