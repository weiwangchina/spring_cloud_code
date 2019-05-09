package cn.wcuu.product_service.service.impl;

import cn.wcuu.product_service.domain.Product;
import cn.wcuu.product_service.mapper.CompanyMapper;
import cn.wcuu.product_service.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Map<Integer,Product> daoMap = new HashMap<>();
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CompanyMapper mapper;

    static {
        Product p1 = new Product(1,"电视",4000, 5);
        Product p2 = new Product(2,"书籍",300, 40);
        daoMap.put(p1.getId(),p1);
        daoMap.put(p2.getId(),p2);
    }

    @Override
    public List<Product> listProduct() {
        Collection<Product> collection = daoMap.values();
        List<Product> list = new ArrayList<>(collection);
        return list;
    }

    @Override
    public Product findById(int id) {
        logger.info("service findById");
        return daoMap.get(id);
    }

    @Override
    public int selectCountTotal() {
        return mapper.selectCountTotal();
    }
}