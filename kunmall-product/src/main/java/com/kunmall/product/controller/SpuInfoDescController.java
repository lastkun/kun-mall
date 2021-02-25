package com.kunmall.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kunmall.product.entity.SpuInfoDescEntity;
import com.kunmall.product.service.SpuInfoDescService;
import com.kunmall.common.utils.PageUtils;
import com.kunmall.common.utils.CommonResult;



/**
 * spu信息介绍
 *
 * @author kun
 * @email ghk_1998@163.com
 * @date 2021-02-24 16:27:14
 */
@RestController
@RequestMapping("product/spuinfodesc")
public class SpuInfoDescController {
    @Autowired
    private SpuInfoDescService spuInfoDescService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:spuinfodesc:list")
    public CommonResult list(@RequestParam Map<String, Object> params){
        PageUtils page = spuInfoDescService.queryPage(params);

        return CommonResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{spuId}")
    //@RequiresPermissions("product:spuinfodesc:info")
    public CommonResult info(@PathVariable("spuId") Long spuId){
		SpuInfoDescEntity spuInfoDesc = spuInfoDescService.getById(spuId);

        return CommonResult.ok().put("spuInfoDesc", spuInfoDesc);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:spuinfodesc:save")
    public CommonResult save(@RequestBody SpuInfoDescEntity spuInfoDesc){
		spuInfoDescService.save(spuInfoDesc);

        return CommonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:spuinfodesc:update")
    public CommonResult update(@RequestBody SpuInfoDescEntity spuInfoDesc){
		spuInfoDescService.updateById(spuInfoDesc);

        return CommonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:spuinfodesc:delete")
    public CommonResult delete(@RequestBody Long[] spuIds){
		spuInfoDescService.removeByIds(Arrays.asList(spuIds));

        return CommonResult.ok();
    }

}
