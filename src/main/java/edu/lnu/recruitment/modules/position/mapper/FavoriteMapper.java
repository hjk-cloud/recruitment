package edu.lnu.recruitment.modules.position.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.lnu.recruitment.modules.position.entity.Favorite;
import edu.lnu.recruitment.modules.position.entity.Position;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FavoriteMapper extends BaseMapper<Favorite> {
    boolean deleteByCandidateIdPositionId(Long candidateId, Long positionId);

    List<Position> allFavoriteOfCandidateId(Long candidateId);

    int  existPositionId(@Param("candidateId") Long candidateId, @Param("positionId") Long positionId);
}
