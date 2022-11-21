package edu.lnu.recruitment.modules.company.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.Date;

/**
 * @Package: edu.lnu.recruitment.modules.company.entity
 * @ClassName: Company
 * @Author: huangjk
 * @CreateTime: 2022/10/17 19:17
 * @Description: 公司信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_company")
@Accessors(chain = true)
public class Company {
    private long id;

    private String companyName;

    private String category;

    private String numberScale;

    private String address;

    private String website;

    private String companyProfile;

    private String fullName;

    private String creditCode;

    private LocalDate establishDate;

    private String registeredCapital;

    private Byte verification;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
