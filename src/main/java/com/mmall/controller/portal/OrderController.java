package com.mmall.controller.portal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yejunyu
 * @date 18-3-12.
 */
@Controller
@RequestMapping("order")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

//    @Autowired
//    private IOrderService iOrderService;

//    @RequestMapping("create.do")
//    @ResponseBody
//    public ServerResponse create(HttpSession session, Integer shippingId) {
//        User user = (User) session.getAttribute(Const.CURRENT_USER);
//        if (null == user) {
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
//        }
//    }
}
