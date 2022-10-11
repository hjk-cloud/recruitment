package edu.lnu.recruitment.modules.position.service.impl;

import edu.lnu.recruitment.modules.position.entity.Position;
import edu.lnu.recruitment.modules.position.mapper.PositionMapper;
import edu.lnu.recruitment.modules.position.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package: edu.lnu.recruitment.modules.position.service.impl
 * @ClassName: PositionServiceImpl
 * @Author: huangjk
 * @CreateTime: 2022/10/11 21:07
 * @Description:
 */
@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionMapper positionMapper;

    @Override
    public boolean save(Position position) {
        positionMapper.insert(position);
        return true;
    }
}
