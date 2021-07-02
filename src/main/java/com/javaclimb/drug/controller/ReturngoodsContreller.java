package com.javaclimb.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.drug.common.ResultMapUtil;
import com.javaclimb.drug.entity.Returngoods;
import com.javaclimb.drug.entity.Supplier;
import com.javaclimb.drug.service.IReturngoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/returngoods")
public class ReturngoodsContreller {

    @Autowired
    private IReturngoodsService returngoodsService;

    @RequestMapping
    public String login(){
        return "/returngoods";
    }

    @RequestMapping(value = "/returnQueryPage")
    @ResponseBody
    public Object returnQueryPage(@RequestParam(value = "param",required = false) String param,
                                   @RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
                                   @RequestParam(value = "pageSize", defaultValue = "10")int pageSize) {
        IPage<Returngoods> ipage = returngoodsService.selectReturnPage(pageNum, pageSize, param);
        return ResultMapUtil.getHashMapMysqlPage(ipage);
    }

    //转向新页面
    @RequestMapping(value = "/returngoodsPage")
    public String returngoodsPage(){
        return "/returngoodsPage";
    }

    /**
     * 添加一个药品问题
     */
    @RequestMapping(value = "/returngoodsAdd")
    @ResponseBody
    public Object returngoodsAdd(Returngoods returngoods){
        try {
            returngoods.setReturntime(new Date());
            int i = returngoodsService.addReturn(returngoods);
            return ResultMapUtil.getHashMapSave(i);
        }catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }

    }
    /**
     * 转向药品问题编辑页面
     */
    @RequestMapping(value = "/returngoodsQueryById")
    public String returngoodsQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        Returngoods returngoods = returngoodsService.queryReturn(id);
        model.addAttribute("obj",returngoods);
        return "/returngoodsPage";
    }

    /**
     * 修改一个药品问题
     */
    @RequestMapping(value = "/returngoodsEdit")
    @ResponseBody
    public Object returngoodsEdit(Returngoods returngoods) {
        try {
            int i = returngoodsService.editReturn(returngoods);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }
    /**
     * 删除一个药品问题
     */
    @RequestMapping(value = "/returngoodsDelById")
    @ResponseBody
    public Object returngoodsDelById(Integer id){
        try {
            return ResultMapUtil.getHashMapSave(returngoodsService.delReturn(id));
        }catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }

    }

    //获取所以供应商
    @RequestMapping(value = "/returngoodsList")
    @ResponseBody
    public Object returngoodsList(){
        List<Returngoods> returnList = returngoodsService.queryReturnList();
        return ResultMapUtil.getHashMapList(returnList);
    }

}
