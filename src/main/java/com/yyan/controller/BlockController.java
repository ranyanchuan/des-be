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
@RequestMapping("/admin/block")
public class BlockController extends BaseController {

    @Autowired
    private BlockServiceImpl blockService;

    /**
     *
     */
    @RequestMapping("/add")
    @ResponseBody
    public Map<String, Object> addBlock(@RequestBody Block block) {
        try {
            this.blockService.insertBlock(block);
            return this.buildSuccess();
        } catch (Exception exp) {
            return this.buildError(exp.getMessage());
        }
    }


    /**
     *
     */
    @RequestMapping("/get")
    @ResponseBody
    public Map<String, Object> getBlock(@RequestBody Map map) {
        try {
            return this.buildSuccess(this.blockService.selectListBlock(map));
        } catch (Exception exp) {
            return this.buildError(exp.getMessage());
        }
    }

}
