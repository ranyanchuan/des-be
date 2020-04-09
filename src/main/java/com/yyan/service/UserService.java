package com.yyan.service;

import com.yyan.pojo.User;

import java.util.Map;

public interface UserService {

    void insertUser(User user);

    void updateUser(User user);

    Map login(String email, String password);
}
