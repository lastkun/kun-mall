package com.kunmall.order.dao;

import com.kunmall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author kun
 * @email ghk_1998@163.com
 * @date 2021-02-24 16:25:20
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
