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

import com.kunmall.coupon.entity.CouponEntity;
import com.kunmall.coupon.service.CouponService;
import com.kunmall.common.utils.PageUtils;


/**
 * 优惠券信息
 *
 * @author kun
 * @email ghk_1998@163.com
 * @date 2021-02-24 16:18:02
 */
@RestController
@RequestMapping("coupon/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:coupon:list")
    public CommonResult list(@RequestParam Map<String, Object> params){
        PageUtils page = couponService.queryPage(params);

        return CommonResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:coupon:info")
    public CommonResult info(@PathVariable("id") Long id){
		CouponEntity coupon = couponService.getById(id);

        return CommonResult.ok().put("coupon", coupon);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:coupon:save")
    public CommonResult save(@RequestBody CouponEntity coupon){
		couponService.save(coupon);

        return CommonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("coupon:coupon:update")
    public CommonResult update(@RequestBody CouponEntity coupon){
		couponService.updateById(coupon);

        return CommonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:coupon:delete")
    public CommonResult delete(@RequestBody Long[] ids){
		couponService.removeByIds(Arrays.asList(ids));

        return CommonResult.ok();
    }

}
