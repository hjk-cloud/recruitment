package edu.lnu.recruitment.modules.delivery.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Package: edu.lnu.recruitment.modules.delivery.entity
 * @ClassName: delivery
 * @Author: huangjk
 * @CreateTime: 2022/11/3 21:01
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_delivery")
public class Delivery {
    private long id;
    private long candidateId;
    private long positionId;
    private int deliveryStatus;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
