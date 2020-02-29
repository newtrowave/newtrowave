package com.kostars.newtroshop.web.dto.request;

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
public class ProductRequestDto {

    private Long productId;

    private String productName;

    private BigDecimal productPrice;

    private String productContent;

    private String productColor;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private int productStock;

    private boolean productPublished;

    private List<KeywordRequestDto> keywords;

}
