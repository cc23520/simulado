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
public class ProductCategory {
    @Id
    private Integer ProductCategoryId;

    @Column(nullable = false,  length = 100)
    private String name;

    @Column(nullable = false,  length = 100)
    private String Description;




}