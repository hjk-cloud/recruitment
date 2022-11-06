package edu.lnu.recruitment.modules.position.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Package: edu.lnu.recruitment.modules.position.entity
 * @ClassName: PositionDetails
 * @Author: huangjk
 * @CreateTime: 2022/11/6 21:00
 * @Description: 通过Redis获取职位附加信息，包含用户对职位的收藏状态、职位浏览量等
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PositionDetails {
    private Position position;
    private boolean isFavorite;
    private int viewCount;
}
