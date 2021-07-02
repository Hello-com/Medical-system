package com.javaclimb.drug.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javaclimb.drug.entity.Supplier;
import com.javaclimb.drug.entity.Woinfo;
import org.springframework.stereotype.Repository;

/**
 * 药品出入库的增删改查Mapper
 */
@Repository
public interface WoinfoMapper extends BaseMapper<Woinfo> {
}
