package com.kunmall.product.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kunmall.common.utils.CommonPage;
import com.kunmall.product.model.AttrGroupModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kunmall.common.utils.PageUtils;
import com.kunmall.common.utils.Query;

import com.kunmall.product.dao.AttrGroupDao;
import com.kunmall.product.entity.AttrGroupEntity;
import com.kunmall.product.service.AttrGroupService;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageUtils(page);
    }

    //TODO Mybatis 分页和分页插件的区别
    @Override
    public List<AttrGroupEntity> queryPage(AttrGroupModel model) {
        String categoryId = model.getCategoryId();
        List<AttrGroupEntity> attrGroupEntities;
        if (categoryId == null) {
            attrGroupEntities = baseMapper.selectList(new QueryWrapper<AttrGroupEntity>());
        } else {
            //关键字搜索
            QueryWrapper<AttrGroupEntity> wrapper = new QueryWrapper<AttrGroupEntity>().eq("catelog_id", categoryId);
            String key = model.getKey();
            if (StringUtils.isNotEmpty(key)){
                wrapper.and(obj -> obj.eq("attr_group_id", key).or().like("attr_group_name", key));
            }
            attrGroupEntities = baseMapper.selectList(wrapper);
        }
        return attrGroupEntities;
    }

//    @Override
//    public PageUtils queryPage(Map<String, Object> params, String categoryId) {
//        if(categoryId == null){
//            IPage<AttrGroupEntity> page = this.page(
//                    new Query<AttrGroupEntity>().getPage(params),
//                    new QueryWrapper<AttrGroupEntity>()
//            );
//            return new PageUtils(page);
//        } else {
//            //关键字搜索
//            String key = String.valueOf(params.get("key"));
//            QueryWrapper<AttrGroupEntity> wrapper = new QueryWrapper<AttrGroupEntity>().eq("catelog_id", categoryId);
//            if (StringUtils.isNotEmpty(key)){
//                wrapper.and(obj -> obj.eq("attr_group_id", key).or().like("attr_group_name", key));
//            }
//
//            IPage<AttrGroupEntity> page = this.page(
//                    new Query<AttrGroupEntity>().getPage(params),
//                    wrapper);
//            return new PageUtils(page);
//        }
//    }

}