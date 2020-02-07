package com.kostars.newtroshop.web.dto.response;

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
public class KeywordResponseDto {

    private Long keywordId;

    private String keywordName;

    private String keywordDescription;

    private String keywordImage;

    private List<Keyword> keywords;

}
