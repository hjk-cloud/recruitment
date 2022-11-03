package edu.lnu.recruitment.modules.delivery.controller;

import edu.lnu.recruitment.common.utils.R;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/queryByPositionId")
    public R queryByPositionId() {

        return R.ok();
    }

    @RequestMapping("/record")
    public R record() {
        return R.ok();
    }

    @RequestMapping("/post")
    public R post() {
        return R.ok();
    }
}
