package com.javaclimb.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaclimb.drug.entity.Problem;
import com.javaclimb.drug.mapper.ProblemMapper;
import com.javaclimb.drug.service.IProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

/**
 * 药品问题service实现类
 */
@Service
public class ProblemServiceImpl extends ServiceImpl<ProblemMapper, Problem> implements IProblemService {

    @Autowired
    private ProblemMapper problemMapper;

    /**
     * 分页查询药品问题数据
     * @param pagNum 第几页
     * @param pageSize 每页多少条数据
     * @param param 查询参数 - 药品问题名称
     * @return
     */
    @Override
    public IPage<Problem> selectProblemPage(int pagNum, int pageSize, String param) {
        QueryWrapper<Problem> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(!StringUtils.isEmpty(param),"dname",param);
        Page<Problem> page = new Page<>(pagNum,pageSize);
        return problemMapper.selectPage(page,queryWrapper);
    }

    @Override
    public int addProblem(Problem problem) {
        return problemMapper.insert(problem);
    }

    @Override
    public int editProblem(Problem problem) {
        return problemMapper.updateById(problem);
    }

    @Override
    public Problem queryProblem(Integer id) {
        return problemMapper.selectById(id);
    }

    @Override
    public int delProblem(Integer id) {
        return problemMapper.deleteById(id);
    }

}
