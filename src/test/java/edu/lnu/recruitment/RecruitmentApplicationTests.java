package edu.lnu.recruitment;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import edu.lnu.recruitment.modules.position.entity.Position;
import edu.lnu.recruitment.modules.position.mapper.PositionMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class RecruitmentApplicationTests {

    @Autowired
    private PositionMapper positionMapper;

    @Test
    void contextLoads() {
        Page<Position> page = new Page<>(4,3);
        positionMapper.selectPage(page, null);
        List<Position> list=  page.getRecords();
        list.forEach(System.out::println);
        System.out.println(list.size());
    }
    @Test
    public void testselectLikeName(){
        QueryWrapper<Position> wrapper = new QueryWrapper<>();
        wrapper.like("position_name", "开发");
        List<Position> users =positionMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }
    @Test
    public void testselectByRecruiterId(){
        List<Position> positions = positionMapper.selectAllByRecruiterId(1);
        positions.forEach(System.out::println);

    }
    @Test
    public void testselectByCompanyId(){
        List<Position> positions = positionMapper.selectAllByCompanyId(1);
        positions.forEach(System.out::println);

    }
    @Test
    public void testselectLikeSalaryRange(){
        List<Position> positions = positionMapper.selectLikeSalaryRange("%20K-50K%");
        positions.forEach(System.out::println);

    }
}
