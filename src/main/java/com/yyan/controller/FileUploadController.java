package com.yyan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * springboot 文件上传
 */
// 该类下的方法的返回值会自动做 json 转换， 相当于  @ResponseBody + @Controller
@RestController
@RequestMapping("/api/file")

public class FileUploadController {

    public final static String IMG_PATH_PREFIX = "static/images";

    public static File getImgDirFile(String imgPath) {
        // 构建上传文件的存放 "文件夹" 路径s
        String fileDirPath = new String("src/main/resources/" + imgPath);
        File fileDir = new File(fileDirPath);
        if (!fileDir.exists()) {
            // 递归生成文件夹
            fileDir.mkdirs();
        }
        return fileDir;
    }


    /**
     * 批量文件上传
     */
    @RequestMapping("/upload")

    public Map<String, Object> fileUpload(HttpServletRequest request, MultipartFile fileName) {
        Map map = new HashMap();
        if (fileName.isEmpty()) {
            map.put("msg", "上传失败，请选择文件");
        }
        //获取文件名
        String fn = fileName.getOriginalFilename();
        String prefix = fn.substring(fn.lastIndexOf("."));//文件后缀
        //新文件名
        String s = UUID.randomUUID().toString();//避免重复以UUID为文件名
        String filenas = s + prefix;
        // 存放上传图片的文件夹
        File fileDir = getImgDirFile(IMG_PATH_PREFIX);
        // 输出文件夹绝对路径  -- 这里的绝对路径是相当于当前项目的路径而不是“容器”路径
        String absolutePath = fileDir.getAbsolutePath();
        File dest = new File(absolutePath + File.separator + filenas);
        try {
            fileName.transferTo(dest);
            //拼接地址
            String url = filenas;
            map.put("link", url);
            map.put("msg", "文件上传成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }


}
