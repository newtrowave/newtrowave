package com.kostars.newtroshop.domain.product.category;

import com.kostars.newtroshop.domain.product.Product;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@ToString(exclude = {"products"})
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    private String categoryName;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
    private List<Product> products;
}
