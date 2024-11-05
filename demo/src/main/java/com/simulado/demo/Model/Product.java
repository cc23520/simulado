package com.simulado.demo.Model;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Product {
    @Id
    private Integer ProductId;

    @ManyToOne
    @JoinColumn(name = "ProductCategory.ProductCategoryId")

    @Column(nullable = false,  length = 100)
    private String name;

    @Column(nullable = false)
    private Double UnitPrice;

    @Column(nullable = false)
    private int UnitsInStock;

    @Column(nullable = false)
    private boolean Discounted;


}