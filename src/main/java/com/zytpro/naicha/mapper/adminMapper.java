package com.zytpro.naicha.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zytpro.naicha.pojo.admin;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description：admin数据表的数据层
 * @Author：ZYT
 * @Date：2023/8/6 13:38
 */
@Mapper
public interface adminMapper extends BaseMapper<admin> {
}
