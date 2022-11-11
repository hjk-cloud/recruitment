package edu.lnu.recruitment.modules.delivery.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.lnu.recruitment.modules.delivery.entity.Delivery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Package: edu.lnu.recruitment.modules.delivery.mapper
 * @ClassName: DeliveryMapper
 * @Author: huangjk
 * @CreateTime: 2022/11/3 21:28
 * @Description:
 */
@Mapper
public interface DeliveryMapper extends BaseMapper<Delivery> {
    List<Long> selectCandidateIdByPositionIdLong(Long positionId);

    List<Long> selectPositionIdByCandidateIdLong(Long candidateId);

    boolean updateStatus(Long id, Integer deliveryStatus);
}
