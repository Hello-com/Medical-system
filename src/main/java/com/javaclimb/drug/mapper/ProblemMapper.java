package com.javaclimb.drug.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javaclimb.drug.entity.Problem;
import com.javaclimb.drug.entity.Supplier;
import org.springframework.stereotype.Repository;

/**
 * 问题药品的增删改查Mapper
 */
@Repository
public interface ProblemMapper extends BaseMapper<Problem> {
}
