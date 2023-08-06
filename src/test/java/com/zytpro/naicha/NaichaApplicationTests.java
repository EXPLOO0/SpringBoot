package com.zytpro.naicha;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zytpro.naicha.mapper.AdminMapper;
import com.zytpro.naicha.pojo.Admin;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class NaichaApplicationTests {

    @Resource
    private AdminMapper adminMapper;

    @Test
    void contextLoads() {
        LambdaQueryWrapper<Admin> lambdaQueryWrapper = new LambdaQueryWrapper<Admin>();
        lambdaQueryWrapper.eq(Admin::getAAccount,"admin").eq(Admin::getAPwd,"admin123");

        Admin admin = adminMapper.selectOne(lambdaQueryWrapper);
//        List<Admin> admins = adminMapper.selectList(null);
        System.out.println(admin);
    }

}
