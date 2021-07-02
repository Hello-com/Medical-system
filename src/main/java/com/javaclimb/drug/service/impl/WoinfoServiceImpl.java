package com.javaclimb.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaclimb.drug.entity.Woinfo;
import com.javaclimb.drug.mapper.WoinfoMapper;
import com.javaclimb.drug.service.IWoinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;

/**
 * 药品出入库service实现类
 */
@Service
public class WoinfoServiceImpl extends ServiceImpl<WoinfoMapper, Woinfo> implements IWoinfoService {

    @Autowired
    private WoinfoMapper woinfoMapper;

    /**
     * 分页查询药品出入库数据
     * @param pagNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数 - 药品出入库名称
     * @return
     */
    @Override
    public IPage<Woinfo> selectWoinfoPage(int pagNum, int pageSize, String param) {
        QueryWrapper<Woinfo> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isEmpty(param)){
            queryWrapper.like(!StringUtils.isEmpty(param),"dname",param);
        }
        Page<Woinfo> page = new Page<>(pagNum,pageSize);
        return woinfoMapper.selectPage(page,queryWrapper);
    }

    @Override
    public int addWoinfo(Woinfo woinfo) {
        return woinfoMapper.insert(woinfo);
    }

    @Override
    public int editWoinfo(Woinfo woinfo) {
        return woinfoMapper.updateById(woinfo);
    }

    @Override
    public Woinfo queryWoinfo(Integer id) {
        return woinfoMapper.selectById(id);
    }

    @Override
    public int delWoinfo(Integer id) {
        return woinfoMapper.deleteById(id);
    }

}
