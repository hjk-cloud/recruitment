package edu.lnu.recruitment;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.lnu.recruitment.admin.entity.Admin;
import edu.lnu.recruitment.modules.position.entity.Position;
import edu.lnu.recruitment.modules.position.mapper.PositionMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

@SpringBootTest
@MapperScan("edu.lnu.recruitment.modules.*.mapper")
class RecruitmentApplicationTests {

    @Autowired
    private PositionMapper positionMapper;

    @Test
    void contextLoads() throws JsonProcessingException {
        List<Position> list = positionMapper.selectList(null);
        list.forEach(System.out::println);
    }
}
