package com.simulado.demo.Repository;

import com.simulado.demo.Model.Product;
import com.simulado.demo.Model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {


}