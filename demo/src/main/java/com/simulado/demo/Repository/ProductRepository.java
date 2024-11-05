package com.simulado.demo.Repository;

import com.simulado.demo.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByProductCategoryID(Integer productId);
}