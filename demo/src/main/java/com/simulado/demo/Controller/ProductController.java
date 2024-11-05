package com.simulado.demo.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException.NotFound;

import com.simulado.demo.Model.Product;
import com.simulado.demo.Model.ProductReview;
import com.simulado.demo.Repository.ProductCategoryRepository;
import com.simulado.demo.Repository.ProductRepository;
import com.simulado.demo.Repository.ProductReviewRepository;



@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductRepository productRepository;
    private ProductReviewRepository productReviewRepository;

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        List<Product> productCategories = productRepository.findAll();
        return productCategories.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(productCategories);
    }

    

    @GetMapping("/{id}")
    public ResponseEntity<Product> getOne(@PathVariable Integer id){
        return productRepository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/reviews")
       public ResponseEntity<List<ProductReview>> getProducts(@PathVariable Integer id){
        List<ProductReview> reviews = productReviewRepository.findByProductId(id);
        return reviews.isEmpty()
            ? ResponseEntity.noContent().build()
            : ResponseEntity.ok(reviews);
        }   
    
    
}
