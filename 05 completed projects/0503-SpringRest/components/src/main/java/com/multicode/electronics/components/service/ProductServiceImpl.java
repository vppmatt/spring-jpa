package com.multicode.electronics.components.service;

import com.multicode.electronics.components.data.*;
import com.multicode.electronics.components.domain.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public Optional<Product> getById(int id) { return productRepository.findById(id);}

    public List<Product> getAllProductsWithACrossSellIncluding(Integer id) {
        return productRepository.findAllByCrossSellsContains(id.toString());
    }

    public List<Product> getAllProductsWithAnUpSellIncluding(Integer id) {
        System.out.println("findAllByUpSellsContains "  + id);
        return productRepository.findAllByUpSellsContains(id.toString());
    };

    public Integer addProduct(Product product) {
        Product result = productRepository.save(product);
        return result.getId();
    }
}
