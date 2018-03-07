package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Product;

/**
 * @author yejunyu
 * @date 18-3-7.
 */
public interface IProductService {

    ServerResponse saveAndUpdateProduct(Product product);

    ServerResponse updateSaleStatus(Integer productId, Integer status);

    ServerResponse manageProductDetail(Integer productId);
}