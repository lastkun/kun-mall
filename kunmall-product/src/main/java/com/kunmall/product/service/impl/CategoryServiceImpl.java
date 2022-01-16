package com.kunmall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
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
                .sorted((o1, o2) -> {
            return o1.getSort() - o2.getSort();
        }).collect(Collectors.toList());

        return categoryTree;
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
                .sorted((o1, o2) -> {
                    return o1.getSort() - o2.getSort();
                }).collect(Collectors.toList());
        return collect;
    }


}