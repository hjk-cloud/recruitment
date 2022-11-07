package edu.lnu.recruitment.modules.favorite.service.impl;

import cn.hutool.core.lang.Snowflake;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.lnu.recruitment.modules.favorite.entity.Favorite;
import edu.lnu.recruitment.modules.favorite.mapper.FavoriteMapper;
import edu.lnu.recruitment.modules.favorite.service.FavoriteService;
import edu.lnu.recruitment.modules.position.entity.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteServiceImpl extends ServiceImpl<FavoriteMapper, Favorite> implements FavoriteService {
    @Autowired
    private FavoriteMapper favoriteMapper;
    @Override
    public boolean save(Favorite favorite) {
        favorite.setId(new Snowflake(0, 1).nextId());
       favoriteMapper.insert(favorite);
        return true;
    }
    @Override
    public boolean deleteByCandidateIdPositionId(Long candidateId, Long positionId) {

        return favoriteMapper.deleteByCandidateIdPositionId(candidateId,positionId);
    }

    @Override
    public List<Position> allFavoriteOfCandidateId(Long candidateId) {

      return favoriteMapper.allFavoriteOfCandidateId(candidateId);
    }

    @Override
    public int existPositionId(Long candidateId, Long positionId) {

        return favoriteMapper.existPositionId(candidateId,positionId);
    }
}
