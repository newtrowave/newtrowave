package com.kostars.newtroshop.web.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KeywordRequestDto {

    private Long keywordId;

    private String keywordName;

    private String keywordDescription;

    private String keywordImage;

}
