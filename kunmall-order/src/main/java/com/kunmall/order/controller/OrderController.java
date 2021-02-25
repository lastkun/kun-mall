package com.kunmall.order.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kunmall.order.entity.OrderEntity;
import com.kunmall.order.service.OrderService;
import com.kunmall.common.utils.PageUtils;
import com.kunmall.common.utils.CommonResult;



/**
 * 订单
 *
 * @author kun
 * @email ghk_1998@163.com
 * @date 2021-02-24 16:25:20
 */
@RestController
@RequestMapping("order/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("order:order:list")
    public CommonResult list(@RequestParam Map<String, Object> params){
        PageUtils page = orderService.queryPage(params);

        return CommonResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("order:order:info")
    public CommonResult info(@PathVariable("id") Long id){
		OrderEntity order = orderService.getById(id);

        return CommonResult.ok().put("order", order);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("order:order:save")
    public CommonResult save(@RequestBody OrderEntity order){
		orderService.save(order);

        return CommonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("order:order:update")
    public CommonResult update(@RequestBody OrderEntity order){
		orderService.updateById(order);

        return CommonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("order:order:delete")
    public CommonResult delete(@RequestBody Long[] ids){
		orderService.removeByIds(Arrays.asList(ids));

        return CommonResult.ok();
    }

}
