package com.kunmall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kunmall.common.utils.PageUtils;
import com.kunmall.ware.entity.PurchaseEntity;

import java.util.Map;

/**
 * 采购信息
 *
 * @author kun
 * @email ghk_1998@163.com
 * @date 2021-02-24 16:22:09
 */
public interface PurchaseService extends IService<PurchaseEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

