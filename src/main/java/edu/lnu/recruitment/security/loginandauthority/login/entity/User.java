package edu.lnu.recruitment.security.loginandauthority.login.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {
    //用户id
    private Integer userid;
    //登录用户名
    private String username;
    //登陆密码
    private String password;
    //存储所有角色信息
    private List<Role> roles;//关系属性 用来存储当前用户所有角色信息

    //待研究
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
