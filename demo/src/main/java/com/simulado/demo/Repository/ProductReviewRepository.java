package com.simulado.demo.Repository;

import com.simulado.demo.Model.Product;
import com.simulado.demo.Model.ProductCategory;
import com.simulado.demo.Model.ProductReview;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReviewRepository extends JpaRepository<ProductReview, Integer> {
    List<ProductReview> findByProductId(Integer id);


}