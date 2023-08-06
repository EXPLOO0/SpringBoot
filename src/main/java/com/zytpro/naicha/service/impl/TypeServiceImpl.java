package com.zytpro.naicha.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zytpro.naicha.mapper.TypeMapper;
import com.zytpro.naicha.pojo.Admin;
import com.zytpro.naicha.pojo.Type;
import com.zytpro.naicha.service.TypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    /**
     * 根据条件获取type表中的分页数据，若有typeName则根据typeName查找分页数据，否则查询所有的
     * @param typeName：商品类型名
     * @param page: 当前页数
     * @param limit: 每页最大数据量
     * @return: 查找成功将数据装进list，失败则返回null
     */
    @Override
    public List<Type> getTypeByPage(String typeName, Integer page, Integer limit){
        // 创建分页工具类，填入
        IPage ipage = new Page(page,limit);
        // 创建LambdaQueryWrapper条件构造器对象
        LambdaQueryWrapper<Type> lambdaQueryWrapper = new LambdaQueryWrapper<Type>();
        // 给条件构造器对象添加条件，先判断查询条件是否存在，存在则根据条件查找，不存在则查找所有
        lambdaQueryWrapper.like(null != typeName,Type::getTypeName,typeName);
        // 通过selectPage方法获取分页数据，用getRecords方法获取当前页数据
        return typeMapper.selectPage(ipage, lambdaQueryWrapper).getRecords();
    }
}
