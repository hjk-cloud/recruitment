package edu.lnu.recruitment;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.lnu.recruitment.modules.company.entity.Company;
import edu.lnu.recruitment.modules.company.mapper.CompanyMapper;
import edu.lnu.recruitment.modules.delivery.mapper.DeliveryMapper;
import edu.lnu.recruitment.modules.favorite.entity.Favorite;
import edu.lnu.recruitment.modules.favorite.mapper.FavoriteMapper;
import edu.lnu.recruitment.modules.position.entity.Position;
import edu.lnu.recruitment.modules.position.mapper.PositionMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class RecruitmentApplicationTests {

    @Autowired
    private PositionMapper positionMapper;

    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private DeliveryMapper deliveryMapper;
    @Autowired
    private FavoriteMapper favoriteMapper;

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
    void allfavoriteTest() {
        List<Position> list = favoriteMapper.allFavoriteOfCandidateId(123L);
        System.out.println(list);
    }
    @Test
    void deleteByCandidateIdPositionIdTest() {
        boolean li = favoriteMapper.deleteByCandidateIdPositionId(123L,2L);
        System.out.println(li);
    }
    @Test
    void existPositionIdTest() {
        int  li = favoriteMapper.existPositionId(123L,3L);
        System.out.println(li);
    }
}

