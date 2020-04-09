package com.yyan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

// springboot 启动类
@SpringBootApplication
@ServletComponentScan // 在springboot 启动是会扫描@WebServlet,并将该类示例
public class App {

    public static void main(String[] args) {
        // 执行启动器run 方法
        // 从当前包下进行扫描组件
        SpringApplication.run(App.class, args);

    }


}
