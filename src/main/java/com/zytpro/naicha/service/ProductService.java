package com.zytpro.naicha.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zytpro.naicha.pojo.Product;

import java.util.List;
import java.util.Map;

/**
 * @Description：product数据表的Service层
 * @Author：ZYT
 * @Date：2023/8/6 20:43
 */
public interface ProductService {
    /**
     * 根据id删除product表中的数据
     * @param id：id
     * @return：true为成功，false为失败
     */
    public Boolean deleteById(int id);

    /**
     * 根据条件获取product表中的分页数据，若有搜索信息则根据搜索信息查找分页数据，否则查询所有的
     * @param params: 搜索信息和分页信息
     * @return 查找成功将分页数据返回，失败则返回null
     */
    public List<Product> getProductByPage(Map<String, Object> params);

    /**
     * 根据条件获取product表中的数据总数，若有搜索信息则根据搜索信息查找数据总数，否则查询所有的数据总数
     * @param params: 搜索信息和分页信息
     * @return 查找成功将数据总数返回，失败则返回null
     */
    public Long getProductCount(Map<String, Object> params);

    /**
     * 根据id查找数据
     * @param id： id编号
     * @return 查找成功将数据返回，失败则返回null
     */
    public Product getProductById(Integer id);

    /**
     * 根据id修改product表中的数据
     * @param product：需要修改的product对象
     * @return true为成功，false为失败
     */
    public boolean updataById(Product product);

    /**
     * 添加product数据
     * @param product：需要添加的product对象
     * @return true为成功，false为失败
     */
    public boolean insertProduct(Product product);
}
