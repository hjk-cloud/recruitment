package edu.lnu.recruitment.modules.delivery.controller;

import edu.lnu.recruitment.common.utils.R;
import edu.lnu.recruitment.modules.delivery.entity.Delivery;
import edu.lnu.recruitment.modules.delivery.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Package: edu.lnu.recruitment.modules.delivery.controller
 * @ClassName: DeliveryController
 * @Author: huangjk
 * @CreateTime: 2022/11/3 21:30
 * @Description:
 */
@RestController
@RequestMapping("/app/delivery")
@CrossOrigin
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    @RequestMapping("/queryByPositionId")
    public R queryByPositionId(@RequestBody Map<String, Object> params) {
        List<Delivery> list = deliveryService.queryByPositionId(params);
        return R.ok().put("list", list);
    }

    @RequestMapping("/queryByCandidateId")
    public R queryByCandidateId(@RequestBody Map<String, Object> params) {
        List<Delivery> list = deliveryService.queryByCandidateId(params);
        return R.ok().put("list", list);
    }

    @RequestMapping("/post")
    public R post(@RequestBody Delivery delivery) {
        boolean flag = deliveryService.save(delivery);
        return flag ? R.ok() : R.error("投递失败");
    }
}
