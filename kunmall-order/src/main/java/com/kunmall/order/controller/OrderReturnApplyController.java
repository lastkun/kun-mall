package com.kunmall.order.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kunmall.order.entity.OrderReturnApplyEntity;
import com.kunmall.order.service.OrderReturnApplyService;
import com.kunmall.common.utils.PageUtils;
import com.kunmall.common.utils.CommonResult;



/**
 * 订单退货申请
 *
 * @author kun
 * @email ghk_1998@163.com
 * @date 2021-02-24 16:25:20
 */
@RestController
@RequestMapping("order/orderreturnapply")
public class OrderReturnApplyController {
    @Autowired
    private OrderReturnApplyService orderReturnApplyService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("order:orderreturnapply:list")
    public CommonResult list(@RequestParam Map<String, Object> params){
        PageUtils page = orderReturnApplyService.queryPage(params);

        return CommonResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("order:orderreturnapply:info")
    public CommonResult info(@PathVariable("id") Long id){
		OrderReturnApplyEntity orderReturnApply = orderReturnApplyService.getById(id);

        return CommonResult.ok().put("orderReturnApply", orderReturnApply);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("order:orderreturnapply:save")
    public CommonResult save(@RequestBody OrderReturnApplyEntity orderReturnApply){
		orderReturnApplyService.save(orderReturnApply);

        return CommonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("order:orderreturnapply:update")
    public CommonResult update(@RequestBody OrderReturnApplyEntity orderReturnApply){
		orderReturnApplyService.updateById(orderReturnApply);

        return CommonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("order:orderreturnapply:delete")
    public CommonResult delete(@RequestBody Long[] ids){
		orderReturnApplyService.removeByIds(Arrays.asList(ids));

        return CommonResult.ok();
    }

}
