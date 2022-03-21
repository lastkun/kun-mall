package com.kunmall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kunmall.product.entity.CategoryEntity;
import com.kunmall.product.service.CategoryService;
import com.kunmall.common.utils.PageUtils;
import com.kunmall.common.utils.CommonResult;



/**
 * 商品三级分类
 *
 * @author kun
 * @email ghk_1998@163.com
 * @date 2021-02-24 16:27:15
 */
@RestController
@RequestMapping("product/category")
@Api("商品分类")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 得到三级菜单树
     * @return
     */
    @RequestMapping("/list/tree")
    public CommonResult getMenuTree(){
        List<CategoryEntity> menu = categoryService.listWithTree();
        return CommonResult.ok().put("data",menu);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:category:list")
    public CommonResult list(@RequestParam Map<String, Object> params){
        PageUtils page = categoryService.queryPage(params);

        return CommonResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    //@RequiresPermissions("product:category:info")
    public CommonResult info(@PathVariable("catId") Long catId){
		CategoryEntity category = categoryService.getById(catId);

        return CommonResult.ok().put("category", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:category:save")
    public CommonResult save(@RequestBody CategoryEntity category){
		categoryService.save(category);

        return CommonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:category:update")
    public CommonResult update(@RequestBody CategoryEntity category){
		categoryService.updateById(category);

        return CommonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public CommonResult delete(@RequestBody Long[] catIds){
		//categoryService.removeByIds(Arrays.asList(catIds));
        categoryService.deleteByLogic(Arrays.asList(catIds));
        return CommonResult.ok();
    }

}
