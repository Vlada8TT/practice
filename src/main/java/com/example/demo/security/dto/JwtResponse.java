package com.example.demo.security.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Request after login")
public class JwtResponse {

    private Integer id;
    private String email;
    private String accessToken;
    private String refreshToken;

}
