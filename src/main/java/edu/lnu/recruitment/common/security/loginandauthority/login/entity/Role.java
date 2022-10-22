package edu.lnu.recruitment.common.security.loginandauthority.login.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName : Role
 * @Description : 角色信息
 * @Author : 今晚月亮复活了
 * @Date: 2022/10/15  17:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_role")//指定表名
public class Role {
    //角色编码
    @TableId(value = "role_id")
    private Long roleid;
    //角色名称
    @TableField(value = "role_name")
    private String rolename;
    //角色描述
    @TableField(value = "description")
    private String description;


}
