package edu.lnu.recruitment.modules.delivery.service.impl;

import cn.hutool.core.lang.Snowflake;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.lnu.recruitment.modules.delivery.entity.Delivery;
import edu.lnu.recruitment.modules.delivery.mapper.DeliveryMapper;
import edu.lnu.recruitment.modules.delivery.service.DeliveryService;
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

    @Override
    public List<Delivery> queryByPositionId(Map<String, Object> params) {
        int pageNum = (int) params.get("page");
        int size = (int) params.get("size");
        String positionId = (String) params.get("positionId");
        QueryWrapper<Delivery> wrapper = new QueryWrapper<>();
        wrapper.eq("position_id", positionId);
        Page<Delivery> page = new Page<>(pageNum, size);
        deliveryMapper.selectPage(page, wrapper);
        return page.getRecords();
    }

    @Override
    public List<Delivery> queryByCandidateId(Map<String, Object> params) {
        int pageNum = (int) params.get("page");
        int size = (int) params.get("size");
        String candidateId = (String) params.get("candidateId");
        QueryWrapper<Delivery> wrapper = new QueryWrapper<>();
        wrapper.eq("candidate_id", candidateId);
        Page<Delivery> page = new Page<>(pageNum, size);
        deliveryMapper.selectPage(page, wrapper);
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

    private boolean checkData(long positionId, long candidateId) {
        QueryWrapper<Delivery> wrapper = new QueryWrapper<>();
        wrapper.eq("position_id", positionId).eq("candidate_id", candidateId);
        return deliveryMapper.selectOne(wrapper) != null;
    }
}
