package com.zytpro.naicha.pojo;

import lombok.Data;

/**
 * @Description：数据表admin的实体类
 * @Author：ZYT
 * @Date：2023/8/6 13:33
 */
@Data  /* lombok的功能，自动给get和set */
public class Admin {
    /**
     * id
     */
    private Integer aId;
    /**
     * 账号
     */
    private String aAccount;
    /**
     * 密码
     */
    private String aPwd;
    /**
     * 头像图片的存储路径
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
