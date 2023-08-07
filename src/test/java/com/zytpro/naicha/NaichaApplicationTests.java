package com.zytpro.naicha;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zytpro.naicha.mapper.AdminMapper;
import com.zytpro.naicha.mapper.ProductMapper;
import com.zytpro.naicha.mapper.TypeMapper;
import com.zytpro.naicha.pojo.Admin;
import com.zytpro.naicha.pojo.Product;
import com.zytpro.naicha.pojo.Type;
import com.zytpro.naicha.service.AdminService;
import com.zytpro.naicha.service.ProductService;
import com.zytpro.naicha.service.TypeService;
import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class NaichaApplicationTests {

    @Resource
    AdminMapper adminMapper;

    @Resource
    TypeMapper typeMapper;

    @Resource
    ProductMapper productMapper;

    @Resource
    AdminService adminService;

    @Resource
    TypeService typeService;

    @Resource
    ProductService productService;

    @Test
    void getAdminTest() {
        Admin login = adminService.getByAccountAndPwd("admin111", "admin123");
        System.out.println(login);
    }

    @Test
    void deleteTypeTest() {
//        int i = typeMapper.deleteById(1);
        boolean i = typeService.deleteById(99);
        System.out.println("删除："+i);
    }

    @Test
    void getTypeTest() {
        IPage<Type> page = typeService.getTypeByPage("奶奶", 1, 9);
        System.out.println("当前页码："+page.getCurrent());
        System.out.println("每页数据总量："+page.getSize());
        System.out.println("总页数："+page.getPages());
        System.out.println("数据总量："+page.getTotal());
        System.out.println("当前页数据："+page.getRecords());
        System.out.println("----------");
        page = typeService.getTypeByPage("奶", 1, 9);
        System.out.println("当前页码："+page.getCurrent());
        System.out.println("每页数据总量："+page.getSize());
        System.out.println("总页数："+page.getPages());
        System.out.println("数据总量："+page.getTotal());
        System.out.println("当前页数据："+page.getRecords());
        System.out.println("----------");
        page = typeService.getTypeByPage("奶", 2, 9);
        System.out.println("当前页码："+page.getCurrent());
        System.out.println("每页数据总量："+page.getSize());
        System.out.println("总页数："+page.getPages());
        System.out.println("数据总量："+page.getTotal());
        System.out.println("当前页数据："+page.getRecords());
        System.out.println("----------");
    }

    @Test
    void updateTypeTest() {
        Type type = new Type();
        type.setId(19);
        type.setTState(1);
        System.out.println(typeService.updataById(type));
    }

    @Test
    void insertTypeTest() {
        Type type = new Type();
        type.setTState(1);
        type.setTypeName("测试");
        type.setTImageUrl("123465");
        System.out.println(typeService.insertType(type));
    }
    @Test
    void selectProductTest() {
        // 凑一个Map集合,给获取数据总量用
        Map<String, Object> params = new HashMap<>();
        params.put("name", null);
        params.put("typeId", null);
        params.put("min", null);
        params.put("max", null);
        params.put("start", (2 - 1) * 10);
        params.put("page", 10);
        List<Product> productList = productMapper.selectProductWithType(params);
        for (Product product:productList) {
            System.out.println(product);
        }
        System.out.println("总数:"+productService.getProductCount(params));
    }

    @Test
    void deleteProductTest() {
        System.out.println("结果："+productService.deleteById(14));
    }
}
