package com.zytpro.naicha.service;

/**
 * @Description：数据表type的Service层
 * @Author：ZYT
 * @Date：2023/8/6 15:57
 */
public interface TypeService {
    /**
     * 根据id删除type表中的数据
     * @param id：id
     * @return：返回值为影响行数，0为删除失败
     */
    public int deleteById(int id);
}
