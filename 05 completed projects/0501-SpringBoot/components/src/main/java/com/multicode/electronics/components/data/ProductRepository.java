package com.multicode.electronics.components.data;

import com.multicode.electronics.components.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
