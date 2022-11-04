package edu.lnu.recruitment.modules.position.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.lnu.recruitment.modules.position.entity.Position;

import java.io.Serializable;
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

    List<Position> queryPageByConditions(Map<String, Object> params);

    Position queryById(Map<String, Object> params);

    List<Object> queryHistory(long candidateId);

    boolean delete(long positionId);

    boolean update(Position position);

    List<Position>  queryByRecruiterId(Map<String, Object> params);
}
