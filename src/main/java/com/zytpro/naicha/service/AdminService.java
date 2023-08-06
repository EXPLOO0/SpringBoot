package com.zytpro.naicha.service;

import com.zytpro.naicha.pojo.Admin;

/**
 * @Description：admin数据表的Service层
 * @Author：ZYT
 * @Date：2023/8/6 13:40
 */
public interface AdminService {
    public Admin getByAccountAndPwd(String account, String pwd);
}
