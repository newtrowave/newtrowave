package com.kostars.newtroshop.domain.product.category;

import com.kostars.newtroshop.domain.product.Product;

import javax.persistence.*;

@Entity
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

}
