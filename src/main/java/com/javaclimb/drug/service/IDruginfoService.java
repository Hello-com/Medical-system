package com.javaclimb.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.javaclimb.drug.entity.Druginfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 药品的Service接口
 */

public interface IDruginfoService extends IService<Druginfo> {

    /**
     * 分页查询药品数据
     * @param pagNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数 - 药品名称
     * @return
     */
    public IPage<Druginfo>  selectDruginfoPage(int pagNum, int pageSize, String param);

    /**
     * 新增一条药品信息
     * @param druginfo
     * @return
     */
    public int addDruginfo(Druginfo druginfo);

    /**
     * 修改一条药品信息
     * @param druginfo
     * @return
     */
    public int editDruginfo(Druginfo druginfo);

    /**
     * 根据主键id查询一个药品对象
     * @param id
     * @return
     */
    public Druginfo queryDruginfo(Integer id);

    /**
     * 根据主键id删除一个药品
     * @param id
     * @return
     */
    public int delDruginfo(Integer id);

    /**
     * 查询全部药品
     * @return
     */
    public List<Druginfo> queryDruginfoList();

}
