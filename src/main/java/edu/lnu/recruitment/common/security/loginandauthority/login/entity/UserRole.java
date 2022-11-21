package edu.lnu.recruitment.common.security.loginandauthority.login.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @ClassName : UserRole
 * @Description : 用户角色中间表
 * @Author : 今晚月亮复活了
 * @Date: 2022/11/20  20:23
 */
@Data
@TableName(value = "t_user_role")//指定表名
@Accessors(chain = true)
public class UserRole {
    //用户id
    @TableId(value = "ru_id")
    private Long id;

    @TableField(value = "role_id")
    private Long roleId;

    @TableField(value = "user_id")
    private Long userId;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
