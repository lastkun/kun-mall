package com.kunmall.order.dao;

import com.kunmall.order.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 * 
 * @author kun
 * @email ghk_1998@163.com
 * @date 2021-02-24 16:25:20
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {
	
}
