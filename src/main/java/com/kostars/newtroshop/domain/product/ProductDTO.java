package com.kostars.newtroshop.domain.product;

import com.kostars.newtroshop.domain.product.category.Category;
import com.kostars.newtroshop.domain.product.category.keyword.Keyword;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

    private Product product;

    private List<Category> categories;

    private List<Keyword> keywords;

}
