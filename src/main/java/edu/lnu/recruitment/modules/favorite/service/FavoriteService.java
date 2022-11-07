package edu.lnu.recruitment.modules.favorite.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.lnu.recruitment.modules.favorite.entity.Favorite;
import edu.lnu.recruitment.modules.position.entity.Position;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FavoriteService extends IService<Favorite> {

    boolean save(Favorite favorite);
    /**
     * 根据用户id和职位id删除
     */
    boolean deleteByCandidateIdPositionId(Long candidateId, Long positionId);

    /**
     * 查询某个用户的所有收藏
     */
    List<Position> allFavoriteOfCandidateId(Long candidateId);


    /**
     * 查询某个用户是否已经收藏了某个职位
     */
    int existPositionId(@Param("candidateId") Long candidateId, @Param("positionId") Long positionId);
}
