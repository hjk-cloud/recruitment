package edu.lnu.recruitment.modules.position.controller;

import cn.hutool.core.lang.Snowflake;
import edu.lnu.recruitment.common.utils.R;
import edu.lnu.recruitment.modules.position.entity.Position;
import edu.lnu.recruitment.modules.position.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/addPosition")
    public R addPosition(@RequestBody Position position) {
        boolean isSuccess = positionService.save(position);
        return R.ok("status:" + isSuccess);
    }
}
