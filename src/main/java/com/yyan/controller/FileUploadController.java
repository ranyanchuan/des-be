package com.yyan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
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


    public final static String UPLOAD_PATH_PREFIX = "";

    /**
     * 批量文件上传
     */
    @RequestMapping("/upload")
    // fileName 要与前端 input 的 name 保持一致
    public Map<String, Object> fileUpload(MultipartFile fileName, HttpServletRequest request) throws Exception {


        System.out.println("文件上传开始");


        String oldName = fileName.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."), oldName.length());
//        String realPath = new String("src/main/resources/static/images/" +newName);
        String realPath = new String("/Users/person/des-be/src/main/resources/static/images/" + newName);
        System.out.println(realPath);
        fileName.transferTo(new File(realPath));

        Map<String, Object> map = new HashMap<>();

        map.put("msg", "文件上传成功");
//        map.put("url", newName);
//        map.put("link", "http://img0.bdstatic.com/static/searchresult/img/logo-2X_32a8193.png");
//        map.put("link", realPath);
        map.put("link", newName);
        return map;
//        if(fileName.isEmpty()){
//            //返回选择文件提示
//            return null;
//        }
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
//        //构建文件上传所要保存的"文件夹路径"--这里是相对路径，保存到项目根路径的文件夹下
//        String realPath = new String("src/main/resources/" + UPLOAD_PATH_PREFIX);
//        String format = sdf.format(new Date());
//        //存放上传文件的文件夹
//        File file = new File(realPath + format);
//        System.out.println("-----------输出文件夹绝对路径 -- 这里的绝对路径是相当于当前项目的路径而不是“容器”路径【"+ file.getAbsolutePath() +"】-----------");
//        if(!file.isDirectory()){
//            //递归生成文件夹
//            file.mkdirs();
//        }
//        //获取原始的名字  original:最初的，起始的  方法是得到原来的文件名在客户机的文件系统名称
//        String oldName = fileName.getOriginalFilename();
//        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."),oldName.length());
//        try {
//            //构建真实的文件路径
//            File newFile = new File(file.getAbsolutePath() + File.separator + newName);
//            //转存文件到指定路径，如果文件名重复的话，将会覆盖掉之前的文件,这里是把文件上传到 “绝对路径”
//            fileName.transferTo(newFile);
//            String filePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/uploadFile/" + format + newName;
//            System.out.println("-----------【"+ filePath +"】-----------");
//            return null;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    }


}
