package com.javaclimb.drug.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javaclimb.drug.entity.Druginfo;
import com.javaclimb.drug.entity.Supplier;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 药品的的增删改查Mapper
 */
@Repository
public interface DruginofMapper extends BaseMapper<Druginfo> {
}
