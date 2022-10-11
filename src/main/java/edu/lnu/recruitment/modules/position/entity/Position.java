package edu.lnu.recruitment.modules.position.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@TableName("t_position")
public class Position {
    private Long id;
    @TableField(value = "position_name")
    private String name;
    @TableField(value = "position_description")
    private String description;
    private String highlight;
    private String category;
    private String threshold;
    private String keywords;
    private String address;
    private String salaryRange;
}
