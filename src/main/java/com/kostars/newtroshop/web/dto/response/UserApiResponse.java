package com.kostars.newtroshop.web.dto.response;

import com.kostars.newtroshop.domain.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserApiResponse {

    private Long id;

    private String name;

    private String email;

    private String picture;

    private Role role;

    private String phoneNumber;

    private LocalDateTime registeredAt;

    private LocalDateTime updatedAt;
}
