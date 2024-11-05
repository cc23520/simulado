package com.simulado.demo.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient.ResponseSpec;

import com.simulado.demo.Model.Product;
import com.simulado.demo.Model.ProductReview;
import com.simulado.demo.Model.Supplier;
import com.simulado.demo.Repository.ProductRepository;
import com.simulado.demo.Repository.SupplierRepository;



@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    private SupplierRepository supplierRepository;
    private ProductRepository productRepository;

    @GetMapping
    public ResponseEntity<List<Supplier>> getAll(){
        List<Supplier> suppliers =  supplierRepository.findAll();
            return suppliers.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(suppliers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getOne(@PathVariable Integer id){
        return supplierRepository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/{id}/products")
       public ResponseEntity<List<Product>> getProducts(@PathVariable Integer id){
        List<Product> products = productRepository.findBySupplierId(id);
        return products.isEmpty()
            ? ResponseEntity.noContent().build()
            : ResponseEntity.ok(products);
        } 
}
