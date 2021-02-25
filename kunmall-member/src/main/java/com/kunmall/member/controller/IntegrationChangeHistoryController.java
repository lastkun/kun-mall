package com.kunmall.member.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kunmall.member.entity.IntegrationChangeHistoryEntity;
import com.kunmall.member.service.IntegrationChangeHistoryService;
import com.kunmall.common.utils.PageUtils;
import com.kunmall.common.utils.CommonResult;



/**
 * 积分变化历史记录
 *
 * @author kun
 * @email ghk_1998@163.com
 * @date 2021-02-24 16:29:01
 */
@RestController
@RequestMapping("member/integrationchangehistory")
public class IntegrationChangeHistoryController {
    @Autowired
    private IntegrationChangeHistoryService integrationChangeHistoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("member:integrationchangehistory:list")
    public CommonResult list(@RequestParam Map<String, Object> params){
        PageUtils page = integrationChangeHistoryService.queryPage(params);

        return CommonResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("member:integrationchangehistory:info")
    public CommonResult info(@PathVariable("id") Long id){
		IntegrationChangeHistoryEntity integrationChangeHistory = integrationChangeHistoryService.getById(id);

        return CommonResult.ok().put("integrationChangeHistory", integrationChangeHistory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("member:integrationchangehistory:save")
    public CommonResult save(@RequestBody IntegrationChangeHistoryEntity integrationChangeHistory){
		integrationChangeHistoryService.save(integrationChangeHistory);

        return CommonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("member:integrationchangehistory:update")
    public CommonResult update(@RequestBody IntegrationChangeHistoryEntity integrationChangeHistory){
		integrationChangeHistoryService.updateById(integrationChangeHistory);

        return CommonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("member:integrationchangehistory:delete")
    public CommonResult delete(@RequestBody Long[] ids){
		integrationChangeHistoryService.removeByIds(Arrays.asList(ids));

        return CommonResult.ok();
    }

}
