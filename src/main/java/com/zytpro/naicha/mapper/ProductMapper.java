package com.zytpro.naicha.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zytpro.naicha.pojo.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @Description：product数据表的数据层
 * @Author：ZYT
 * @Date：2023/8/6 20:42
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {
    @Select({"<script>",
            "SELECT p.*,t.type_name",
            "FROM `product` AS `p`",
            "LEFT JOIN `type` AS `t`",
            "ON p.type_id = t.id",
            "<where>",
            "<if test='name != null and name != \"\"'>",
            "p.p_name LIKE CONCAT('%',#{name},'%')",
            "</if>",
            "<if test='typeId != null and typeId != \"\"'>",
            "AND p.type_id = #{typeId}",
            "</if>",
            "<if test='min != null and min != \"\"'>",
            "AND p.t_price &gt;= #{min}",
            "</if>",
            "<if test='max != null and max != \"\"'>",
            "AND p.t_price &lt;= #{max}",
            "</if>",
            "AND t.deleted != 1",
            "AND p.deleted != 1",
            "</where>",
            "LIMIT #{page}, #{limit}",
            "</script>"})
    List<Product> selectProductWithType(Map<String, Object> params);
}
