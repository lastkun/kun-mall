package com.kunmall.member.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kunmall.member.entity.MemberCollectSubjectEntity;
import com.kunmall.member.service.MemberCollectSubjectService;
import com.kunmall.common.utils.PageUtils;
import com.kunmall.common.utils.CommonResult;



/**
 * 会员收藏的专题活动
 *
 * @author kun
 * @email ghk_1998@163.com
 * @date 2021-02-24 16:29:01
 */
@RestController
@RequestMapping("member/membercollectsubject")
public class MemberCollectSubjectController {
    @Autowired
    private MemberCollectSubjectService memberCollectSubjectService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("member:membercollectsubject:list")
    public CommonResult list(@RequestParam Map<String, Object> params){
        PageUtils page = memberCollectSubjectService.queryPage(params);

        return CommonResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("member:membercollectsubject:info")
    public CommonResult info(@PathVariable("id") Long id){
		MemberCollectSubjectEntity memberCollectSubject = memberCollectSubjectService.getById(id);

        return CommonResult.ok().put("memberCollectSubject", memberCollectSubject);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("member:membercollectsubject:save")
    public CommonResult save(@RequestBody MemberCollectSubjectEntity memberCollectSubject){
		memberCollectSubjectService.save(memberCollectSubject);

        return CommonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("member:membercollectsubject:update")
    public CommonResult update(@RequestBody MemberCollectSubjectEntity memberCollectSubject){
		memberCollectSubjectService.updateById(memberCollectSubject);

        return CommonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("member:membercollectsubject:delete")
    public CommonResult delete(@RequestBody Long[] ids){
		memberCollectSubjectService.removeByIds(Arrays.asList(ids));

        return CommonResult.ok();
    }

}
