package com.yyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

// 注入 bean
@Controller
public class HelloWorldController {

    // 将 url 与方法绑定
    @RequestMapping("/hello")
    // json 数据转换
    @ResponseBody
    public Map<String, Object> showHelloWorld() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "HELLO WORLD");
        return map;
    }
}
