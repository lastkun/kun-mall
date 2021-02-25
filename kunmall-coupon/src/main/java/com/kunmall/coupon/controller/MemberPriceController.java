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

import com.kunmall.coupon.entity.MemberPriceEntity;
import com.kunmall.coupon.service.MemberPriceService;
import com.kunmall.common.utils.PageUtils;


/**
 * 商品会员价格
 *
 * @author kun
 * @email ghk_1998@163.com
 * @date 2021-02-24 16:18:02
 */
@RestController
@RequestMapping("coupon/memberprice")
public class MemberPriceController {
    @Autowired
    private MemberPriceService memberPriceService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:memberprice:list")
    public CommonResult list(@RequestParam Map<String, Object> params){
        PageUtils page = memberPriceService.queryPage(params);

        return CommonResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:memberprice:info")
    public CommonResult info(@PathVariable("id") Long id){
		MemberPriceEntity memberPrice = memberPriceService.getById(id);

        return CommonResult.ok().put("memberPrice", memberPrice);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:memberprice:save")
    public CommonResult save(@RequestBody MemberPriceEntity memberPrice){
		memberPriceService.save(memberPrice);

        return CommonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("coupon:memberprice:update")
    public CommonResult update(@RequestBody MemberPriceEntity memberPrice){
		memberPriceService.updateById(memberPrice);

        return CommonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:memberprice:delete")
    public CommonResult delete(@RequestBody Long[] ids){
		memberPriceService.removeByIds(Arrays.asList(ids));

        return CommonResult.ok();
    }

}
