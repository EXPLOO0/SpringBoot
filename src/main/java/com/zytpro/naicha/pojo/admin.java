package com.zytpro.naicha.pojo;

import lombok.Data;

/**
 * @Description：数据表admin的实体类
 * @Author：ZYT
 * @Date：2023/8/6 13:33
 */
@Data
public class admin {
    /**
     * id
     */
    private Integer aid;
    /**
     * 账号
     */
    private String aAccount;
    /**
     * 密码
     */
    private String aPwd;
    /**
     * 管理员头像
     */
    private String aHeadPhoto;
    /**
     * 昵称
     */
    private String aName;
    /**
     * 电话号码
     */
    private String aPhone;
    /**
     * 性别
     */
    private String aGender;
    /**
     * 年龄
     */
    private Integer aAge;
}
