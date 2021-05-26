package com.multicode.electronics.components.data;

import com.multicode.electronics.components.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    public List<Product> findAllByCrossSellsContains(String value);
    public List<Product> findAllByUpSellsContains(String value);

}
