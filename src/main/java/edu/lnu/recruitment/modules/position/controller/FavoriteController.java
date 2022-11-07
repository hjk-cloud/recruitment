package edu.lnu.recruitment.modules.position.controller;

import edu.lnu.recruitment.common.utils.R;
import edu.lnu.recruitment.modules.position.entity.Favorite;
import edu.lnu.recruitment.modules.position.service.FavoriteService;
import edu.lnu.recruitment.modules.position.entity.Position;
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
        if(favoriteService.existPositionId(favorite) > 0) {
            return R.error("已收藏该职位");
        }else {
            favoriteService.save(favorite);
            return R.ok("收藏成功");
        }
    }

    /**
     * 删除收藏
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public R deleteCollect(String candidateId, String positionId){
        boolean flag = favoriteService.deleteByCandidateIdPositionId(candidateId, positionId);
        return flag? R.ok("已取消收藏"): R.error("删除失败");
    }

    /**
     * 查询某个用户的所有收藏
     */
    @RequestMapping(value = "/queryFavorite",method = RequestMethod.GET)
    public Object allCollect(String candidateId){
        List<Position> list = favoriteService.allFavoriteOfCandidateId(candidateId);
        return R.ok().put("list", list);
    }

}
