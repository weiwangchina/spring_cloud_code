package cn.wcuu.product_service.controller;

import cn.wcuu.product_service.domain.Product;
import cn.wcuu.product_service.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@RestController
@RequestMapping("/api/v1.0.1/product")
@RefreshScope
public class ProductController {



    @Value("${server.port}")
    private String port;

    @Value("${env}")
    private String env;

    @Autowired
    private ProductService productService;

    /**
     * 获取所有商品列表
     * http://127.0.0.1:9000/apigateway/product/api/v1/product/list?token=1&user_id=1&product_id=1
     * @return
     */
    @RequestMapping("list")
    public Object list(){
        return productService.listProduct();
    }


    /**
     * 根据id查找商品详情
     * @param id
     * @return
     */
    @RequestMapping("find")
    public Object findById(@RequestParam(name = "id") int id){
        Product product = productService.findById(id);
        Lock lock = new ReentrantLock();
        Product result = new Product();
        BeanUtils.copyProperties(product,result);
        result.setName( result.getName() + " data from port="+port +" env = "+env );
        return result;
    }

    @Autowired
    private ProductService mapper;

    @RequestMapping("test")
    public Object test(){
        return mapper.selectCountTotal();
    }

}
