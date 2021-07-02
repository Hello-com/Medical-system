package com.javaclimb.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.drug.common.ResultMapUtil;
import com.javaclimb.drug.entity.Returnsupplier;
import com.javaclimb.drug.service.IReturnsupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping(value = "/returnsupplier")
public class ReturnsupplierController {

    @Autowired
    private IReturnsupplierService returnsupplierService;

    //转向页面
    @RequestMapping
    public String login(){
        return "/returnsupplier";
    }

    //分页查询
    @RequestMapping(value = "/reQueryPage")
    @ResponseBody
    public Object rsQueryPage(@RequestParam(value = "param",required = false) String param,
                              @RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
                              @RequestParam(value = "pageSize", defaultValue = "10")int pageSize){
        IPage<Returnsupplier> iPage = returnsupplierService.selectRsPage(pageNum,pageSize,param);
        return ResultMapUtil.getHashMapMysqlPage(iPage);
    }

    //页面转向
    @RequestMapping(value = "/rsPage")
    public String rsPage(){
        return "/rsPage";
    }
    @RequestMapping(value = "/rsAdd")
    public Object rsAdd(Returnsupplier returnsupplier){
        try {
            returnsupplier.setCreatetime(new Date());
            int i = returnsupplierService.addRs(returnsupplier);
            return ResultMapUtil.getHashMapSave(i);
        }catch(Exception e){
            return ResultMapUtil.getHashMapException(e);
        }

    }

    //
    @RequestMapping(value = "/rsQueryById")
    public String rsQueryById(@RequestParam(name = "id",required = true)Integer id, Model model) {
    Returnsupplier returnsupplier = returnsupplierService.queryRs(id);
    model.addAttribute("obj",returnsupplier);
    return "/rsQueryById";
    }

    //修改
    @RequestMapping(value = "/reEdit")
    public Object rsEdit(Returnsupplier returnsupplier){
        try {
            return ResultMapUtil.getHashMapSave(returnsupplierService.editRs(returnsupplier));
        }catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }

    }
    //删除
    @RequestMapping(value = "/delRs")
    @ResponseBody
    public Object delRs(Integer id){
        try {
            return ResultMapUtil.getHashMapSave(returnsupplierService.delRs(id));
        }catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }

    }

    //查询全部
    @RequestMapping(value = "/rsList")
    @ResponseBody
    public Object rsList(){
        return ResultMapUtil.getHashMapList(returnsupplierService.queryRsList());
    }
}
