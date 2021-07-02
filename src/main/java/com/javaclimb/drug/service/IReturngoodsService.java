package com.javaclimb.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.javaclimb.drug.entity.Returngoods;
import com.javaclimb.drug.entity.Supplier;

import java.util.List;

/**
 * 退货药品接口Service
 */
public interface IReturngoodsService extends IService<Returngoods> {
    /**
     * 分页查询退货药品
     * @param pagNum  第几页
     * @param pageSize 每页多少条数据
     * @param param  查询参数 - 药品问题名称
     * @return
     */
    public IPage<Returngoods> selectReturnPage(int pagNum, int pageSize, String param);

    /**
     *  添加一条退货信息
     * @param returngoods
     * @return
     */
    public int addReturn(Returngoods returngoods);

    /**
     * 修改一条退货信息
     * @param returngoods
     * @return
     */
    public int editReturn(Returngoods returngoods);

    /**
     * 根据主键id查询一个退货对象
     * @param id
     * @return
     */
    public Returngoods queryReturn(Integer id);

    /**
     * 根据主键id删除一个退货对象
     * @param id
     * @return
     */
    public int delReturn(Integer id);

    /**
     * 查询全部供应商
     * @return
     */
    public List<Returngoods> queryReturnList();

}
