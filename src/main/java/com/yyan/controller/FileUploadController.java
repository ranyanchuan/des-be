package com.yyan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * springboot 文件上传
 */
// 该类下的方法的返回值会自动做 json 转换， 相当于  @ResponseBody + @Controller
@RestController
public class FileUploadController {

    /**
     * 批量文件上传
     */
    @RequestMapping("/fileUpload")
    // fileName 要与前端 input 的 name 保持一致
    public Map<String, Object> fileUpload(MultipartFile fileName) throws Exception {
        System.out.println("文件上传开始");
        // 打印文件名字
        System.out.println(fileName.getOriginalFilename());
        // 将文件保存到知道位置
        fileName.transferTo(new File("/Users/person/spring-boot-pro/src/main/resources/static/images/" + fileName.getOriginalFilename()));
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "文件上传成功");
        return map;

    }


}
