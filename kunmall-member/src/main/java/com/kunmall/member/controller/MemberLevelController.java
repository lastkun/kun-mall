package com.kunmall.member.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kunmall.member.entity.MemberLevelEntity;
import com.kunmall.member.service.MemberLevelService;
import com.kunmall.common.utils.PageUtils;
import com.kunmall.common.utils.CommonResult;



/**
 * 会员等级
 *
 * @author kun
 * @email ghk_1998@163.com
 * @date 2021-02-24 16:29:01
 */
@RestController
@RequestMapping("member/memberlevel")
public class MemberLevelController {
    @Autowired
    private MemberLevelService memberLevelService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("member:memberlevel:list")
    public CommonResult list(@RequestParam Map<String, Object> params){
        PageUtils page = memberLevelService.queryPage(params);

        return CommonResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("member:memberlevel:info")
    public CommonResult info(@PathVariable("id") Long id){
		MemberLevelEntity memberLevel = memberLevelService.getById(id);

        return CommonResult.ok().put("memberLevel", memberLevel);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("member:memberlevel:save")
    public CommonResult save(@RequestBody MemberLevelEntity memberLevel){
		memberLevelService.save(memberLevel);

        return CommonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("member:memberlevel:update")
    public CommonResult update(@RequestBody MemberLevelEntity memberLevel){
		memberLevelService.updateById(memberLevel);

        return CommonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("member:memberlevel:delete")
    public CommonResult delete(@RequestBody Long[] ids){
		memberLevelService.removeByIds(Arrays.asList(ids));

        return CommonResult.ok();
    }

}
