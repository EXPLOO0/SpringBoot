package com.zytpro.naicha.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zytpro.naicha.mapper.ProductMapper;
import com.zytpro.naicha.pojo.Product;
import com.zytpro.naicha.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Description：product数据表的Service层的实现类
 * @Author：ZYT
 * @Date：2023/8/6 20:43
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    ProductMapper productMapper;

    /**
     * 根据id删除product表中的数据
     * @param id：id
     * @return true为成功，false为失败
     */
    @Override
    public Boolean deleteById(int id) {
        // 使用MyBatisPlus的deleteById方法，根据id删除对象，删除方式为逻辑删除
        return productMapper.deleteById(id) > 0;
    }

    /**
     * 根据条件获取product表中的分页数据，若有搜索信息则根据搜索信息查找分页数据，否则查询所有的
     * @param params: 搜索信息和分页信息
     * @return 查找成功将分页数据返回，失败则返回null
     */
    @Override
    public List<Product> getProductByPage(Map<String, Object> params) {
        return productMapper.selectProductWithType(params);
    }

    /**
     * 根据条件获取product表中的数据总数，若有搜索信息则根据搜索信息查找数据总数，否则查询所有的数据总数
     * @param params: 搜索信息和分页信息
     * @return 查找成功将数据总数返回，失败则返回null
     */
    @Override
    public Long getProductCount(Map<String, Object> params) {
        // 根据分页信息创建分页工具类
        IPage ipage = new Page((Integer) params.get("page"), (Integer) params.get("limit"));
        // 创建条件构造器对象
        LambdaQueryWrapper<Product> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        // 给条件构造器对象添加条件，先判断查询条件是否存在，存在则根据条件查找，不存在则查找所有
        lambdaQueryWrapper.like(StringUtils.isNotBlank((CharSequence) params.get("name")), Product::getPName, params.get("name"));
        lambdaQueryWrapper.eq(null != params.get("typeId"), Product::getTypeId, params.get("typeId"));
        lambdaQueryWrapper.ge(null != params.get("min"), Product::getTPrice, params.get("min"));
        lambdaQueryWrapper.le(null != params.get("max"), Product::getTPrice, params.get("max"));
        // 通过selectPage方法获取分页数据，查找成功将分页数据返回，失败则返回null
        return productMapper.selectPage(ipage, lambdaQueryWrapper).getTotal();
    }

    /**
     * 根据id查找数据
     * @param id： id编号
     * @return 查找成功将数据返回，失败则返回null
     */
    @Override
    public Product getProductById(Integer id) {
        // 查找成功将数据返回，失败则返回null
        return productMapper.selectById(id);
    }

    /**
     * 根据id修改product表中的数据
     * @param product：需要修改的product对象
     * @return true为成功，false为失败
     */
    @Override
    public boolean updataById(Product product) {
        // 修改成功返回true，失败返回false
        return productMapper.updateById(product) > 0;
    }

    /**
     * 添加product数据
     * @param product：需要添加的product对象
     * @return true为成功，false为失败
     */
    @Override
    public boolean insertProduct(Product product) {
        // 添加成功返回true，失败返回false
        return productMapper.insert(product) > 0;
    }
}
