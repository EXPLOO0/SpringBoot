package com.zytpro.naicha.Controller;

import com.zytpro.naicha.pojo.Product;
import com.zytpro.naicha.pojo.entity.RespCode;
import com.zytpro.naicha.pojo.entity.RespData;
import com.zytpro.naicha.pojo.entity.RespDataAndCount;
import com.zytpro.naicha.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据表product的控制层，接收前端请求
 *
 * @Description：
 * @Author：ZYT
 * @Date：2023/8/6 20:44
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    ProductService productService;

    /**
     * 根据条件获取product表中的分页数据，若有搜索条件则根据搜索条件查找分页数据，否则查询所有的
     * @param productName:  商品名称
     * @param typeId：商品类型id
     * @param min：价格最小值
     * @param max：价格最大值
     * @param page：当前页数
     * @param limit：每页最大数据量
     * @return： 成功返回响应码、信息、分页数据、数据总量，失败返回错误信息
     */
    @GetMapping
    public RespData getProductByPage(@RequestParam(required = false) String productName,
                                     @RequestParam(required = false) Integer typeId,
                                     @RequestParam(required = false) Double min,
                                     @RequestParam(required = false) Double max,
                                     Integer page, Integer limit) {
        // 凑一个Map集合封装数据
        Map<String, Object> params = new HashMap<>();
        params.put("name", productName);
        params.put("typeId", typeId);
        params.put("min", min);
        params.put("max", max);
        params.put("page", (page - 1) * limit);
        params.put("limit", limit);
        // 获取product分页数据
        List<Product> productList = productService.getProductByPage(params);
        // 获取数据量
        Long count = productService.getProductCount(params);
        // 获取数据失败，返回ERROR_2
        if (productList == null || count == null)
            return new RespDataAndCount(RespCode.ERROR_2);
        // 搜索的商品不存在时，返回ERROR_3
        if (productList.size() == 0 || count == 0)
            return new RespDataAndCount(RespCode.ERROR_3);
        // 搜索成功，返回SUCCESS
        return new RespDataAndCount(RespCode.SUCCESS, productList, count);
    }

    /**
     * 根据id获取product表中的数据
     * @param id：id
     * @return 获取成功返回数据和成功信息，否则返回失败信息
     */
    @GetMapping("/{id}")
    public RespData getProductById(@PathVariable("id") Integer id) {
        // 调用Service层的getTypeById方法，并判断查找是否成功
        Product productById = productService.getProductById(id);
        if (productById != null)
            // 查找成功，返回SUCCESS
            return new RespData(RespCode.SUCCESS, productById);
        // 查找失败，返回"获取失败"
        return new RespData(RespCode.ERROR_2);
    }

    /**
     * 添加product数据
     * @param product：需要添加的product对象
     * @return 添加成功返回成功信息，否则返回失败信息
     */
    @PostMapping
    public RespData addProduct(Product product) {
        // 调用ervice层的insertProduct方法，并判断添加是否成功
        if (productService.insertProduct(product))
            // 添加成功，返回SUCCESS
            return new RespData(RespCode.SUCCESS);
        // 添加失败，返回"添加数据失败!!"
        return new RespData(RespCode.ERROR_5);

    }

    /**
     * 根据id删除product表中的数据
     * @param id：id
     * @return 删除成功返回成功信息，否则返回失败信息
     */
    @DeleteMapping("/{id}")
    public RespData deleteProduct(@PathVariable("id") Integer id) {
        // 调用Service层的deleteById方法，并判断删除是否成功
        if (productService.deleteById(id))
            // 删除成功，返回SUCCESS
            return new RespData(RespCode.SUCCESS);
        // 删除失败，返回"删除数据失败!!"
        return new RespData(RespCode.ERROR_7);
    }

    /**
     * 根据id修改product表中的数据
     * @param product：需要修改的product对象
     * @return 修改成功返回成功信息，否则返回失败信息
     */
    @PutMapping
    public RespData updataProduct(Product product) {
        // 调用Service层的updataById方法，并判断修改是否成功
        if (productService.updataById(product))
            // 修改成功，返回SUCCESS
            return new RespData(RespCode.SUCCESS);
        // 修改失败，返回ERROR_6
        return new RespData(RespCode.ERROR_6);
    }
}
