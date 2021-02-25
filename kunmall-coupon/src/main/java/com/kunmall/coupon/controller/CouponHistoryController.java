package com.kunmall.coupon.controller;

import java.util.Arrays;
import java.util.Map;

import com.kunmall.common.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kunmall.coupon.entity.CouponHistoryEntity;
import com.kunmall.coupon.service.CouponHistoryService;
import com.kunmall.common.utils.PageUtils;


/**
 * 优惠券领取历史记录
 *
 * @author kun
 * @email ghk_1998@163.com
 * @date 2021-02-24 16:18:02
 */
@RestController
@RequestMapping("coupon/couponhistory")
public class CouponHistoryController {
    @Autowired
    private CouponHistoryService couponHistoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:couponhistory:list")
    public CommonResult list(@RequestParam Map<String, Object> params){
        PageUtils page = couponHistoryService.queryPage(params);

        return CommonResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:couponhistory:info")
    public CommonResult info(@PathVariable("id") Long id){
		CouponHistoryEntity couponHistory = couponHistoryService.getById(id);

        return CommonResult.ok().put("couponHistory", couponHistory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:couponhistory:save")
    public CommonResult save(@RequestBody CouponHistoryEntity couponHistory){
		couponHistoryService.save(couponHistory);

        return CommonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("coupon:couponhistory:update")
    public CommonResult update(@RequestBody CouponHistoryEntity couponHistory){
		couponHistoryService.updateById(couponHistory);

        return CommonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:couponhistory:delete")
    public CommonResult delete(@RequestBody Long[] ids){
		couponHistoryService.removeByIds(Arrays.asList(ids));

        return CommonResult.ok();
    }

}
