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

import com.kunmall.coupon.entity.SkuLadderEntity;
import com.kunmall.coupon.service.SkuLadderService;
import com.kunmall.common.utils.PageUtils;


/**
 * 商品阶梯价格
 *
 * @author kun
 * @email ghk_1998@163.com
 * @date 2021-02-24 16:18:02
 */
@RestController
@RequestMapping("coupon/skuladder")
public class SkuLadderController {
    @Autowired
    private SkuLadderService skuLadderService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:skuladder:list")
    public CommonResult list(@RequestParam Map<String, Object> params){
        PageUtils page = skuLadderService.queryPage(params);

        return CommonResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:skuladder:info")
    public CommonResult info(@PathVariable("id") Long id){
		SkuLadderEntity skuLadder = skuLadderService.getById(id);

        return CommonResult.ok().put("skuLadder", skuLadder);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:skuladder:save")
    public CommonResult save(@RequestBody SkuLadderEntity skuLadder){
		skuLadderService.save(skuLadder);

        return CommonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("coupon:skuladder:update")
    public CommonResult update(@RequestBody SkuLadderEntity skuLadder){
		skuLadderService.updateById(skuLadder);

        return CommonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:skuladder:delete")
    public CommonResult delete(@RequestBody Long[] ids){
		skuLadderService.removeByIds(Arrays.asList(ids));

        return CommonResult.ok();
    }

}
