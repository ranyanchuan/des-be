package com.yyan.controller;

import com.yyan.pojo.Block;
import com.yyan.pojo.User;
import com.yyan.serviceImpl.BlockServiceImpl;
import com.yyan.utils.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/block")
public class BlockController extends BaseController {

    @Autowired
    private BlockServiceImpl blockService;

    /**
     *
     */
    @RequestMapping("/add")
    @ResponseBody
    public Map<String, Object> addUser(@RequestBody Block block) {
        try {
            this.blockService.insertUser(block);
            return this.buildSuccess();
        } catch (Exception exp) {
            return this.buildError(exp.getMessage());
        }
    }

}
