package com.simulado.demo.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PatchExchange;

import com.simulado.demo.Model.Product;
import com.simulado.demo.Model.ProductCategory;
import com.simulado.demo.Repository.ProductCategoryRepository;
import com.simulado.demo.Repository.ProductRepository;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;


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
    public ResponseEntity<List<Product>> getProducts(@PathVariable Integer id){
        List<Product> products = productRepository.findByProductCategoryID(id);
        return products.isEmpty()
            ? ResponseEntity.noContent().build()
            : ResponseEntity.ok(products);
    }


    @PostMapping("/productCategory")
    public ProductCategory post(@RequestBody ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }


    @PutMapping("/productCategory/{id}")
    public ProductCategory put(@PathVariable Integer id, @RequestBody ProductCategory productCategory){


        Optional<ProductCategory> pd = productCategoryRepository.findById(id);
        productCategoryRepository.delete(pd);


        return productCategoryRepository.save(productCategory);
    }




    



}
