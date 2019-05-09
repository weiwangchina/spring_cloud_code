package cn.wcuu.product_service.service;

import cn.wcuu.product_service.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> listProduct();

    Product findById(int id);

    int selectCountTotal();


}
