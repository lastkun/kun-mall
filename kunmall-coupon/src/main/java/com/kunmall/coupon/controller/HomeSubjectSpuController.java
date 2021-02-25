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

import com.kunmall.coupon.entity.HomeSubjectSpuEntity;
import com.kunmall.coupon.service.HomeSubjectSpuService;
import com.kunmall.common.utils.PageUtils;


/**
 * 专题商品
 *
 * @author kun
 * @email ghk_1998@163.com
 * @date 2021-02-24 16:18:02
 */
@RestController
@RequestMapping("coupon/homesubjectspu")
public class HomeSubjectSpuController {
    @Autowired
    private HomeSubjectSpuService homeSubjectSpuService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:homesubjectspu:list")
    public CommonResult list(@RequestParam Map<String, Object> params){
        PageUtils page = homeSubjectSpuService.queryPage(params);

        return CommonResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:homesubjectspu:info")
    public CommonResult info(@PathVariable("id") Long id){
		HomeSubjectSpuEntity homeSubjectSpu = homeSubjectSpuService.getById(id);

        return CommonResult.ok().put("homeSubjectSpu", homeSubjectSpu);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:homesubjectspu:save")
    public CommonResult save(@RequestBody HomeSubjectSpuEntity homeSubjectSpu){
		homeSubjectSpuService.save(homeSubjectSpu);

        return CommonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("coupon:homesubjectspu:update")
    public CommonResult update(@RequestBody HomeSubjectSpuEntity homeSubjectSpu){
		homeSubjectSpuService.updateById(homeSubjectSpu);

        return CommonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:homesubjectspu:delete")
    public CommonResult delete(@RequestBody Long[] ids){
		homeSubjectSpuService.removeByIds(Arrays.asList(ids));

        return CommonResult.ok();
    }

}
