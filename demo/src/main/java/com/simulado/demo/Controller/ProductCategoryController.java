package com.simulado.demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PatchExchange;

import com.simulado.demo.Model.Product;
import com.simulado.demo.Model.ProductCategory;
import com.simulado.demo.Repository.ProductCategoryRepository;
import com.simulado.demo.Repository.ProductRepository;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/productcategories")
public class ProductCategoryController {

    private ProductCategoryRepository productCategoryRepository;
    private ProductRepository productRepository;

    @GetMapping
    public ResponseEntity<List<ProductCategory>> getAll() {
        List<ProductCategory> productCategories = productCategoryRepository.findAll();
        return productCategories.isEmpty() ? ResponseEntity.noContent().build(): ResponseEntity.ok(productCategories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductCategory> getOne(@PathVariable Integer id){
        return productCategoryRepository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<Product> getProducts(@PathVariable Integer id){

    }
    



}
