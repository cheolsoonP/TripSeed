package com.ssafy.auth;

import java.time.LocalDateTime;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@EntityScan
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    private String email;
    private String pw;
    private UserRole role;
    
    private Long id;                                        // 고유번호
    private LocalDateTime createdAt;                        // 등록 일자

    private LocalDateTime updatedAt;                        // 수정 일자
    private Boolean isEnable = true;   
}