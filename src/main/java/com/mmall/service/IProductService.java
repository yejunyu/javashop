package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Product;
import com.mmall.vo.ProductDetailVo;

/**
 * @author yejunyu
 * @date 18-3-7.
 */
public interface IProductService {

    ServerResponse saveAndUpdateProduct(Product product);

    ServerResponse updateSaleStatus(Integer productId, Integer status);

    ServerResponse<ProductDetailVo> manageProductDetail(Integer productId);

    ServerResponse<PageInfo> getProductList(int pageNum, int pageSize);

    ServerResponse productSearch(String productName, Integer productId, int pageNum, int pageSize);
}
