package com.kunmall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kunmall.common.utils.PageUtils;
import com.kunmall.order.entity.RefundInfoEntity;

import java.util.Map;

/**
 * 退款信息
 *
 * @author kun
 * @email ghk_1998@163.com
 * @date 2021-02-24 16:25:20
 */
public interface RefundInfoService extends IService<RefundInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

