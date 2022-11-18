package edu.lnu.recruitment.modules.recruiter.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName : Recruiter
 * @Description : 招聘者实体类
 * @Author : 今晚月亮复活了
 * @Date: 2022/10/25  18:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_recruiter")
public class Recruiter {
    private Long id;
    private Long companyId;
    private String recruiterName;
    @TableField(exist = false)
    private String recruiterPassword;
    private Integer sex;
    private String jobTitle;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
