package com.zytpro.naicha.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zytpro.naicha.mapper.AdminMapper;
import com.zytpro.naicha.pojo.Admin;
import com.zytpro.naicha.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description：admin数据表的Service层的实现类
 * @Author：ZYT
 * @Date：2023/8/6 13:42
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    AdminMapper adminMapper;

    /**
     * 接收用户名和密码，查找是否存在
     * @param account：用户名
     * @param pwd：密码
     * @return：admin对象，找到了就返回admin对象，没找到就返回null
     */
    @Override
    public Admin getByAccountAndPwd(String account, String pwd) {
        // 创建LambdaQueryWrapper条件构造器对象
        LambdaQueryWrapper<Admin> lambdaQueryWrapper = new LambdaQueryWrapper<Admin>();
        // 给条件构造器对象添加条件，判断用户名和密码
        lambdaQueryWrapper.eq(Admin::getAAccount,account).eq(Admin::getAPwd,pwd);
        // 使用MyBatisPlus的selectOne方法，将条件构造器对象作为参数查找一个对象
        Admin admin = adminMapper.selectOne(lambdaQueryWrapper);

        return admin;
    }
}
