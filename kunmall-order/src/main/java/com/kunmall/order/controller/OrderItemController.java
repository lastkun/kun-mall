package com.kunmall.order.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kunmall.order.entity.OrderItemEntity;
import com.kunmall.order.service.OrderItemService;
import com.kunmall.common.utils.PageUtils;
import com.kunmall.common.utils.CommonResult;



/**
 * 订单项信息
 *
 * @author kun
 * @email ghk_1998@163.com
 * @date 2021-02-24 16:25:20
 */
@RestController
@RequestMapping("order/orderitem")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("order:orderitem:list")
    public CommonResult list(@RequestParam Map<String, Object> params){
        PageUtils page = orderItemService.queryPage(params);

        return CommonResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("order:orderitem:info")
    public CommonResult info(@PathVariable("id") Long id){
		OrderItemEntity orderItem = orderItemService.getById(id);

        return CommonResult.ok().put("orderItem", orderItem);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("order:orderitem:save")
    public CommonResult save(@RequestBody OrderItemEntity orderItem){
		orderItemService.save(orderItem);

        return CommonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("order:orderitem:update")
    public CommonResult update(@RequestBody OrderItemEntity orderItem){
		orderItemService.updateById(orderItem);

        return CommonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("order:orderitem:delete")
    public CommonResult delete(@RequestBody Long[] ids){
		orderItemService.removeByIds(Arrays.asList(ids));

        return CommonResult.ok();
    }

}
