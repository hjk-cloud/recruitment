package edu.lnu.recruitment.common.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Package: edu.lnu.recruitment.common.config
 * @ClassName: MyMetaObjectHandler
 * @Author: huangjk
 * @CreateTime: 2022/10/12 20:51
 * @Description: 字段自动填充
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {//extends??
    @Override
    public void insertFill(MetaObject metaObject) {
        //setFieldValByName(java.lang.String fieldName, java.lang.Object fieldVal, org.apache.ibatis.reflection.MetaObject metaObject)
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
