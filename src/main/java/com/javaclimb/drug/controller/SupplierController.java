package com.javaclimb.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.drug.common.ResultMapUtil;
import com.javaclimb.drug.entity.Supplier;
import com.javaclimb.drug.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Date;
import java.util.List;

/**
 * 供应商相关的Controller
 */
@Controller
@RequestMapping(value = "/supplier")
public class SupplierController {


    @Autowired
    private ISupplierService supplierService;
    /**
     * 转向供应商页面
     */
    @RequestMapping
    public String login(){
        return "/supplier";
    }
    /**
     * 分页查询供应商列表
     */
    @RequestMapping(value = "/supplierQueryPage")
    @ResponseBody
    public Object supplierQueryPage(@RequestParam(value = "param",required = false) String param,
                                    @RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
                                    @RequestParam(value = "pageSize", defaultValue = "10")int pageSize){
            IPage<Supplier> ipage = supplierService.selectSupplierPage(pageNum,pageSize,param);
            return ResultMapUtil.getHashMapMysqlPage(ipage);

    }

    /**
     * 转向新增页面
     */
    @RequestMapping(value = "/supplierPage")
    public String supplierPage(){
        return "/supplierPage";
    }
    /**
     * 添加一个供应商
     */
    @RequestMapping(value = "/supplierAdd")
    @ResponseBody
    public Object supplierAdd(Supplier supplier){
        try {
            supplier.setCreatetime(new Date());
            int i = supplierService.addSupplier(supplier);
            return ResultMapUtil.getHashMapSave(i);
        }catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }

    }
    /**
     * 转向供应商编辑页面
     */
    @RequestMapping(value = "/supplierQueryById")
    public String supplierQueryById(@RequestParam(name = "id",required = true)Integer id, Model model){
        Supplier supplier = supplierService.querySupplier(id);
        model.addAttribute("obj",supplier);
        return "/supplierPage";
    }

    /**
     * 修改一个供应商
     */
    @RequestMapping(value = "/supplierEdit")
    @ResponseBody
    public Object supplierEdit(Supplier supplier){
        try {
            int i = supplierService.editSupplier(supplier);
            return ResultMapUtil.getHashMapSave(i);
        }catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }

    }

    /**
     * 删除一个供应商
     */
    @RequestMapping(value = "/supplierDelById")
    @ResponseBody
    public Object supplierDelById(Integer id){
        try {
            int i = supplierService.delSupplier(id);
            return ResultMapUtil.getHashMapSave(i);
        }catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }

    }

    //获取所以供应商
    @RequestMapping(value = "/supplieList")
    @ResponseBody
    public Object supplierList(){
        List<Supplier> supplierList = supplierService.querySupplierList();
        return ResultMapUtil.getHashMapList(supplierList);
    }
}
