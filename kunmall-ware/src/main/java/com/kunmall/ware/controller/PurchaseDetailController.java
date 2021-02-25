package com.kunmall.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kunmall.ware.entity.PurchaseDetailEntity;
import com.kunmall.ware.service.PurchaseDetailService;
import com.kunmall.common.utils.PageUtils;
import com.kunmall.common.utils.CommonResult;



/**
 * 
 *
 * @author kun
 * @email ghk_1998@163.com
 * @date 2021-02-24 16:22:09
 */
@RestController
@RequestMapping("ware/purchasedetail")
public class PurchaseDetailController {
    @Autowired
    private PurchaseDetailService purchaseDetailService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:purchasedetail:list")
    public CommonResult list(@RequestParam Map<String, Object> params){
        PageUtils page = purchaseDetailService.queryPage(params);

        return CommonResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:purchasedetail:info")
    public CommonResult info(@PathVariable("id") Long id){
		PurchaseDetailEntity purchaseDetail = purchaseDetailService.getById(id);

        return CommonResult.ok().put("purchaseDetail", purchaseDetail);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:purchasedetail:save")
    public CommonResult save(@RequestBody PurchaseDetailEntity purchaseDetail){
		purchaseDetailService.save(purchaseDetail);

        return CommonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:purchasedetail:update")
    public CommonResult update(@RequestBody PurchaseDetailEntity purchaseDetail){
		purchaseDetailService.updateById(purchaseDetail);

        return CommonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:purchasedetail:delete")
    public CommonResult delete(@RequestBody Long[] ids){
		purchaseDetailService.removeByIds(Arrays.asList(ids));

        return CommonResult.ok();
    }

}
