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
public class Supplier {
    @Id
    private Integer SupplierId;

    @Column(nullable = false,  length = 100)
    private String name;

    @Column(nullable = false,  length = 100)
    private String Address;

    @Column(nullable = false,  length = 100)
    private String City;

    @Column(nullable = false,  length = 100)
    private String State;

    @Column(nullable = false,  length = 100)
    private String PostalCode;




}