package com.kostars.newtroshop.web.dto.response;

import com.kostars.newtroshop.domain.product.category.keyword.Keyword;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"keywords"})
public class KeywordResponseDto {

    private Long keywordId;

    private String keywordName;

    private String keywordDescription;

    private String keywordImage;

    private List<Keyword> keywords;

}
