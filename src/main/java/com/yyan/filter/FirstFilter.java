package com.yyan.filter;

import com.alibaba.fastjson.JSON;
import com.yyan.utils.JwtUtil;
import com.yyan.utils.ResultCodeEnum;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@WebFilter(filterName = "FirstFilter", urlPatterns = "/*")
public class FirstFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("进入 filter " + request);


        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse rep = (HttpServletResponse) response;
//
//        //设置允许跨域的配置
//        // 这里填写你允许进行跨域的主机ip（正式上线时可以动态配置具体允许的域名和IP）
//        rep.setHeader("Access-Control-Allow-Origin", "*");
//        // 允许的访问方法
//        rep.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE, PATCH");
//        // Access-Control-Max-Age 用于 CORS 相关配置的缓存
//        rep.setHeader("Access-Control-Max-Age", "3600");
//        rep.setHeader("Access-Control-Allow-Headers", "token,Origin, X-Requested-With, Content-Type, Accept");
//
//
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");

        // todo 不就进行token校验白名单
        String[] urls = {
                "/hello",
                "/images/",
                "/api/user/login",
                "/api/file/upload",
                "/api/user/insert",
                "/api/block/select",
        };

        String currentUrl = req.getRequestURI().split("\\?")[0];

        for(String url:urls ){// 过滤非验证路由
            if(currentUrl.startsWith(url)){
            chain.doFilter(request, response);
            return;
            }
        }

        String token = req.getHeader("Authorization");// 获取 token

        Boolean status = JwtUtil.verify(token);

        if (null == token || token.isEmpty() || !status) {  // token 校验失败
            Map map = new HashMap();
            ResultCodeEnum resultCode = ResultCodeEnum.USER_ERROR;
            map.put("code", Integer.parseInt(resultCode.getCode()));
            map.put("info", resultCode.getMessage());
            PrintWriter writer = response.getWriter();
            writer.write(JSON.toJSONString(map));
            return;
        }

        chain.doFilter(request, response); // token 校验 success


    }


}
