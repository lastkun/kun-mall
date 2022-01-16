package com.kunmall.product;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kunmall.product.entity.BrandEntity;
import com.kunmall.product.entity.CategoryEntity;
import com.kunmall.product.service.BrandService;
import com.kunmall.product.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class KunmallProductApplicationTests {

    @Autowired
    BrandService brandService;

    @Autowired
    CategoryService categoryService;

    @Test
    public void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setDescript("测试");
        brandEntity.setName("测试");
        brandService.save(brandEntity);

        //使用拼接的条件查询
        List<BrandEntity> list = brandService.list(new QueryWrapper<BrandEntity>().eq("name", "测试"));
        list.forEach( (item) -> {
            System.out.println(item);
        });
    }

    @Test
    public void testCategory() {
        List<CategoryEntity> categoryEntities = categoryService.listWithTree();
        System.out.println(categoryEntities);
    }

}
