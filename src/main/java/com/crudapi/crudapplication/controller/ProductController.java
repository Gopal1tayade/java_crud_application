package com.crudapi.crudapplication.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.crudapi.crudapplication.services.ProductService;
import com.crudapi.crudapplication.entity.Product;


import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

  

    @GetMapping
    public Page<Product> getAllProducts(Pageable pageable) {
        return productService.getAllProducts(pageable);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Map<String, Object> productRequest) {
      
        String name = (String) productRequest.get("name");
        int price = (int) Double.parseDouble(productRequest.get("price").toString());
        int categoryId = Integer.parseInt(productRequest.get("categoryId").toString());
      

      
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);

        
        return productService.createProduct(product, categoryId);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }
}

