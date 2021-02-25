package com.kunmall.member.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kunmall.member.entity.MemberEntity;
import com.kunmall.member.service.MemberService;
import com.kunmall.common.utils.PageUtils;
import com.kunmall.common.utils.CommonResult;



/**
 * 会员
 *
 * @author kun
 * @email ghk_1998@163.com
 * @date 2021-02-24 16:29:01
 */
@RestController
@RequestMapping("member/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("member:member:list")
    public CommonResult list(@RequestParam Map<String, Object> params){
        PageUtils page = memberService.queryPage(params);

        return CommonResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("member:member:info")
    public CommonResult info(@PathVariable("id") Long id){
		MemberEntity member = memberService.getById(id);

        return CommonResult.ok().put("member", member);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("member:member:save")
    public CommonResult save(@RequestBody MemberEntity member){
		memberService.save(member);

        return CommonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("member:member:update")
    public CommonResult update(@RequestBody MemberEntity member){
		memberService.updateById(member);

        return CommonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("member:member:delete")
    public CommonResult delete(@RequestBody Long[] ids){
		memberService.removeByIds(Arrays.asList(ids));

        return CommonResult.ok();
    }

}
