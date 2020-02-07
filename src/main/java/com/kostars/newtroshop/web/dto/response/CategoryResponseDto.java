package com.kostars.newtroshop.web.dto.response;

import com.kostars.newtroshop.domain.product.category.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryResponseDto {

    private Long categoryId;

    private String categoryName;

    private List<Category> categories;

}
