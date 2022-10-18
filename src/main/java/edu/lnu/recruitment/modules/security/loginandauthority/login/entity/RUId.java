package edu.lnu.recruitment.modules.security.loginandauthority.login.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * @ClassName : URId
 * @Description : 用户和角色映射表
 * @Author : 今晚月亮复活了
 * @Date: 2022/10/18  16:02
 */
@TableName(value = "t_user_role")//指定表名
public class RUId {
    @TableId(value = "ru_id")
    private Long ruid;
    @TableField(value = "user_id")
    private Long userid;
    @TableField(value = "role_id")
    private Long roleid;
    //创建时间
    @TableField(value = "create_time")
    private Date create_time;
    //更新时间
    @TableField(value = "update_time")
    private Date update_time;
}
