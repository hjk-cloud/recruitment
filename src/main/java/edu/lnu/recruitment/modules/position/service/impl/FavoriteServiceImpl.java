package edu.lnu.recruitment.modules.position.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.lnu.recruitment.common.utils.RedisUtil;
import edu.lnu.recruitment.modules.position.entity.Favorite;
import edu.lnu.recruitment.modules.position.mapper.FavoriteMapper;
import edu.lnu.recruitment.modules.position.service.FavoriteService;
import edu.lnu.recruitment.modules.position.entity.Position;
import edu.lnu.recruitment.modules.position.mapper.PositionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public class FavoriteServiceImpl extends ServiceImpl<FavoriteMapper, Favorite> implements FavoriteService {
    @Autowired
    private FavoriteMapper favoriteMapper;
    @Autowired
    private PositionMapper positionMapper;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean save(Favorite favorite) {
        // cid favorite_123 [1, 2, 5]
        redisUtil.lSet("favorite_" + favorite.getCandidateId(), favorite.getPositionId());
        return true;
    }
    @Override
    public List<Position> allFavoriteOfCandidateId(String candidateId) {
        List<Object> list = redisUtil.lGet("favorite_" + candidateId, 0, -1);
        List<Position> positionList = new ArrayList<>();
        for(Object id: list) {
            positionList.add(positionMapper.selectById((Serializable) id));
        }
        return positionList;
    }

    @Override
    public boolean deleteByCandidateIdPositionId(String candidateId, String positionId) {
        redisUtil.lRemove("favorite_" + candidateId, 0L, positionId);
        return true;
    }

    @Override
    public int existPositionId(Favorite favorite) {
        Long candidateId = Long.valueOf(favorite.getCandidateId());
        Long positionId= Long.valueOf(favorite.getPositionId());
        List<Object> list = redisUtil.lGet("favorite_" + candidateId, 0, -1);
        return list.contains(positionId)? 1: 0;
    }
}
