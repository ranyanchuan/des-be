package com.yyan.service;

import com.yyan.pojo.User;

public interface UserService {

    void insertUser(User user);

    void updateUser(User user);

    User login(String phone, String password);
}
