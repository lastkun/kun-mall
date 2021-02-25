package com.kunmall.ware.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kunmall.ware.entity.WareOrderTaskDetailEntity;
import com.kunmall.ware.service.WareOrderTaskDetailService;
import com.kunmall.common.utils.PageUtils;
import com.kunmall.common.utils.CommonResult;



/**
 * 库存工作单
 *
 * @author kun
 * @email ghk_1998@163.com
 * @date 2021-02-24 16:22:09
 */
@RestController
@RequestMapping("ware/wareordertaskdetail")
public class WareOrderTaskDetailController {
    @Autowired
    private WareOrderTaskDetailService wareOrderTaskDetailService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:wareordertaskdetail:list")
    public CommonResult list(@RequestParam Map<String, Object> params){
        PageUtils page = wareOrderTaskDetailService.queryPage(params);

        return CommonResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("ware:wareordertaskdetail:info")
    public CommonResult info(@PathVariable("id") Long id){
		WareOrderTaskDetailEntity wareOrderTaskDetail = wareOrderTaskDetailService.getById(id);

        return CommonResult.ok().put("wareOrderTaskDetail", wareOrderTaskDetail);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:wareordertaskdetail:save")
    public CommonResult save(@RequestBody WareOrderTaskDetailEntity wareOrderTaskDetail){
		wareOrderTaskDetailService.save(wareOrderTaskDetail);

        return CommonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:wareordertaskdetail:update")
    public CommonResult update(@RequestBody WareOrderTaskDetailEntity wareOrderTaskDetail){
		wareOrderTaskDetailService.updateById(wareOrderTaskDetail);

        return CommonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:wareordertaskdetail:delete")
    public CommonResult delete(@RequestBody Long[] ids){
		wareOrderTaskDetailService.removeByIds(Arrays.asList(ids));

        return CommonResult.ok();
    }

}
