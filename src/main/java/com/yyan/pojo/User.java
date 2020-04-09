package com.yyan.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String id;
    private String phone; // 用户手机号
    private String email; // 用户邮箱
    private String name; // 用户名
    private String password; //  登录密码
    private Date createTime;  // 创建时间
    private Date updateTime;  // 修改时间
}
