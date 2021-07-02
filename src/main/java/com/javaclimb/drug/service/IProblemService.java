package com.javaclimb.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.javaclimb.drug.entity.Problem;

/**
 * 药品问题的Service接口
 */
public interface IProblemService extends IService<Problem> {

    /**
     * 分页查询药品问题数据
     *
     * @param pagNum   第几页
     * @param pageSize 每页多少条数据
     * @param param    查询参数 - 药品问题名称
     * @return
     */
        public IPage<Problem> selectProblemPage(int pagNum, int pageSize, String param);

    /**
     * 新增一条药品问题信息
     *
     * @param problem
     * @return
     */
    public int addProblem(Problem problem);

    /**
     * 修改一条药品问题信息
     *
     * @param problem
     * @return
     */
    public int editProblem(Problem problem);

    /**
     * 根据主键id查询一个药品问题对象
     *
     * @param id
     * @return
     */
    public Problem queryProblem(Integer id);

    /**
     * 根据主键id删除一个药品问题
     *
     * @param id
     * @return
     */
    public int delProblem(Integer id);

}
