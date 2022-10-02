package edu.lnu.recruitment.admin.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Package: edu.lnu.recruitment.admin.entity
 * @ClassName: Admin
 * @Author: huangjk
 * @CreateTime: 2022/9/28 15:54
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin implements Serializable {
    private int id;
    private String name;
    private String password;

}
