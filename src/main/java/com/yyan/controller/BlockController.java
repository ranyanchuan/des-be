package com.yyan.controller;

import com.yyan.pojo.Block;
import com.yyan.serviceImpl.BlockServiceImpl;
import com.yyan.utils.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/api/block")
public class BlockController extends BaseController {

    @Autowired
    private BlockServiceImpl blockService;

    /**
     *添加区块
     */
    @RequestMapping("/insert")
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
     * 根据条件查询区块
     */
    @RequestMapping("/select")
    @ResponseBody
    public Map<String, Object> getBlock(@RequestBody Map map) {
        try {
            return this.buildSuccess(this.blockService.selectListBlock(map));
        } catch (Exception exp) {
            return this.buildError(exp.getMessage());
        }
    }


    /**
     * 根据条件查询自己的区块
     */
    @RequestMapping("/self/select")
    @ResponseBody
    public Map<String, Object> getBlockSelf(@RequestBody Map map) {
        try {
            return this.buildSuccess(this.blockService.selectListBlockSelf(map));
        } catch (Exception exp) {
            System.out.println(exp);

            return this.buildError(exp.getMessage());
        }
    }


}
