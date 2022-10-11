package edu.lnu.recruitment.modules.position.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.lnu.recruitment.modules.position.entity.Position;
import org.springframework.stereotype.Service;

/**
 * @Package: edu.lnu.recruitment.modules.position.service
 * @ClassName: PositionService
 * @Author: huangjk
 * @CreateTime: 2022/10/5 9:23
 * @Description:
 */
public interface PositionService {

    boolean save(Position position);

}
