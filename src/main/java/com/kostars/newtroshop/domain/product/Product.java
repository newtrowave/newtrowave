package com.kostars.newtroshop.domain.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@DynamicInsert
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String productName;

    private BigDecimal productPrice;

    private String productContent;

    private String productColor;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private int productStock;

}
