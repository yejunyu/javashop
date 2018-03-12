package com.mmall.service;

import com.mmall.common.ServerResponse;

/**
 * @author yejunyu
 * @date 18-3-12.
 */
public interface IOrderService {

    ServerResponse createOrder(Integer userId, Integer shippingId);
}
