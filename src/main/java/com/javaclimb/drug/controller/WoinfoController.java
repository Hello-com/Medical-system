package com.javaclimb.drug.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.drug.common.ResultMapUtil;
import com.javaclimb.drug.entity.Woinfo;
import com.javaclimb.drug.service.IWoinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * 药品出入库相关的Controller
 */
@Controller
@RequestMapping(value = "/woinfo")
public class WoinfoController {


    @Autowired
    private IWoinfoService woinfoService;
    /**
     * 转向药品出入库页面
     */
    @RequestMapping
    public String login(){
        return "/woinfo";
    }
    /**
     * 分页查询药品出入库列表
     */
    @RequestMapping(value = "/woinfoQueryPage")
    @ResponseBody
    public Object woinfoQueryPage(@RequestParam(value = "param",required = false) String param,
                                    @RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
                                    @RequestParam(value = "pageSize", defaultValue = "10")int pageSize){
            IPage<Woinfo> ipage = woinfoService.selectWoinfoPage(pageNum,pageSize,param);
            return ResultMapUtil.getHashMapMysqlPage(ipage);

    }

    /**
     * 转向新增页面
     */
    @RequestMapping(value = "/woinfoPage")
    public String woinfoPage(){
        return "/woinfoPage";
    }
    /**
     * 添加一个药品出入库
     */
    @RequestMapping(value = "/woinfoAdd")
    @ResponseBody
    public Object woinfoAdd(Woinfo woinfo){
        try {
            woinfo.setCreatetime(new Date());
            int i = woinfoService.addWoinfo(woinfo);
            return ResultMapUtil.getHashMapSave(i);
        }catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }

    }
    /**
     * 转向药品出入库编辑页面
     */
    @RequestMapping(value = "/woinfoQueryById")
    public String woinfoQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        Woinfo woinfo = woinfoService.queryWoinfo(id);
        model.addAttribute("obj",woinfo);
        return "/woinfoPage";
    }

    /**
     * 修改一个药品出入库
     */
    @RequestMapping(value = "/woinfoEdit")
    @ResponseBody
    public Object woinfoEdit(Woinfo woinfo){
        try {
            int i = woinfoService.editWoinfo(woinfo);
            return ResultMapUtil.getHashMapSave(i);
        }catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }

    }

    /**
     * 删除一个药品出入库
     */
    @RequestMapping(value = "/woinfoDelById")
    @ResponseBody
    public Object woinfoDelById(Integer id){
        try {
            int i = woinfoService.delWoinfo(id);
            return ResultMapUtil.getHashMapSave(i);
        }catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }

    }

}
