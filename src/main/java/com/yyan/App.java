package com.yyan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// springboot 启动类
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        // 执行启动器run 方法
        // 从当前包下进行扫描组件
        SpringApplication.run(App.class, args);

    }


}
