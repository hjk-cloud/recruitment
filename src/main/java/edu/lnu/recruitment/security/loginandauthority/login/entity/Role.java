package edu.lnu.recruitment.security.loginandauthority.login.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName : Role
 * @Description : 角色信息
 * @Author : 今晚月亮复活了
 * @Date: 2022/10/15  17:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    //角色编码
    private Integer roleid;
    //角色名称
    private String rolename;
    //角色描述
    private String description;


}
