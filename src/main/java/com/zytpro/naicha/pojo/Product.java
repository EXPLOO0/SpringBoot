package com.zytpro.naicha.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Description：数据表product的实体类
 * @Author：ZYT
 * @Date：2023/8/6 20:40
 */
@Data
public class Product {
    /**
     * id
     */
    private Integer id;
    /**
     * 产品名称
     */
    private String pName;
    /**
     * 关联类型表id
     */
    private Integer typeId;
    /**
     * 产品原价
     */
    private Double tPrice;
    /**
     * 产品介绍
     */
    private String tintroduce;
    /**
     * 图片路径
     */
    private String pImageUrl;
    /**
     * 1:可做热饮    0：不可做热饮
     */
    private Integer photState;
    /**
     * 折扣：0-1之间的小数
     */
    private Double pDiscount;
    /**
     * 1:可用    0：禁用
     */
    private Integer pState;
    /**
     * 逻辑删除
     * 1：已删除     0：未删除
     */
    private Integer deleted;
    /**
     * Type类的实体类对象属性，用于1:1场景
     */
    @TableField(exist = false)
    private String typeName;
}
