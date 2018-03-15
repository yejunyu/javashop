package com.mmall.service;

import com.mmall.common.ServerResponse;

/**
 * @author yejunyu
 * @date 18-3-12.
 */
public interface IOrderService {

    ServerResponse pay(Long orderNo,Integer userId, String path);

    ServerResponse createOrder(Integer userId, Integer shippingId);
}
