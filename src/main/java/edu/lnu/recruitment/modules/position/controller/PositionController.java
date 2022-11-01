package edu.lnu.recruitment.modules.position.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.lnu.recruitment.common.utils.R;
import edu.lnu.recruitment.modules.position.entity.Position;
import edu.lnu.recruitment.modules.position.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Package: edu.lnu.recruitment.modules.position.controller
 * @ClassName: PositionController
 * @Author: huangjk
 * @CreateTime: 2022/10/11 20:59
 * @Description:
 */
@RestController
@RequestMapping("/app/position")
@CrossOrigin
public class PositionController {
    @Autowired
    private PositionService positionService;

    @RequestMapping("/save")
    public R save(@RequestBody Position position) {
        boolean isSuccess = positionService.save(position);
        return R.ok("status:" + isSuccess);
    }

    @RequestMapping("/list")
    public R list(@RequestBody Map<String, Object> params) {
        List<Position> list = positionService.queryPage(params);
        return R.ok().put("list", list);
    }

    @RequestMapping("/list/queryByConditions")
    public R queryByConditions(@RequestBody Map<String, Object> params) {
        List<Position> list = positionService.queryPageByConditions(params);
        return R.ok().put("pageNum", params.get("page")).put("list", list);
    }

    @RequestMapping("/queryById")
    public R queryById(@RequestBody Map<String, Object> params) {
        Position position = positionService.queryById(params);
        return R.ok().put("position", position);
    }

    @RequestMapping("/queryHistory")
    public R queryHistory(long candidateId) {
        List<Object> list = positionService.queryHistory(candidateId);
        return R.ok().put("list", list);
    }

    @RequestMapping("/delete")
    public R delete(String positionId) {

        boolean flag = positionService.delete(Long.valueOf(positionId));
        return flag? R.ok(): R.error("删除失败");
    }
    @RequestMapping("/update")
    public R update(@RequestBody Position position) {

        boolean flag = positionService.update(position);
        return flag? R.ok(): R.error("更新失败");
    }
    @RequestMapping("/list/queryByRecruiterId")
    public R queryByRecruiterId(@RequestBody Map<String, Object> params){
        List<Position> list= positionService.queryByRecruiterId(params);
        return R.ok().put("pageNum", params.get("page")).put("list", list);
    }
}
