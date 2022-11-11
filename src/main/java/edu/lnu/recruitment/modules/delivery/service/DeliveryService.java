package edu.lnu.recruitment.modules.delivery.service;

import edu.lnu.recruitment.modules.candidate.entity.Candidate;
import edu.lnu.recruitment.modules.delivery.entity.Delivery;
import edu.lnu.recruitment.modules.position.entity.Position;

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
    List<Candidate> queryByPositionId(Map<String, Object> params);

    List<Position> queryByCandidateId(Map<String, Object> params);

    boolean save(Delivery delivery);

    boolean updateStatus(Delivery delivery);
}
