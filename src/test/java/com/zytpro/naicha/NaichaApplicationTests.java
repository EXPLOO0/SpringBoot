package com.zytpro.naicha;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zytpro.naicha.mapper.AdminMapper;
import com.zytpro.naicha.pojo.Admin;
import com.zytpro.naicha.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class NaichaApplicationTests {

    @Resource
    AdminMapper adminMapper;

    @Resource
    AdminService adminService;

    @Test
    void contextLoads() {
        Admin login = adminService.getByAccountAndPwd("admin111", "admin123");
        System.out.println(login);
    }

}
