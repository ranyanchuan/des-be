package com.yyan.controller;

import com.yyan.pojo.User;
import com.yyan.serviceImpl.UserServiceImpl;
import com.yyan.utils.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Map;
// 注入 bean
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {


    @Autowired
    private UserServiceImpl userService;

    /**
     * 添加用户
     */
    @RequestMapping("/add")
    @ResponseBody
    public Map<String, Object> addUser(@RequestBody User user) {
        try {
            this.userService.insertUser(user);
            return this.buildSuccess();
        } catch (Exception exp) {
            return this.buildError(exp.getMessage());
        }
    }


    /**
     * 用户登录
     */
    @RequestMapping("/login")
    @ResponseBody
    public Map<String, Object> selectUser(@RequestParam String email, @RequestParam String password) {
        try {

            Map map = this.userService.login(email, password);

            System.out.println("map"+map.toString());

            return this.buildSuccess(map);
        } catch (Exception exp) {
            return this.buildError(exp.getMessage());
        }
    }

    /**
     * 用户登出
     */
    @RequestMapping("/logout")
    @ResponseBody
    public Map<String, Object> logout() {
        try {

            // todo 清空session
            return this.buildSuccess();
        } catch (Exception exp) {
            return this.buildError(exp.getMessage());
        }
    }


    /**
     * 添加用户
     */
    @RequestMapping("/update")
    @ResponseBody
    public Map<String, Object> updateUser(@RequestBody User user) {
        try {

            // todo  密码加密
            this.userService.updateUser(user);
            return this.buildSuccess();
        } catch (Exception exp) {
            return this.buildError(exp.getMessage());
        }
    }

}
