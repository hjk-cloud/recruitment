package edu.lnu.recruitment;

import cn.hutool.core.lang.Dict;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.lnu.recruitment.common.utils.R;
import edu.lnu.recruitment.common.utils.RedisUtil;
import edu.lnu.recruitment.modules.company.entity.Company;
import edu.lnu.recruitment.modules.company.mapper.CompanyMapper;
import edu.lnu.recruitment.modules.delivery.mapper.DeliveryMapper;
import edu.lnu.recruitment.modules.position.entity.Position;
import edu.lnu.recruitment.modules.position.mapper.PositionMapper;
import edu.lnu.recruitment.modules.position.service.impl.FavoriteServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
class RecruitmentApplicationTests {

    @Autowired
    private PositionMapper positionMapper;

    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private DeliveryMapper deliveryMapper;
    @Autowired
    private FavoriteServiceImpl favoriteService;
    @Autowired
    private RedisUtil redisUtil;

    @Test
    void contextLoads() {
        Page<Position> page = new Page<>(4, 3);
        positionMapper.selectPage(page, null);
        List<Position> list = page.getRecords();
        list.forEach(System.out::println);
        System.out.println(list.size());
    }

    @Test
    void companyTest() {
        Company company = companyMapper.selectById(1581990422140551168L);
        System.out.println(company.toString());
    }
    @Test
    void deliveryTest() {
        List<Long> list = deliveryMapper.selectCandidateIdByPositionIdLong(43L);
        System.out.println(list);
    }

    @Test
    void deleteByCandidateIdPositionIdTest() {
        boolean li = favoriteService.deleteByCandidateIdPositionId("1584904144370663424",
                "1582262480850255872");
    }

    @Test
    public void lm() {
        redisUtil.set("k1", "v1", 3);
        while(true) {
            System.out.println(redisUtil.get("k1"));
        }
    }

}

