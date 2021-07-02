package com.javaclimb.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaclimb.drug.entity.Returnsupplier;
import com.javaclimb.drug.mapper.ReturnsupplierMapper;
import com.javaclimb.drug.service.IReturnsupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@Service
public class ReturnsupplierServiceImpl extends ServiceImpl<ReturnsupplierMapper,Returnsupplier> implements IReturnsupplierService {

    @Autowired
    private ReturnsupplierMapper returnsupplierMapper;

    @Override
    public IPage<Returnsupplier> selectRsPage(int pagNum, int pageSize, String param) {
        QueryWrapper<Returnsupplier> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(!StringUtils.isEmpty(param),"dname",param);
        Page<Returnsupplier> page = new Page<>(pagNum,pageSize);
        return returnsupplierMapper.selectPage(page,queryWrapper);
    }

    @Override
    public int addRs(Returnsupplier returnsupplier) {return returnsupplierMapper.insert(returnsupplier);}

    @Override
    public int editRs(Returnsupplier returnsupplier) {
        return returnsupplierMapper.updateById(returnsupplier);
    }

    @Override
    public Returnsupplier queryRs(Integer id) {
        return returnsupplierMapper.selectById(id);
    }

    @Override
    public int delRs(Integer id) {
        return returnsupplierMapper.deleteById(id);
    }

    @Override
    public List<Returnsupplier> queryRsList() {
        return returnsupplierMapper.selectList(null);
    }

}
