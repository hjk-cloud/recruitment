package edu.lnu.recruitment.modules.position.service;

import edu.lnu.recruitment.modules.position.entity.Position;

import java.util.List;
import java.util.Map;

/**
 * @Package: edu.lnu.recruitment.modules.position.service
 * @ClassName: PositionService
 * @Author: huangjk
 * @CreateTime: 2022/10/5 9:23
 * @Description:
 */
public interface PositionService {

    boolean save(Position position);

    List<Position> queryPage(Map<String, Object> map);
}
