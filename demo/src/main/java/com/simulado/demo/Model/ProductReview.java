package com.simulado.demo.Model;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;

import java.util.Date;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ProductReview {
    @Id
    private Integer ProductReviewId;

    @OneToMany
    @JoinColumn(name = "Product.ProductId")

    @Column(nullable = false,  length = 100)
    private String ReviewerName;

    @Column(nullable = false)
    private Double UnitPrice;

    @Column(nullable = false)
    private LocalDateTime ReviewDate;

    @Column(nullable = false)
    private int Rating;

    @Column(nullable = false,  length = 100)
    private String Comments;


}