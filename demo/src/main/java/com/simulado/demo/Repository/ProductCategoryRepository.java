package com.simulado.demo.Repository;

import com.simulado.demo.Model.Product;
import com.simulado.demo.Model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {


}