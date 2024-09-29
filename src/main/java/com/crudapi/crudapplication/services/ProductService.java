package com.crudapi.crudapplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.crudapi.crudapplication.repository.ProductRepo;
import com.crudapi.crudapplication.entity.Category;
import com.crudapi.crudapplication.entity.Product;
@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepository;

    @Autowired
    private CategoryServices categoryServices;

   

    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product createProduct(Product product , int categoryId) {
         Category category = categoryServices.getCategoryById(categoryId);
         product.setCategory(category);
         product.setproductCategory(category.getName());
        return productRepository.save(product);
    }

    public Product updateProduct(int id, Product product) {
        Product existingProduct =getProductById(id);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        return productRepository.save(existingProduct);
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}

