package com.mmall.service;

import com.mmall.common.ServerResponse;

/**
 * @author yejunyu
 * @date 2018/3/8.
 */
public interface ICartService {

    ServerResponse add(Integer userId, Integer count, Integer productId);
}
