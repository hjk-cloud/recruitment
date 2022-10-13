package edu.lnu.recruitment.common.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Package: edu.lnu.recruitment.common.config
 * @ClassName: MybatisPlusConfig
 * @Author: huangjk
 * @CreateTime: 2022/10/13 20:16
 * @Description:
 */
@Configuration
public class MybatisPlusConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
