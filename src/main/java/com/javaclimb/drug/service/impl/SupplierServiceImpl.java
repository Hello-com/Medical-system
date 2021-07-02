package com.javaclimb.drug.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaclimb.drug.entity.Supplier;
import com.javaclimb.drug.mapper.SupplierMapper;
import com.javaclimb.drug.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;
import java.util.List;

/**
 * 供应商service实现类
 */
@Service
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier> implements ISupplierService {

    @Autowired
    private SupplierMapper supplierMapper;

    /**
     * 分页查询供应商数据
     * @param pagNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数 - 供应商名称
     * @return
     */
    @Override
    public IPage<Supplier> selectSupplierPage(int pagNum, int pageSize, String param) {
        QueryWrapper<Supplier> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(!StringUtils.isEmpty(param),"name",param);
        Page<Supplier> page = new Page<>(pagNum,pageSize);
        return supplierMapper.selectPage(page,queryWrapper);
    }

    @Override
    public int addSupplier(Supplier supplier) {
        return supplierMapper.insert(supplier);
    }

    @Override
    public int editSupplier(Supplier supplier) {
        return supplierMapper.updateById(supplier);
    }

    @Override
    public Supplier querySupplier(Integer id) {
        return supplierMapper.selectById(id);
    }

    @Override
    public int delSupplier(Integer id) {
        return supplierMapper.deleteById(id);
    }

    @Override
    public List<Supplier> querySupplierList() {
        return supplierMapper.selectList(null);
    }
}
