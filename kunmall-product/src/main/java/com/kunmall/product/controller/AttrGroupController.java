package com.kunmall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageHelper;
import com.kunmall.common.utils.CommonPage;
import com.kunmall.product.model.AttrGroupModel;
import com.kunmall.product.service.CategoryService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.kunmall.product.entity.AttrGroupEntity;
import com.kunmall.product.service.AttrGroupService;
import com.kunmall.common.utils.PageUtils;
import com.kunmall.common.utils.CommonResult;



/**
 * 属性分组
 *
 * @author kun
 * @email ghk_1998@163.com
 * @date 2021-02-24 16:27:15
 */
@RestController
@RequestMapping("product/attrgroup")
public class AttrGroupController {
    @Autowired
    private AttrGroupService attrGroupService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 列表
     */
    @RequestMapping(value ="/list", method = RequestMethod.POST)
    public CommonResult list(@RequestBody AttrGroupModel model){
        PageHelper.startPage(model.getPageNum(), model.getPageSize());
        List<AttrGroupEntity> attrGroupEntities = attrGroupService.queryPage(model);
        CommonPage<AttrGroupEntity> page = CommonPage.restPage(attrGroupEntities);
        return CommonResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrGroupId}")
    public CommonResult info(@PathVariable("attrGroupId") Long attrGroupId){
		AttrGroupEntity attrGroup = attrGroupService.getById(attrGroupId);
        Long catelogId = attrGroup.getCatelogId();
        if(catelogId != null){
            String categoryPath = categoryService.getCategoryPath(catelogId);
            attrGroup.setCatelogPath(categoryPath);
        }
        return CommonResult.ok().put("attrGroup", attrGroup);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:attrgroup:save")
    public CommonResult save(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.save(attrGroup);

        return CommonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:attrgroup:update")
    public CommonResult update(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.updateById(attrGroup);

        return CommonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:attrgroup:delete")
    public CommonResult delete(@RequestBody Long[] attrGroupIds){
		attrGroupService.removeByIds(Arrays.asList(attrGroupIds));

        return CommonResult.ok();
    }

}
