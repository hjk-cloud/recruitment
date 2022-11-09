package edu.lnu.recruitment.modules.position.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.lnu.recruitment.common.utils.RedisUtil;
import edu.lnu.recruitment.modules.position.entity.Favorite;
import edu.lnu.recruitment.modules.position.entity.Position;
import edu.lnu.recruitment.modules.position.mapper.FavoriteMapper;
import edu.lnu.recruitment.modules.position.mapper.PositionMapper;
import edu.lnu.recruitment.modules.position.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FavoriteServiceImpl extends ServiceImpl<FavoriteMapper, Favorite> implements FavoriteService {
    @Autowired
    private PositionMapper positionMapper;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean save(Favorite favorite) {
        redisUtil.lSet("favorite_" + favorite.getCandidateId(), favorite.getPositionId());
        return true;
    }
    @Override
    public List<Position> allFavoriteOfCandidateId(String candidateId) {
        List<Object> list = redisUtil.lGet("favorite_" + candidateId, 0, -1);
        List<Position> positionList = new ArrayList<>();
        for(Object id: list) {
            String idStr = String.valueOf(id);
            Position position = (Position) redisUtil.get("position_" + idStr);
            if (position == null) {
                position = positionMapper.selectById(idStr);
            }
            positionList.add(position);
        }
        return positionList;
    }

    @Override
    public boolean deleteByCandidateIdPositionId(String candidateId, String positionId) {
        return redisUtil.lRemove("favorite_" + candidateId, 0, Long.valueOf(positionId)) > 0;
    }

    @Override
    public int existPositionId(Favorite favorite) {
        Long candidateId = favorite.getCandidateId();
        Long positionId = favorite.getPositionId();
        List<Object> list = redisUtil.lGet("favorite_" + candidateId, 0, -1);
        return list.contains(positionId) ? 1 : 0;
    }

    @Scheduled(cron = "5 * * * * *")
    protected void saveToDatabase() {
        System.out.println(new Date());
        /*TODO 将Redis中的收藏数据写入MySQL表中
         *   1.操作Redis，根据用户id获取职位列表
         *   2.调用favoriteMapper方法，将用户id与每个职位id写入数据库
         * */
    }
}
