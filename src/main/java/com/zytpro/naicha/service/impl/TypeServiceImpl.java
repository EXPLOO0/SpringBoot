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

    @Override
    public int deleteById(int id) {
        return typeMapper.deleteById(id);
    }
}
