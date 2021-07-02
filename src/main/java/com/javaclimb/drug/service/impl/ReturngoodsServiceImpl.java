package com.javaclimb.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaclimb.drug.entity.Returngoods;
import com.javaclimb.drug.mapper.ReturngoodsMapper;
import com.javaclimb.drug.service.IReturngoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;

/**
 * 退货问题接口实行类
 */
@Service
public class ReturngoodsServiceImpl extends ServiceImpl<ReturngoodsMapper,Returngoods> implements IReturngoodsService {

    @Autowired
    private ReturngoodsMapper returngoodsMapper;

    @Override
    public IPage<Returngoods> selectReturnPage(int pagNum, int pageSize, String param) {
        QueryWrapper<Returngoods> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(!StringUtils.isEmpty(param),"dname",param);
        Page<Returngoods> page = new Page<>(pagNum,pageSize);
        return returngoodsMapper.selectPage(page,queryWrapper);
    }

    @Override
    public int addReturn(Returngoods returngoods) {
        return returngoodsMapper.insert(returngoods);
    }

    @Override
    public int editReturn(Returngoods returngoods) {
        return returngoodsMapper.updateById(returngoods);
    }

    @Override
    public Returngoods queryReturn(Integer id) {
        return returngoodsMapper.selectById(id);
    }

    @Override
    public int delReturn(Integer id) {
        return returngoodsMapper.deleteById(id);
    }

    @Override
    public List<Returngoods> queryReturnList() {
        return returngoodsMapper.selectList(null);
    }
}
