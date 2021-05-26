package com.multicode.electronics.components.service;

import com.multicode.electronics.components.domain.*;
import org.springframework.stereotype.*;

import java.util.*;

public interface ProductService {

    public List<Product> getAllProducts();
    public Optional<Product> getById(int id);
    public List<Product> getAllProductsWithACrossSellIncluding(Integer Id);
    public List<Product> getAllProductsWithAnUpSellIncluding(Integer id);
    public Integer addProduct(Product product);
}
