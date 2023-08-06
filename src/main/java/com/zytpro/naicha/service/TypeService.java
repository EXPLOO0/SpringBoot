package com.zytpro.naicha.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zytpro.naicha.pojo.Type;

/**
 * @Description：数据表type的Service层
 * @Author：ZYT
 * @Date：2023/8/6 15:57
 */
public interface TypeService {
    /**
     * 根据id删除type表中的数据
     * @param id：id
     * @return：true为成功，false为失败
     */
    public Boolean deleteById(int id);

    /**
     * 根据条件获取type表中的分页数据，若有typeName则根据typeName查找分页数据，否则查询所有的
     * @param typeName：商品类型名
     * @param page: 当前页数
     * @param limit: 每页最大数据量
     * @return: 查找成功将分页数据返回，失败则返回null
     */
    public IPage<Type> getTypeByPage(String typeName, Integer page, Integer limit);

    /**
     * 根据id修改type表中的数据
     * @param type：需要修改的type对象
     * @return：true为成功，false为失败
     */
    public boolean updataById(Type type);

    /**
     * 添加type数据
     * @param type：需要添加的type对象
     * @return：true为成功，false为失败
     */
    public boolean insertType(Type type);
}
