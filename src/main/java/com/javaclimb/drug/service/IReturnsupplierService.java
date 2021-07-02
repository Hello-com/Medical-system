package com.javaclimb.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.javaclimb.drug.entity.Returnsupplier;

import java.util.List;

public interface IReturnsupplierService extends IService<Returnsupplier> {
    /**
     * 分页查询
     * @param pagNum
     * @param pageSize
     * @param param
     * @return
     */
    public IPage<Returnsupplier> selectRsPage(int pagNum, int pageSize, String param);

    public int addRs(Returnsupplier returnsupplier);

    public int editRs(Returnsupplier returnsupplier);

    public Returnsupplier queryRs(Integer id);

    public int delRs(Integer id);

    public List<Returnsupplier> queryRsList();
}
