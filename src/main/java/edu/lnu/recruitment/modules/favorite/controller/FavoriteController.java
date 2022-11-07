package edu.lnu.recruitment.modules.favorite.controller;

import com.alibaba.fastjson.JSONObject;
import edu.lnu.recruitment.common.utils.R;
import edu.lnu.recruitment.modules.delivery.entity.Delivery;
import edu.lnu.recruitment.modules.favorite.entity.Favorite;
import edu.lnu.recruitment.modules.favorite.service.FavoriteService;
import edu.lnu.recruitment.modules.position.entity.Position;
import edu.lnu.recruitment.modules.position.service.PositionService;
import org.apache.http.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/app/favorite")
@CrossOrigin
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;
    /**
     * 添加收藏
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public R save(@RequestBody Favorite favorite){
        Long candidateId = Long.valueOf(favorite.getCandidateId());
        Long positionId= Long.valueOf(favorite.getPositionId());
//        System.out.println(candidateId+" "+positionId);
        if(favoriteService.existPositionId(candidateId,positionId)>0){
            return R.error("已收藏该职位");
        }
        else {
            boolean isSuccess = favoriteService.save(favorite);
            return  R.ok("status:" + isSuccess);
        }
    }

    /**
     * 删除收藏
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public R deleteCollect(HttpServletRequest request){
        Long candidateId = Long.valueOf(request.getParameter("candidateId"));
        Long positionId= Long.valueOf(request.getParameter("positionId"));
        boolean flag = favoriteService.deleteByCandidateIdPositionId(candidateId,positionId);
        return flag? R.ok(): R.error("删除失败");
    }

    /**
     * 查询某个用户的所有收藏
     */
    @RequestMapping(value = "/queryFavorite",method = RequestMethod.GET)
    public Object allCollect(HttpServletRequest request){
        Long candidateId = Long.valueOf(request.getParameter("candidateId"));
        List<Position> list=favoriteService.allFavoriteOfCandidateId(candidateId);
        return R.ok().put("list", list);
    }

}
