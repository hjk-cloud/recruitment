package edu.lnu.recruitment.modules.favorite.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.lnu.recruitment.modules.favorite.entity.Favorite;
import edu.lnu.recruitment.modules.position.entity.Position;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface FavoriteMapper extends BaseMapper<Favorite> {
    boolean deleteByCandidateIdPositionId(Long candidateId, Long positionId);

    List<Position> allFavoriteOfCandidateId(Long candidateId);

    int  existPositionId(@Param("candidateId") Long candidateId, @Param("positionId") Long positionId);
}
