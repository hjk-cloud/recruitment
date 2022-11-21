package edu.lnu.recruitment.modules.candidate.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @ClassName : CandidateFile
 * @Description : 求职者简历的实体类
 * @Author : 今晚月亮复活了
 * @Date: 2022/11/12  20:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value="t_candidate_file")
@Accessors(chain = true)
public class CandidateFile {
    private Long id;
    @TableField(value = "file_name")
    private String fileName;
    @TableField(value = "file_path")
    private String path;
    @TableField(value = "upload_time")
    private Date uploadTime;
    @TableField(value = "candidate_id")
    private Long candidateId;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
