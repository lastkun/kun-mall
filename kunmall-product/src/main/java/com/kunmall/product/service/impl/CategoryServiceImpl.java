package com.kunmall.product.service.impl;

import com.sun.deploy.uitoolkit.impl.awt.AWTDragHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kunmall.common.utils.PageUtils;
import com.kunmall.common.utils.Query;

import com.kunmall.product.dao.CategoryDao;
import com.kunmall.product.entity.CategoryEntity;
import com.kunmall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        //全部分类
        List<CategoryEntity> all = baseMapper.selectList(null);

        //找出一级分类并组装分类树
        List<CategoryEntity> categoryTree = all.stream().filter(categoryEntity -> categoryEntity.getParentCid() == 0)
                .map(categoryEntity -> {
                    categoryEntity.setSubCategories(addSubcategories(categoryEntity, all));
                    return categoryEntity;
                })
                .sorted((o1, o2) -> o1.getSort() - o2.getSort()).collect(Collectors.toList());

        return categoryTree;
    }

    @Override
    public void deleteByLogic(List<Long> asList) {
        baseMapper.deleteBatchIds(asList);
    }

    @Override
    public String getCategoryPath(Long catelogId) {
        ArrayList<String> pathArr = new ArrayList<>();
        while (catelogId != 0) {
            CategoryEntity categoryEntity = baseMapper.selectById(catelogId);
            pathArr.add(String.valueOf(catelogId));
            catelogId = categoryEntity.getParentCid();
        }
        pathArr.add("0");
        Collections.reverse(pathArr);
        return StringUtils.join(pathArr, ",");
    }



    /**
     * 拼接子分类
     * @param root
     * @param all
     * @return
     */
    private List<CategoryEntity> addSubcategories(CategoryEntity root, List<CategoryEntity> all) {
        List<CategoryEntity> collect = all.stream().filter(categoryEntity -> categoryEntity.getParentCid().equals(root.getCatId()))
                .map(categoryEntity -> {
                    categoryEntity.setSubCategories(addSubcategories(categoryEntity, all));
                    return categoryEntity;
                })
                .sorted(Comparator.comparingInt(CategoryEntity::getSort)).collect(Collectors.toList());
        return collect;
    }


}