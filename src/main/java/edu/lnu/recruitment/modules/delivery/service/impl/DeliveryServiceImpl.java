package edu.lnu.recruitment.modules.delivery.service.impl;

import cn.hutool.core.lang.Snowflake;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.lnu.recruitment.modules.candidate.entity.Candidate;
import edu.lnu.recruitment.modules.candidate.mapper.CandidateMapper;
import edu.lnu.recruitment.modules.delivery.entity.Delivery;
import edu.lnu.recruitment.modules.delivery.mapper.DeliveryMapper;
import edu.lnu.recruitment.modules.delivery.service.DeliveryService;
import edu.lnu.recruitment.modules.position.entity.Position;
import edu.lnu.recruitment.modules.position.mapper.PositionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Package: edu.lnu.recruitment.modules.delivery.service.impl
 * @ClassName: DeliveryServiceImpl
 * @Author: huangjk
 * @CreateTime: 2022/11/4 20:18
 * @Description:
 */
@Service
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    private DeliveryMapper deliveryMapper;
    @Autowired
    private PositionMapper positionMapper;
    @Autowired
    private CandidateMapper candidateMapper;

    @Override
    public List<Candidate> queryByPositionId(Map<String, Object> params) {
        int pageNum = (int) params.get("page");
        int size = (int) params.get("size");
        String positionId = (String) params.get("positionId");
        List<Long> candidateIds = deliveryMapper.selectCandidateIdByPositionIdLong(Long.valueOf(positionId));
        QueryWrapper<Candidate> wrapper = new QueryWrapper<>();
        wrapper.in("id", candidateIds);
        Page<Candidate> page = new Page<>(pageNum, size);
        candidateMapper.selectPage(page, wrapper);
        return page.getRecords();
    }

    @Override
    public List<Position> queryByCandidateId(Map<String, Object> params) {
        int pageNum = (int) params.get("page");
        int size = (int) params.get("size");
        String candidateId = (String) params.get("candidateId");
        List<Long> positionIds = deliveryMapper.selectPositionIdByCandidateIdLong(Long.valueOf(candidateId));
        QueryWrapper<Position> wrapper = new QueryWrapper<>();
        wrapper.in("id", positionIds);
        Page<Position> page = new Page<>(pageNum, size);
        positionMapper.selectPage(page, wrapper);
        return page.getRecords();
    }

    @Override
    public boolean save(Delivery delivery) {
        long positionId = delivery.getPositionId();
        long candidateId = delivery.getCandidateId();
        if (checkData(positionId, candidateId)) {
            return false;
        }
        delivery.setId(new Snowflake(0, 1).nextId());
        return deliveryMapper.insert(delivery) > 0;
    }

    @Override
    public boolean updateStatus(Delivery delivery) {
        long id = delivery.getId();
        int deliveryStatus = delivery.getDeliveryStatus();
        return deliveryMapper.updateStatus(id, deliveryStatus);
    }

    private boolean checkData(long positionId, long candidateId) {
        QueryWrapper<Delivery> wrapper = new QueryWrapper<>();
        wrapper.eq("position_id", positionId).eq("candidate_id", candidateId);
        return deliveryMapper.selectOne(wrapper) != null;
    }
}
