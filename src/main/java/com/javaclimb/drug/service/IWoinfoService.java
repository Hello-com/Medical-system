package com.javaclimb.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.javaclimb.drug.entity.Woinfo;
import com.javaclimb.drug.entity.Woinfo;

import java.util.List;

/**
 * 药品出入库的Service接口
 */
public interface IWoinfoService extends IService<Woinfo> {

    /**
     * 分页查询药品出入库数据
     *
     * @param pagNum   第几页
     * @param pageSize 每页多少条数据
     * @param param    查询参数 - 药品出入库名称
     * @return
     */
    public IPage<Woinfo> selectWoinfoPage(int pagNum, int pageSize, String param);

    /**
     * 新增一条药品出入库信息
     *
     * @param woinfo
     * @return
     */
    public int addWoinfo(Woinfo woinfo);

    /**
     * 修改一条药品出入库信息
     *
     * @param woinfo
     * @return
     */
    public int editWoinfo(Woinfo woinfo);

    /**
     * 根据主键id查询一个药品出入库对象
     *
     * @param id
     * @return
     */
    public Woinfo queryWoinfo(Integer id);

    /**
     * 根据主键id删除一个药品出入库
     *
     * @param id
     * @return
     */
    public int delWoinfo(Integer id);

}
