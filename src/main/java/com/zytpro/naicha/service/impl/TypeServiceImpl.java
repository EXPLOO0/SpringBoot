package com.zytpro.naicha.service.impl;

import com.zytpro.naicha.mapper.TypeMapper;
import com.zytpro.naicha.service.TypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description：数据表type的Service层的实现类
 * @Author：ZYT
 * @Date：2023/8/6 15:57
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Resource
    TypeMapper typeMapper;

    /**
     * 根据id删除type表中的数据
     * @param id：id
     * @return：返回值为影响行数，0为删除失败
     */
    @Override
    public int deleteById(int id) {
        // 使用MyBatisPlus的deleteById方法，根据id删除对象，删除方式为逻辑删除
        return typeMapper.deleteById(id);
    }
}
