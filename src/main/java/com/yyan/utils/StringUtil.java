package com.yyan.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.security.MessageDigest;

public class StringUtil {

    /**
     * 创建数字签名
     * <p>
     * Java方式可以实现的加密方式有很多，例如BASE、MD、RSA、SHA等等，
     * 我在这里选用了SHA256这种加密方式，SHA（Secure Hash Algorithm）
     * 安全散列算法，这种算法的特点是数据的少量更改会在Hash值中产生不可预知的大量更改，
     * hash值用作表示大量数据的固定大小的唯一值，而SHA256算法的hash值大小为256位。
     * 之所以选用SHA256是因为它的大小正合适，一方面产生重复hash值的可能性很小，
     * 另一方面在区块链实际应用过程中，有可能会产生大量的区块，而使得信息量很大
     * ，那么256位的大小就比较恰当了
     *
     * @param input
     * @return
     */

    public static String applySha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            //将sha256应用于我们的输入
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer(); // 它将包含hash作为hexidecima

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



//    public static void main(String[] args) {
//        try {
//            //此处我测试的是我本机jdk源码文件的MD5值
//            String filePath = "C:\\Program Files\\Java\\jdk1.7.0_45\\src.zip";
//            FileInputStream fis = new FileInputStream(filePath);
//            String md5Hashcode = fileHashCode(fis);
//
//            System.out.println(md5Hashcode + "：文件的md5值");
//
//            //System.out.println(-100 & 0xff);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//




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


}
