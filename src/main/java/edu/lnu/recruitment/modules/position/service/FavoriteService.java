package edu.lnu.recruitment.modules.position.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.lnu.recruitment.modules.position.entity.Favorite;
import edu.lnu.recruitment.modules.position.entity.Position;

import java.util.List;

public interface FavoriteService extends IService<Favorite> {

    boolean save(Favorite favorite);
    /**
     * 根据用户id和职位id删除
     */
    boolean deleteByCandidateIdPositionId(String candidateId, String positionId);

    /**
     * 查询某个用户的所有收藏
     */
    List<Position> allFavoriteOfCandidateId(String candidateId);


    /**
     * 查询某个用户是否已经收藏了某个职位
     */
    int existPositionId(Favorite favorite);
}
