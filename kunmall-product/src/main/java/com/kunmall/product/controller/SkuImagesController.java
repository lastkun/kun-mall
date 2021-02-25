package com.kunmall.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kunmall.product.entity.SkuImagesEntity;
import com.kunmall.product.service.SkuImagesService;
import com.kunmall.common.utils.PageUtils;
import com.kunmall.common.utils.CommonResult;



/**
 * sku图片
 *
 * @author kun
 * @email ghk_1998@163.com
 * @date 2021-02-24 16:27:14
 */
@RestController
@RequestMapping("product/skuimages")
public class SkuImagesController {
    @Autowired
    private SkuImagesService skuImagesService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:skuimages:list")
    public CommonResult list(@RequestParam Map<String, Object> params){
        PageUtils page = skuImagesService.queryPage(params);

        return CommonResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:skuimages:info")
    public CommonResult info(@PathVariable("id") Long id){
		SkuImagesEntity skuImages = skuImagesService.getById(id);

        return CommonResult.ok().put("skuImages", skuImages);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:skuimages:save")
    public CommonResult save(@RequestBody SkuImagesEntity skuImages){
		skuImagesService.save(skuImages);

        return CommonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:skuimages:update")
    public CommonResult update(@RequestBody SkuImagesEntity skuImages){
		skuImagesService.updateById(skuImages);

        return CommonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:skuimages:delete")
    public CommonResult delete(@RequestBody Long[] ids){
		skuImagesService.removeByIds(Arrays.asList(ids));

        return CommonResult.ok();
    }

}
