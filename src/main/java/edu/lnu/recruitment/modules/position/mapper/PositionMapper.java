package edu.lnu.recruitment.modules.position.mapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.lnu.recruitment.modules.position.entity.Position;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package: edu.lnu.recruitment.modules.position.mapper
 * @ClassName: PositionMapper
 * @Author: huangjk
 * @CreateTime: 2022/10/5 10:27
 * @Description:
 */
@Mapper
public interface PositionMapper extends BaseMapper<Position> {
    /**
     * 增
     */
    int  insert(Position position);
    /**
     * 删
     */

    int  delete(@Param("id") Long id);
    /**
     * 改
     */

    int  update(Position position);
    /**
     * 根据id找职位信息
     */

    Position selectById(@Param("id") Long id);

    /**
     * 根据职业名称查询整个职位信息列表
     */
    List<Position> selectAllByName(@Param("name") String name);
    /**
     * 根据职业名称模糊查询整个职位信息列表
     */
    List<Position> selectLikeName(String name);
    /**
     * 根据职业类别查询整个职位信息列表
     */
    List<Position> selectAllByCategory(@Param("category") String category);
    /**
     * 根据职业类别模糊查询整个职位信息列表
     */
    List<Position> selectLikeCategory(String category);
    /**
     * 根据学历经历要求查询整个职位信息列表
     */
    List<Position> selectAllByThreshold(@Param("threshold") String threshold);
    /**
     * 根据职位关键词查询整个职位信息列表
     */
    List<Position> selectAllByKeyword(@Param("keyword") String keyword);
    /**
     * 根据工作地址查询整个职位信息列表
     */
    List<Position> selectAllByAddress(@Param("address") String address);
    /**
     * 根据薪资范围查询整个职位信息列表
     */
    List<Position> selectAllBySalaryRange(@Param("salaryRange") String salaryRange);
    /**
     * 根据薪资范围模糊查询整个职位信息列表
     */

    List<Position> selectLikeSalaryRange(String salaryRange);

    /**
     * 根据recruiterId查询整个职位信息列表
     */
    List<Position> selectAllByRecruiterId(long recruiterId);
    /**
     * 根据companyId查询整个职位信息列表
     */
    List<Position> selectAllByCompanyId(long companyId);
}
