package edu.lnu.recruitment.common.security.loginandauthority.login.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName : User
 * @Description : 登录用户
 * @Author : 今晚月亮复活了
 * @Date: 2022/10/14  21:27
 */

@Data
@TableName(value = "t_user")//指定表名
public class User implements UserDetails {
    //用户id
    @TableId(value = "user_id")
    private Long userid;
    //登录用户名
    @TableField(value = "user_name")
    private String username;
    //登陆密码
    @TableField(value = "user_password")
    private String password;
    //存储所有角色信息
    @TableField(exist=false)
    private List<Role> roles;//关系属性 用来存储当前用户所有角色信息

    public User(Long userid, String username, String password) {
        this.userid = userid;
        this.username = username;
        this.password = password;
    }

    public User() {

    }


    //返回权限信息
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        roles.forEach(role -> {
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role.getRolename());
            authorities.add(simpleGrantedAuthority);
        });
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
