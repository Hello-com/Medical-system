package com.javaclimb.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.javaclimb.drug.entity.Supplier;
import com.javaclimb.drug.entity.User;

import java.util.List;

/**
 * 供应商的Service接口
 */
public interface ISupplierService extends IService<Supplier> {

    /**
     * 分页查询供应商数据
     * @param pagNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数 - 供应商名称
     * @return
     */
    public IPage<Supplier>  selectSupplierPage(int pagNum, int pageSize, String param);

    /**
     * 新增一条供应商信息
     * @param supplier
     * @return
     */
    public int addSupplier(Supplier supplier);

    /**
     * 修改一条供应商信息
     * @param supplier
     * @return
     */
    public int editSupplier(Supplier supplier);

    /**
     * 根据主键id查询一个供应商对象
     * @param id
     * @return
     */
    public Supplier querySupplier(Integer id);

    /**
     * 根据主键id删除一个供应商
     * @param id
     * @return
     */
    public int delSupplier(Integer id);

    /**
     * 查询全部供应商
     * @return
     */
    public List<Supplier> querySupplierList();

}
