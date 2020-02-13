package com.kostars.newtroshop.web.dto.response;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kostars.newtroshop.domain.product.Product;
import com.kostars.newtroshop.domain.product.category.Category;
import com.kostars.newtroshop.domain.product.category.keyword.Keyword;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"products", "categories", "keywords"})
public class ProductResponseDto {

    private Long productId;

    private String productName;

    private BigDecimal productPrice;

    private String productContent;

    private String productColor;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private int productStock;

    private boolean productPublished;

    private List<Product> products;

    private List<Category> categories;

    private List<Keyword> keywords;

}
