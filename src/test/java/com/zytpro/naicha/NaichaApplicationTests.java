package com.zytpro.naicha;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zytpro.naicha.mapper.AdminMapper;
import com.zytpro.naicha.mapper.TypeMapper;
import com.zytpro.naicha.pojo.Admin;
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
        int i = typeService.deleteById(1);
        System.out.println("删除："+i);
    }

}
