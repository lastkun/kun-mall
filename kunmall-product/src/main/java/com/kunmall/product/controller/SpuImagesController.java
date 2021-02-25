package com.kunmall.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kunmall.product.entity.SpuImagesEntity;
import com.kunmall.product.service.SpuImagesService;
import com.kunmall.common.utils.PageUtils;
import com.kunmall.common.utils.CommonResult;



/**
 * spu图片
 *
 * @author kun
 * @email ghk_1998@163.com
 * @date 2021-02-24 16:27:14
 */
@RestController
@RequestMapping("product/spuimages")
public class SpuImagesController {
    @Autowired
    private SpuImagesService spuImagesService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:spuimages:list")
    public CommonResult list(@RequestParam Map<String, Object> params){
        PageUtils page = spuImagesService.queryPage(params);

        return CommonResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:spuimages:info")
    public CommonResult info(@PathVariable("id") Long id){
		SpuImagesEntity spuImages = spuImagesService.getById(id);

        return CommonResult.ok().put("spuImages", spuImages);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:spuimages:save")
    public CommonResult save(@RequestBody SpuImagesEntity spuImages){
		spuImagesService.save(spuImages);

        return CommonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:spuimages:update")
    public CommonResult update(@RequestBody SpuImagesEntity spuImages){
		spuImagesService.updateById(spuImages);

        return CommonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:spuimages:delete")
    public CommonResult delete(@RequestBody Long[] ids){
		spuImagesService.removeByIds(Arrays.asList(ids));

        return CommonResult.ok();
    }

}
