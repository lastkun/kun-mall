package com.kunmall.product.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kunmall.product.entity.BrandEntity;
import com.kunmall.product.service.BrandService;
import com.kunmall.common.utils.PageUtils;
import com.kunmall.common.utils.CommonResult;



/**
 * 品牌
 *
 * @author kun
 * @email ghk_1998@163.com
 * @date 2021-02-24 16:27:15
 */
@RestController
@RequestMapping("product/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:brand:list")
    public CommonResult list(@RequestParam Map<String, Object> params){
        PageUtils page = brandService.queryPage(params);

        return CommonResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{brandId}")
    //@RequiresPermissions("product:brand:info")
    public CommonResult info(@PathVariable("brandId") Long brandId){
		BrandEntity brand = brandService.getById(brandId);

        return CommonResult.ok().put("brand", brand);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public CommonResult save(@RequestBody @Validated BrandEntity brand){
        brandService.saveOrUpdate(brand);
        return CommonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:brand:update")
    public CommonResult update(@RequestBody BrandEntity brand){
		brandService.updateById(brand);

        return CommonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:brand:delete")
    public CommonResult delete(@RequestBody Long[] brandIds){
		brandService.removeByIds(Arrays.asList(brandIds));

        return CommonResult.ok();
    }

}
