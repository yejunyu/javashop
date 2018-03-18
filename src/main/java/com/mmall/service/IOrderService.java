package com.mmall.service;

import com.mmall.common.ServerResponse;

import java.util.Map;

/**
 * @author yejunyu
 * @date 18-3-12.
 */
public interface IOrderService {

    ServerResponse pay(Long orderNo, Integer userId, String path);

    ServerResponse aliCallback(Map<String, String> params);

    ServerResponse createOrder(Integer userId, Integer shippingId);

    ServerResponse queryOrderPayStatus(Integer userId, Long orderNo);
}
