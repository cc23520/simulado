package com.simulado.demo.Repository;

import com.simulado.demo.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {


}