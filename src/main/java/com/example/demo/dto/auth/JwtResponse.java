package com.example.demo.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Jwt response DTO")
public record JwtResponse(
        @Schema(description = "User id", example = "1")
        Integer id,

        @Schema(description = "User email", example = "user@gmail.com")
        String email,

        @Schema(description = "User access token", example = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyQG1haWwucnUiLCJpZCI6Miwicm9sZSI6IlJPTEVfVVNFUiIsImV4cCI6MTcxOTI2MjM1NH0.8D7CO2cWDxWdI7SNd_Jy0DOJfnNlAmPSRoglDyiJOKi07QxzI5y8GOOOHK9ezZsCzXyW21_0XPcznlm9AwcZtQ")
        String accessToken,

        @Schema(description = "User refresh token", example = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyQG1haWwucnUiLCJpZCI6Miwicm9sZSI6IlJPTEVfVVNFUiIsImV4cCI6MTcxOTI2MjM1NH0.8D7CO2cWDxWdI7SNd_Jy0DOJfnNlAmPSRoglDyiJOKi07QxzI5y8GOOOHK9ezZsCzXyW21_0XPcznlm9AwcZtQ")
        String refreshToken
) {
}
