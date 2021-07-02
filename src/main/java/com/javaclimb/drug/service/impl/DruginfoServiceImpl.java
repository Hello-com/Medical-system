package com.javaclimb.drug.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaclimb.drug.entity.Druginfo;
import com.javaclimb.drug.mapper.DruginofMapper;
import com.javaclimb.drug.service.IDruginfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DruginfoServiceImpl extends ServiceImpl<DruginofMapper, Druginfo> implements IDruginfoService{

    @Autowired
    private DruginofMapper druginfoMapper;

    /**
     * 分页查询供应商数据
     * @param pagNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数 - 供应商名称
     * @return
     */
    @Override
    public IPage<Druginfo> selectDruginfoPage(int pagNum, int pageSize, String param) {
        QueryWrapper<Druginfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(!StringUtils.isEmpty(param),"name",param);
        Page<Druginfo> page = new Page<>(pagNum,pageSize);
        return druginfoMapper.selectPage(page,queryWrapper);
        //return druginofMapper.selectPage(page,queryWrapper);
    }

    @Override
    public int addDruginfo(Druginfo druginfo) {
        return druginfoMapper.insert(druginfo);
    }

    @Override
    public int editDruginfo(Druginfo druginfo) {
        return druginfoMapper.updateById(druginfo);
    }

    @Override
    public Druginfo queryDruginfo(Integer id) {
        return druginfoMapper.selectById(id);
    }

    @Override
    public int delDruginfo(Integer id) {
        return druginfoMapper.deleteById(id);
    }

    @Override
    public List<Druginfo> queryDruginfoList() {
        return druginfoMapper.selectList(null);
    }

}
