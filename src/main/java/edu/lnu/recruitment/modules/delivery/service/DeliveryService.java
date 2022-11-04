package edu.lnu.recruitment.modules.delivery.service;

import edu.lnu.recruitment.modules.delivery.entity.Delivery;

import java.util.List;
import java.util.Map;

/**
 * @Package: edu.lnu.recruitment.modules.delivery.service
 * @ClassName: DeliveryService
 * @Author: huangjk
 * @CreateTime: 2022/11/4 20:15
 * @Description:
 */
public interface DeliveryService {
    List<Delivery> queryByPositionId(Map<String, Object> params);

    List<Delivery> queryByCandidateId(Map<String, Object> params);

    boolean save(Delivery delivery);
}
