package com.multicode.electronics.components.control;

import com.multicode.electronics.components.domain.*;
import com.multicode.electronics.components.exceptions.*;
import com.multicode.electronics.components.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import java.sql.*;
import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping(value= "/{id}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE} )
    public Product getProductById(@PathVariable("id") int id) {
        Optional<Product> product = productService.getById(id);
        if (product.isPresent()) {
            return product.get();
        }
        else {
            //TODO deal with this problem
            return null;
        }
    }

    public List<Product> getAllProductsWithACrossSellIncluding(int id) {
        return productService.getAllProductsWithACrossSellIncluding(id);
    }

    public List<Product> getAllProductsWithAnUpSellIncluding(int id) {
        return productService.getAllProductsWithAnUpSellIncluding(id);
    }

    @GetMapping(produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public Object getAllProductsOrSearchForProducts(
            @RequestParam(value="cross-sells", required = false) Integer crossSellsId,
            @RequestParam(value="up-sells", required = false) Integer upsellsId) {
                if (crossSellsId != null) return getAllProductsWithACrossSellIncluding(crossSellsId);
                if (upsellsId != null) return getAllProductsWithAnUpSellIncluding(upsellsId);
                return getAllProducts();
    }

    @PostMapping
    public Integer newProduct(@RequestBody Product product) {
        try {
            return productService.addProduct(product);
        }
        catch (Exception e) {
            throw new BadRequestException("Unknown error");
        }
    }

    @GetMapping("/errortest")
    public Object iAmGoingToReturnA406Code(HttpServletResponse response) {
        response.setStatus(406);
        return null;
    }
}
