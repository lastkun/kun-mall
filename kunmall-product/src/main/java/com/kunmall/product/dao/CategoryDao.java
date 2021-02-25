package com.kunmall.product.dao;

import com.kunmall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author kun
 * @email ghk_1998@163.com
 * @date 2021-02-24 16:27:15
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
