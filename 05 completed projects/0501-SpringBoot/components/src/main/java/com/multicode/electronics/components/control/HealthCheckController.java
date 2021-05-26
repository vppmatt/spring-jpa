package com.multicode.electronics.components.control;

import com.multicode.electronics.components.domain.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HealthCheckController {

    @GetMapping("/health")
    public String healthCheck() {
        return "ok";
    }

    @GetMapping(value= "/sample")
    public Product sample() {
        Product product = new Product();
        product.setId(123);
        product.setDescriptionId(789);
        product.setCrossSells("Some text");
        product.setCrossSells("Some more text");
        return product;
    }
}
