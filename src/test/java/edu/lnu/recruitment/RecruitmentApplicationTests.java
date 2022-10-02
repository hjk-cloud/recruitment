package edu.lnu.recruitment;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.lnu.recruitment.admin.entity.Admin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RecruitmentApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    void contextLoads() throws JsonProcessingException {
        Admin admin = new Admin(001, "admin", "password");
        redisTemplate.opsForValue().set("admin", admin);
        System.out.println(redisTemplate.opsForValue().get("admin"));
    }

}
