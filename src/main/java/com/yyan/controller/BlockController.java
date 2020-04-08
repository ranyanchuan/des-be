//package com.yyan.controller;
//
//import com.yyan.pojo.User;
//import com.yyan.utils.BaseController;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.Map;
//
//@Controller
//@RequestMapping("/block")
//public class BlockController extends BaseController {
//
//    /**
//     *
//     */
//    @RequestMapping("/add")
//    @ResponseBody
//    public Map<String, Object> addUser(@RequestBody User user) {
//        try {
//            this.userService.insertUser(user);
//            return this.buildSuccess();
//        } catch (Exception exp) {
//            return this.buildError(exp.getMessage());
//        }
//    }
//
//}
