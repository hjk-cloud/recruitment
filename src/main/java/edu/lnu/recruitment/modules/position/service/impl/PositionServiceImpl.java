package edu.lnu.recruitment.modules.position.service.impl;

import cn.hutool.core.lang.Snowflake;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.lnu.recruitment.common.utils.RedisUtil;
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
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position> implements PositionService {
    @Autowired
    private PositionMapper positionMapper;
    @Autowired
    private RedisUtil redisUtil;

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
    public List<Position> queryPageByConditions(Map<String, Object> params) {
        QueryWrapper<Position> wrapper = new QueryWrapper<>();

        int pageNum = (int) params.get("page");
        int size = (int) params.get("size");
        if (params.containsKey("name")) {
            String name = (String) params.get("name");
            wrapper.like("position_name", name);
        }
        if (params.containsKey("address")) {
            String address = (String) params.get("address");
            wrapper.like("address", address);
        }
        if (params.containsKey("category")) {
            String category = (String) params.get("category");
            wrapper.likeRight("category", category);
        }
        if (params.containsKey("keyword")) {
            String keyword = (String) params.get("keyword");
            wrapper.likeRight(" keyword", keyword);
        }
        if (params.containsKey("salary")) {
            int salary = (int) params.get("salary");
            wrapper.le("min_salary", salary).ge("max_salary", salary);
        }

        Page<Position> page = new Page<>(pageNum, size);
        positionMapper.selectPage(page, wrapper);
        return page.getRecords();
    }

    /**
     * 查询职位详情
     * 1.在redis中查找缓存。若不存在，向MySQL查询，将查询结果写入缓存
     * 2.对于已登录的用户（请求参数中存在candidateId），将职位信息写入Redis，以实现浏览记录
     * 3.职位点击量+1，写入Redis，以实现职位点击量统计
     */
    @Override
    public Position queryById(Map<String, Object> params) {
        String positionId = (String) params.get("positionId");
        Position position = (Position) redisUtil.get("position_" + positionId);
        if (position == null) {
            position = positionMapper.selectById(positionId);
            redisUtil.set("position_" + positionId, position, 60);
        }
        if (params.containsKey("candidateId")) {
            String candidateId = (String) params.get("candidateId");
            redisUtil.lRemove("history_" + candidateId, 0, position);
            redisUtil.lSet("history_" + candidateId, position);
        }
        redisUtil.incr("position_count_" + positionId, 1);
        return position;
    }

    @Override
    public List<Object> queryHistory(long candidateId) {
        List<Object> list = redisUtil.lGet("history_" + candidateId, 0, -1);
        return list;
    }

    @Override
    public boolean delete(long positionId) {
        boolean isSuccess = positionMapper.deleteById(positionId) > 0;
        if (!isSuccess) {
            return false;
        }
        redisUtil.del("position_count_" + positionId);
        redisUtil.del("position_" + positionId);
        return true;
    }

    @Override
    public boolean update(Position position) {
        boolean isSuccess = positionMapper.updateById(position) > 0;
        if (!isSuccess) {
            return false;
        }
        redisUtil.del("position_" + position.getId());
        return true;
    }

    @Override
    public List<Position> queryByRecruiterId(Map<String, Object> params) {
        QueryWrapper<Position> wrapper = new QueryWrapper<>();
        int pageNum = (int) params.get("page");
        int size = (int) params.get("size");
        String recruiterId = (String) params.get("recruiterId");
        wrapper = wrapper.eq("recruiter_id", recruiterId);
        Page<Position> page = new Page<>(pageNum, size);
        positionMapper.selectPage(page, wrapper);
        return page.getRecords();
    }
}