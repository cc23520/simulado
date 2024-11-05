package com.simulado.demo.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.simulado.demo.Model.Product;
import com.simulado.demo.Repository.ProductCategoryRepository;
import com.simulado.demo.Repository.ProductRepository;



@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductRepository productRepository;

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        List<Product> productCategories = productRepository.findAll();
        return productCategories.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(productCategories);
        
    }
    
    
}
