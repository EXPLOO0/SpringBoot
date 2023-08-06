package com.zytpro.naicha.pojo.entity;

/**
 * @Description：用来返回分页数据
 * @Author：ZYT
 * @Date：2023/8/6 17:35
 */
public class RespDataAndCount extends RespData{  // 继承RespData类
    /**
     * 数据总量
     */
    private Long count;
    public RespDataAndCount(RespCode code) {
        super(code);
    }

    public RespDataAndCount(RespCode code, Object data, Long count) {
        super(code, data);
        this.count = count;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
