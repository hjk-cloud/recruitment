package edu.lnu.recruitment.modules.position.service.impl;

import cn.hutool.core.lang.Snowflake;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.lnu.recruitment.modules.position.entity.Position;
import edu.lnu.recruitment.modules.position.mapper.PositionMapper;
import edu.lnu.recruitment.modules.position.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Package: edu.lnu.recruitment.modules.position.service.impl
 * @ClassName: PositionServiceImpl
 * @Author: huangjk
 * @CreateTime: 2022/10/11 21:07
 * @Description:
 */
@Service
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position>implements PositionService {

    @Autowired
    private PositionMapper positionMapper;


    QueryWrapper<Position> wrapper = new QueryWrapper<>();

    @Override
    public boolean save(Position position) {
        position.setId(new Snowflake(0, 1).nextId());
        positionMapper.insert(position);
        return true;
    }

    @Override
    public List<Position> queryPage(Map<String, Object> params) {
        int pageNum = (int) params.get("page");
        int size = (int) params.get("size");
        Page<Position> page = new Page<>(pageNum, size);
        positionMapper.selectPage(page, null);
        return page.getRecords();
    }

    @Override
    public boolean insert(Position position) {
        return positionMapper.insert(position)>0;
    }

    @Override
    public boolean delete(long id) {
        return positionMapper.deleteById(id)>0;
    }

    @Override
    public boolean update(Position position) {
        return positionMapper.updateById(position)>0;
    }

    @Override
    public Position selectById(long id) {
        return positionMapper.selectById(id);
    }

    @Override
    public List<Position> selectAllPosition() {
        return positionMapper.selectList(null);
    }

    @Override
    public List<Position> selectAllByName(String name) {
        return positionMapper.selectAllByName(name);
    }

    @Override
    public List<Position> selectLikeParams(Map<String, Object> params) {
        if(params.containsKey("name")) {
            String name = (String) params.get("name");
            wrapper = wrapper.like("position_name", name);
        }
        if(params.containsKey("address")) {
            String address = (String) params.get("address");
            wrapper = wrapper.eq("address", address);
        }
        if (params.containsKey("category")) {
            String address = (String) params.get("category");
            wrapper = wrapper.like("category", address);
        }

        return positionMapper.selectList(wrapper);
    }

    @Override
    public List<Position> selectAllByCategory(String category) {
        return positionMapper.selectAllByCategory(category);
    }

    @Override
    public List<Position> selectLikeCategory(String category) {
        return positionMapper.selectLikeCategory(category);
    }

    @Override
    public List<Position> selectAllByThreshold(String threshold) {
        return positionMapper.selectAllByThreshold(threshold);
    }

    @Override
    public List<Position> selectAllByKeyword(String keyword) {
        return positionMapper.selectAllByKeyword(keyword);
    }

    @Override
    public List<Position> selectAllByAddress(String address) {
        return positionMapper.selectAllByAddress(address);
    }

    @Override
    public List<Position> selectAllBySalaryRange(String salaryRange) {
        return positionMapper.selectAllBySalaryRange(salaryRange);
    }

    @Override
    public List<Position> selectLikeSalaryRange(String salaryRange) {
        return positionMapper.selectLikeSalaryRange(salaryRange);
    }

    @Override
    public List<Position> selectAllByRecruiterId(long recruiterId) {
        return positionMapper.selectAllByRecruiterId(recruiterId);
    }

    @Override
    public List<Position> selectAllByCompanyId(long companyId) {
        return positionMapper.selectAllByCompanyId(companyId);
    }


}
