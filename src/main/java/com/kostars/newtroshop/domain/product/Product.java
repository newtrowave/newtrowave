package com.kostars.newtroshop.domain.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kostars.newtroshop.domain.product.category.Category;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicInsert
@Builder
@ToString(exclude = {"categories", "files"})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String productName;

    private BigDecimal productPrice;

    private String productContent;

    private String productColor;

    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

    private int productStock;

    private boolean productPublished;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<Files> files;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "productCategory", joinColumns = @JoinColumn(name = "productId")
    , inverseJoinColumns = @JoinColumn(name = "categoryId"))
    @JsonIgnore
    private List<Category> categories;

}
