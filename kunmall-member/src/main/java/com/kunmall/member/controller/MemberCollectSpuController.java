package com.kunmall.member.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kunmall.member.entity.MemberCollectSpuEntity;
import com.kunmall.member.service.MemberCollectSpuService;
import com.kunmall.common.utils.PageUtils;
import com.kunmall.common.utils.CommonResult;



/**
 * 会员收藏的商品
 *
 * @author kun
 * @email ghk_1998@163.com
 * @date 2021-02-24 16:29:01
 */
@RestController
@RequestMapping("member/membercollectspu")
public class MemberCollectSpuController {
    @Autowired
    private MemberCollectSpuService memberCollectSpuService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("member:membercollectspu:list")
    public CommonResult list(@RequestParam Map<String, Object> params){
        PageUtils page = memberCollectSpuService.queryPage(params);

        return CommonResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("member:membercollectspu:info")
    public CommonResult info(@PathVariable("id") Long id){
		MemberCollectSpuEntity memberCollectSpu = memberCollectSpuService.getById(id);

        return CommonResult.ok().put("memberCollectSpu", memberCollectSpu);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("member:membercollectspu:save")
    public CommonResult save(@RequestBody MemberCollectSpuEntity memberCollectSpu){
		memberCollectSpuService.save(memberCollectSpu);

        return CommonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("member:membercollectspu:update")
    public CommonResult update(@RequestBody MemberCollectSpuEntity memberCollectSpu){
		memberCollectSpuService.updateById(memberCollectSpu);

        return CommonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("member:membercollectspu:delete")
    public CommonResult delete(@RequestBody Long[] ids){
		memberCollectSpuService.removeByIds(Arrays.asList(ids));

        return CommonResult.ok();
    }

}
