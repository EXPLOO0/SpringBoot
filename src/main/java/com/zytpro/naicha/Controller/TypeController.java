package com.zytpro.naicha.Controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zytpro.naicha.pojo.Type;
import com.zytpro.naicha.pojo.entity.RespCode;
import com.zytpro.naicha.pojo.entity.RespData;
import com.zytpro.naicha.pojo.entity.RespDataAndCount;
import com.zytpro.naicha.service.TypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description：数据表type的控制层，接收前端请求
 * @Author：ZYT
 * @Date：2023/8/6 17:29
 */
@RestController
@RequestMapping("/type")
public class TypeController {

    @Resource
    TypeService typeService;

    /**
     * 根据条件获取type表中的分页数据，若有typeName则根据typeName查找分页数据，否则查询所有的
     * @param typeName：商品类型名
     * @param page: 当前页数
     * @param limit: 每页最大数据量
     * @return 有查询结果返回对象和成功信息，无结果则返回失败信息
     */
    @GetMapping
    public RespData getType(@RequestParam(required = false) String typeName, Integer page, Integer limit){
        // 查询分页数据
        IPage<Type> iPage = typeService.getTypeByPage(typeName, page, limit);
        // 数据总数为0，返回“搜索的数据不存在！”
        if (iPage.getTotal() == 0){
            return new RespDataAndCount(RespCode.ERROR_3);
        }
        // 当前页数据为空，返回“获取失败”
        if (iPage.getRecords() == null){
            return new RespDataAndCount(RespCode.ERROR_2);
        }
        // 搜索成功，返回SUCCESS
        return new RespDataAndCount(RespCode.SUCCESS, iPage.getRecords(), iPage.getTotal());
    }
}
