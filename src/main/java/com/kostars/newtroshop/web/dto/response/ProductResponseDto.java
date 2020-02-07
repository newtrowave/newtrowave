package com.kostars.newtroshop.web.dto.request;

import com.kostars.newtroshop.domain.product.Product;
import com.kostars.newtroshop.domain.product.category.Category;
import com.kostars.newtroshop.domain.product.category.keyword.Keyword;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequestDTO {

    private Long productId;

    private String productName;

    private BigDecimal productPrice;

    private String productContent;

    private String productColor;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private int productStock;

    private Product product;

    private List<Category> categories;

    private List<Keyword> keywords;

}
