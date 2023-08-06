package com.zytpro.naicha;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zytpro.naicha.mapper.AdminMapper;
import com.zytpro.naicha.mapper.TypeMapper;
import com.zytpro.naicha.pojo.Admin;
import com.zytpro.naicha.pojo.Type;
import com.zytpro.naicha.service.AdminService;
import com.zytpro.naicha.service.TypeService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class NaichaApplicationTests {

    @Resource
    AdminMapper adminMapper;

    @Resource
    TypeMapper typeMapper;

    @Resource
    AdminService adminService;

    @Resource
    TypeService typeService;

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
//        int i = typeMapper.deleteById(1);
        IPage<Type> page = typeService.getTypeByPage("奶奶", 1, 9);
        System.out.println(page.getRecords());
    }

}
