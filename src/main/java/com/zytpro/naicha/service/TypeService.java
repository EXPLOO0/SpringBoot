package com.zytpro.naicha.service;

import com.zytpro.naicha.pojo.Type;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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

    /**
     * 根据条件获取type表中的分页数据，若有typeName则根据typeName查找分页数据，否则查询所有的
     * @param typeName：商品类型名
     * @param page: 当前页数
     * @param limit: 每页最大数据量
     * @return: 查找成功将数据装进list，失败则返回null
     */
    public List<Type> getTypeByPage(String typeName, Integer page, Integer limit);
}
