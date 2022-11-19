package edu.lnu.recruitment.modules.candidate.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName : Candidate
 * @Description : 求职者类
 * @Author : 今晚月亮复活了
 * @Date: 2022/10/25  17:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value="t_candidate")
public class Candidate {
    @TableField(value = "id")
    private Long id;
    private String candidateName;
    @TableField(exist = false)
    private String candidatePassword;
    private String candidatePhone;
    private Integer sex;
    private String birthDate;
    private String city;
    private String jobStatus;
    private String education;
    private String school;
    @TableField(value = "expect_salary")
    private String expectSalary;
    private String attachment;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}
