package com.mmall.service;

import com.mmall.common.ServerResponse;

/**
 * @author yejunyu
 * @date 18-3-7.
 */
public interface ICategoryService {

    ServerResponse addCategory(String categoryName, Integer parentId);

    ServerResponse updateCategoryName(Integer categoryId, String categoryName);
}
