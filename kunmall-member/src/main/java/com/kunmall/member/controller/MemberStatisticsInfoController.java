package com.kunmall.member.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kunmall.member.entity.MemberStatisticsInfoEntity;
import com.kunmall.member.service.MemberStatisticsInfoService;
import com.kunmall.common.utils.PageUtils;
import com.kunmall.common.utils.CommonResult;



/**
 * 会员统计信息
 *
 * @author kun
 * @email ghk_1998@163.com
 * @date 2021-02-24 16:29:01
 */
@RestController
@RequestMapping("member/memberstatisticsinfo")
public class MemberStatisticsInfoController {
    @Autowired
    private MemberStatisticsInfoService memberStatisticsInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("member:memberstatisticsinfo:list")
    public CommonResult list(@RequestParam Map<String, Object> params){
        PageUtils page = memberStatisticsInfoService.queryPage(params);

        return CommonResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("member:memberstatisticsinfo:info")
    public CommonResult info(@PathVariable("id") Long id){
		MemberStatisticsInfoEntity memberStatisticsInfo = memberStatisticsInfoService.getById(id);

        return CommonResult.ok().put("memberStatisticsInfo", memberStatisticsInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("member:memberstatisticsinfo:save")
    public CommonResult save(@RequestBody MemberStatisticsInfoEntity memberStatisticsInfo){
		memberStatisticsInfoService.save(memberStatisticsInfo);

        return CommonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("member:memberstatisticsinfo:update")
    public CommonResult update(@RequestBody MemberStatisticsInfoEntity memberStatisticsInfo){
		memberStatisticsInfoService.updateById(memberStatisticsInfo);

        return CommonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("member:memberstatisticsinfo:delete")
    public CommonResult delete(@RequestBody Long[] ids){
		memberStatisticsInfoService.removeByIds(Arrays.asList(ids));

        return CommonResult.ok();
    }

}
