package com.kostars.newtroshop.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    MASTER("ROLE_MASTER", "마스터"),
    ADMIN("ROLE_ADMIN", "관리자"),
    USER("ROLE_USER", "고객");

    private final String key;
    private final String title;

}
