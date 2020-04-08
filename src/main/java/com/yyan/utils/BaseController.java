package com.yyan.utils;


import java.util.HashMap;
import java.util.Map;

public class BaseController {


    // 成功
    public Map<String, Object> buildSuccess(Object data) {
        Map<String, Object> map = new HashMap();
        ResultCodeEnum resultCode = ResultCodeEnum.SUCCESS;
        map.put("code", Integer.parseInt(resultCode.getCode()));
        map.put("info", resultCode.getMessage());
        map.put("data", data);
        return map;
    }

    // 成功
    public Map<String, Object> buildSuccess() {
        return this.buildSuccess(null);
    }

    // 失败
    public Map<String, Object> buildError(String message) {
        Map map = new HashMap();
        ResultCodeEnum resultCode = ResultCodeEnum.FAILED;
        map.put("code", Integer.parseInt(resultCode.getCode()));
        if (message == null || message.isEmpty()) {
            map.put("info", resultCode.getMessage());
        } else {
            map.put("info", message);
        }
        return map;
    }

}
