package edu.lnu.recruitment.modules.position.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.lnu.recruitment.modules.position.entity.Position;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Package: edu.lnu.recruitment.modules.position.service
 * @ClassName: PositionService
 * @Author: huangjk
 * @CreateTime: 2022/10/5 9:23
 * @Description:
 */

public interface PositionService extends IService<Position> {

    boolean save(Position position);

    List<Position> queryPage(Map<String, Object> map);
    /**
     * 插入
     */

    boolean insert(Position position);
    /**
     * 删除
     */
    boolean delete(long id);
    /**
     * 更改
     */
    boolean update(Position position);
    /**
     * 根据id查询整个对象
     */

    Position selectById(long id);
    /**
     * 查询整个职位信息列表
     */
    List<Position> selectAllPosition();
    /**
     * 根据职业名称查询整个职位信息列表
     */
    List<Position> selectAllByName(String name);
    /**
     * 根据职业名称模糊查询整个职位信息列表
     */
    List<Position> selectLikeParams(Map<String, Object> params);
    /**
     * 根据职业类别查询整个职位信息列表
     */
    List<Position> selectAllByCategory(String category);
    /**
     * 根据职业类别模糊查询整个职位信息列表
     */
    List<Position> selectLikeCategory(String category);
    /**
     * 根据学历经历要求查询整个职位信息列表
     */
    List<Position> selectAllByThreshold(String threshold);
    /**
     * 根据职位关键词查询整个职位信息列表
     */
    List<Position> selectAllByKeyword(String keyword);
    /**
     * 根据工作地址查询整个职位信息列表
     */
    List<Position> selectAllByAddress(String address);
    /**
     * 根据薪资范围查询整个职位信息列表
     */
    List<Position> selectAllBySalaryRange(String salaryRange);

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
