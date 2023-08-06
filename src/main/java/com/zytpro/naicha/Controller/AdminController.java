package com.zytpro.naicha.Controller;

import com.zytpro.naicha.pojo.Admin;
import com.zytpro.naicha.pojo.entity.RespCode;
import com.zytpro.naicha.pojo.entity.RespData;
import com.zytpro.naicha.service.AdminService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/** 数据表admin的控制层，接收前端请求
 * @Description：
 * @Author：ZYT
 * @Date：2023/8/6 15:03
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    AdminService adminService;

    /**
     * 处理登录请求，根据用户名和密码查询admin数据表
     * @param account：前端传递来的用户名
     * @param pwd：前端传递来的密码
     * @return：有查询结果返回对象和成功信息，无结果则返回失败信息
     */
    @PostMapping
    public RespData login(String account, String pwd){
        // 调用Service层根据用户名和密码查找admin信息
        Admin adminByAccountAndPwd = adminService.getByAccountAndPwd(account, pwd);
        // 判断根据用户名和密码查找的admin信息是否存在
        if (adminByAccountAndPwd != null){
            // 存在，返回admin对象
            return new RespData(RespCode.SUCCESS, adminByAccountAndPwd);
        }
        // 不存在，返回错误信息
        return new RespData(RespCode.ERROR_1);
    }
}
