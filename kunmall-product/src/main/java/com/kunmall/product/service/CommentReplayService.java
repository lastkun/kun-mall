package com.kunmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kunmall.common.utils.PageUtils;
import com.kunmall.product.entity.CommentReplayEntity;

import java.util.Map;

/**
 * 商品评价回复关系
 *
 * @author kun
 * @email ghk_1998@163.com
 * @date 2021-02-24 16:27:14
 */
public interface CommentReplayService extends IService<CommentReplayEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

