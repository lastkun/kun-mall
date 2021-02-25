package com.kunmall.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kunmall.product.entity.SpuCommentEntity;
import com.kunmall.product.service.SpuCommentService;
import com.kunmall.common.utils.PageUtils;
import com.kunmall.common.utils.CommonResult;



/**
 * 商品评价
 *
 * @author kun
 * @email ghk_1998@163.com
 * @date 2021-02-24 16:27:14
 */
@RestController
@RequestMapping("product/spucomment")
public class SpuCommentController {
    @Autowired
    private SpuCommentService spuCommentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:spucomment:list")
    public CommonResult list(@RequestParam Map<String, Object> params){
        PageUtils page = spuCommentService.queryPage(params);

        return CommonResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:spucomment:info")
    public CommonResult info(@PathVariable("id") Long id){
		SpuCommentEntity spuComment = spuCommentService.getById(id);

        return CommonResult.ok().put("spuComment", spuComment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:spucomment:save")
    public CommonResult save(@RequestBody SpuCommentEntity spuComment){
		spuCommentService.save(spuComment);

        return CommonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:spucomment:update")
    public CommonResult update(@RequestBody SpuCommentEntity spuComment){
		spuCommentService.updateById(spuComment);

        return CommonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:spucomment:delete")
    public CommonResult delete(@RequestBody Long[] ids){
		spuCommentService.removeByIds(Arrays.asList(ids));

        return CommonResult.ok();
    }

}
