package com.kunmall.member.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kunmall.member.entity.MemberLoginLogEntity;
import com.kunmall.member.service.MemberLoginLogService;
import com.kunmall.common.utils.PageUtils;
import com.kunmall.common.utils.CommonResult;



/**
 * 会员登录记录
 *
 * @author kun
 * @email ghk_1998@163.com
 * @date 2021-02-24 16:29:01
 */
@RestController
@RequestMapping("member/memberloginlog")
public class MemberLoginLogController {
    @Autowired
    private MemberLoginLogService memberLoginLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("member:memberloginlog:list")
    public CommonResult list(@RequestParam Map<String, Object> params){
        PageUtils page = memberLoginLogService.queryPage(params);

        return CommonResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("member:memberloginlog:info")
    public CommonResult info(@PathVariable("id") Long id){
		MemberLoginLogEntity memberLoginLog = memberLoginLogService.getById(id);

        return CommonResult.ok().put("memberLoginLog", memberLoginLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("member:memberloginlog:save")
    public CommonResult save(@RequestBody MemberLoginLogEntity memberLoginLog){
		memberLoginLogService.save(memberLoginLog);

        return CommonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("member:memberloginlog:update")
    public CommonResult update(@RequestBody MemberLoginLogEntity memberLoginLog){
		memberLoginLogService.updateById(memberLoginLog);

        return CommonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("member:memberloginlog:delete")
    public CommonResult delete(@RequestBody Long[] ids){
		memberLoginLogService.removeByIds(Arrays.asList(ids));

        return CommonResult.ok();
    }

}
