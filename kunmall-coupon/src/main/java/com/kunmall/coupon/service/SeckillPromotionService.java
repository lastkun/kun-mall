package com.kunmall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kunmall.common.utils.PageUtils;
import com.kunmall.coupon.entity.SeckillPromotionEntity;

import java.util.Map;

/**
 * 秒杀活动
 *
 * @author kun
 * @email ghk_1998@163.com
 * @date 2021-02-24 16:18:02
 */
public interface SeckillPromotionService extends IService<SeckillPromotionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

