package com.kunmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kunmall.common.utils.PageUtils;
import com.kunmall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> listWithTree();

    /**
     * 逻辑删除
     * @param asList
     */
    void deleteByLogic(List<Long> asList);

    String getCategoryPath(Long catelogId);
}

