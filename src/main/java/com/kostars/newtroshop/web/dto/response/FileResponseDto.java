package com.kostars.newtroshop.web.dto.response;

import com.kostars.newtroshop.domain.product.Files;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileResponseDto {

    private List<Files> files;

}
