package edu.lnu.recruitment.modules.position.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.lnu.recruitment.modules.position.entity.Position;
import org.apache.ibatis.annotations.Mapper;


/**
 * @Package: edu.lnu.recruitment.modules.position.mapper
 * @ClassName: PositionMapper
 * @Author: huangjk
 * @CreateTime: 2022/10/5 10:27
 * @Description:
 */
@Mapper
public interface PositionMapper extends BaseMapper<Position> {

}
