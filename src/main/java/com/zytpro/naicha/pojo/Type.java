package com.zytpro.naicha.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @Description：数据表type的实体类
 * @Author：ZYT
 * @Date：2023/8/6 15:37
 */
@Data
// 自动筛选实体类属性为null的字段，不将其序列化
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Type {
    /**
     * id编号
     */
    private Integer id;
    /**
     * 名称
     */
    private String typeName;
    /**
     * 图片路径
     */
    private String tImageUrl;
    /**
     * 是否上架
     * 1：可用     0：禁用
     */
    private Integer tState;
    /**
     * 逻辑删除
     * 1：已删除     0：未删除
     */
    private Integer deleted;
}
