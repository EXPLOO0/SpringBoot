package com.zytpro.naicha.Controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zytpro.naicha.pojo.Type;
import com.zytpro.naicha.pojo.entity.RespCode;
import com.zytpro.naicha.pojo.entity.RespData;
import com.zytpro.naicha.pojo.entity.RespDataAndCount;
import com.zytpro.naicha.service.TypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description： 数据表type的控制层，接收前端请求
 * @Author： ZYT
 * @Date： 2023/8/6 17:29
 */
@RestController
@RequestMapping("/type")
public class TypeController {

    @Resource
    TypeService typeService;

    /**
     * 根据条件获取type表中的分页数据，若有typeName则根据typeName查找分页数据，否则查询所有的
     *
     * @param typeName：商品类型名
     * @param page: 当前页数
     * @param limit: 每页最大数据量
     * @return 有查询结果返回对象和成功信息，无结果则返回失败信息
     */
    @GetMapping
    public RespData getType(@RequestParam(required = false) String typeName, Integer page, Integer limit) {
        // 查询分页数据
        IPage<Type> iPage = typeService.getTypeByPage(typeName, page, limit);
        // 数据总数为0，返回“搜索的数据不存在！”
        if (iPage.getTotal() == 0) {
            return new RespDataAndCount(RespCode.ERROR_3);
        }
        // 当前页数据为空，返回“获取失败”
        if (iPage.getRecords() == null) {
            return new RespDataAndCount(RespCode.ERROR_2);
        }
        // 搜索成功，返回SUCCESS
        return new RespDataAndCount(RespCode.SUCCESS, iPage.getRecords(), iPage.getTotal());
    }

    /**
     * 根据id获取type表中的数据
     * @param id：id
     * @return 获取成功返回数据和成功信息，否则返回失败信息
     */
    @GetMapping ("/{id}")
    public RespData getTypeById(@PathVariable("id") Integer id) {
        // 调用Service层的getTypeById方法，并判断查找是否成功
        Type typeById = typeService.getTypeById(id);
        if (typeById != null)
            // 查找成功，返回SUCCESS
            return new RespData(RespCode.SUCCESS, typeById);
        // 查找失败，返回"获取失败"
        return new RespData(RespCode.ERROR_2);
    }

    /**
     * 添加type数据
     * @param type：需要添加的type对象
     * @return 添加成功返回成功信息，否则返回失败信息
     */
    @PostMapping
    public RespData addType(Type type) {
        // 判断TypeName是否输入，若未输入类型名，返回"未输入信息!!"
        if (type.getTypeName() == null || type.getTypeName() == "")
            return new RespData(RespCode.ERROR_4);
        // 调用ervice层的insertType方法，并判断添加是否成功
        if (typeService.insertType(type))
            // 添加成功，返回SUCCESS
            return new RespData(RespCode.SUCCESS);
        // 添加失败，返回"添加数据失败!!"
        return new RespData(RespCode.ERROR_5);
    }

    /**
     * 根据id删除type表中的数据
     * @param id：id
     * @return 删除成功返回成功信息，否则返回失败信息
     */
    @DeleteMapping("/{id}")
    public RespData deleteType(@PathVariable("id") Integer id) {
        // 调用Service层的deleteById方法，并判断删除是否成功
        if (typeService.deleteById(id))
            // 删除成功，返回SUCCESS
            return new RespData(RespCode.SUCCESS);
        // 删除失败，返回"删除数据失败!!"
        return new RespData(RespCode.ERROR_7);
    }

    /**
     * 根据id修改type表中的数据
     * @param type：需要修改的type对象
     * @return 修改成功返回成功信息，否则返回失败信息
     */
    @PutMapping
    public RespData updataType(Type type){
        // 判断TypeName是否输入，若未输入类型名，返回"未输入信息!!"
        if (type.getTypeName() == null || type.getTypeName() == "")
            return new RespData(RespCode.ERROR_4);
        if (typeService.updataById(type))
            // 修改成功，返回SUCCESS
            return new RespData(RespCode.SUCCESS);
        // 修改失败，返回ERROR_6
        return new RespData(RespCode.ERROR_6);
    }
}
