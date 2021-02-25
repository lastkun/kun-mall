package com.kunmall.ware.dao;

import com.kunmall.ware.entity.WareSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品库存
 * 
 * @author kun
 * @email ghk_1998@163.com
 * @date 2021-02-24 16:22:09
 */
@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity> {
	
}
