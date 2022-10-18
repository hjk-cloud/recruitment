package edu.lnu.recruitment.modules.position.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Package: edu.lnu.recruitment.modules.position.entity
 * @ClassName: Position
 * @Author: huangjk
 * @CreateTime: 2022/10/5 9:08
 * @Description: 职位信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value="t_position")
public class Position {
    private long id;
    @TableField(value = "recruiter_id")
    private long recruiterId;
    @TableField(value = "company_id")
    private long companyId;

    @TableField(value = "position_name")
    private String name;

    @TableField(value = "position_description")
    private String description;

    private String highlight;

    private String category;

    private String threshold;

    private String keyword;

    private String address;

    private String salaryRange;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
