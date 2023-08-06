package com.zytpro.naicha.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zytpro.naicha.mapper.TypeMapper;
import com.zytpro.naicha.pojo.Type;
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
     * @return true为成功，false为失败
     */
    @Override
    public Boolean deleteById(int id) {
        // 使用MyBatisPlus的deleteById方法，根据id删除对象，删除方式为逻辑删除
        return typeMapper.deleteById(id) > 0;
    }

    /**
     * 根据条件获取type表中的分页数据，若有typeName则根据typeName查找分页数据，否则查询所有的
     *
     * @param typeName：商品类型名
     * @param page: 当前页数
     * @param limit: 每页最大数据量
     * @return 查找成功将分页数据返回，失败则返回null
     */
    @Override
    public IPage<Type> getTypeByPage(String typeName, Integer page, Integer limit){
        // 根据分页信息创建分页工具类
        IPage ipage = new Page(page,limit);
        // 创建条件构造器对象
        LambdaQueryWrapper<Type> lambdaQueryWrapper = new LambdaQueryWrapper<Type>();
        // 给条件构造器对象添加条件，先判断查询条件是否存在，存在则根据条件查找，不存在则查找所有
        lambdaQueryWrapper.like(null != typeName,Type::getTypeName,typeName);
        // 通过selectPage方法获取分页数据，查找成功将分页数据返回，失败则返回null
        return typeMapper.selectPage(ipage, lambdaQueryWrapper);
    }

    /**
     * 根据id查找数据
     * @param id： id编号
     * @return 查找成功将数据返回，失败则返回null
     */
    @Override
    public Type getTypeById(Integer id) {
        // 查找成功将数据返回，失败则返回null
        return typeMapper.selectById(id);
    }

    /**
     * 根据id修改type表中的数据
     * @param type：需要修改的type对象
     * @return true为成功，false为失败
     */
    @Override
    public boolean updataById(Type type) {
        // 修改成功返回true，失败返回false
        return typeMapper.updateById(type) > 0;
    }

    /**
     * 添加type数据
     * @param type：需要添加的type对象
     * @return true为成功，false为失败
     */
    @Override
    public boolean insertType(Type type) {
        // 添加成功返回true，失败返回false
        return typeMapper.insert(type) > 0;
    }
}
