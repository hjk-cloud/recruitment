package edu.lnu.recruitment.common.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * @Package: edu.lnu.recruitment.common.config
 * @ClassName: MyMetaObjectHandler
 * @Author: huangjk
 * @CreateTime: 2022/10/12 20:51
 * @Description: 字段自动填充
 */
@Configuration
public class MyMetaObjectHandler implements MetaObjectHandler {//extends??
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
