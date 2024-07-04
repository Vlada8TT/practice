package com.example.demo.controller.impl;

import com.example.demo.controller.AddressAPI;
import com.example.demo.dto.exception.ExceptionBody;
import com.example.demo.dto.request.AddressRequestDto;
import com.example.demo.dto.request.UserRequestDto;
import com.example.demo.dto.response.AddressResponseDto;
import com.example.demo.dto.response.CategoryResponseDto;
import com.example.demo.dto.response.UserResponseDto;
import com.example.demo.dto.validation.OnCreate;
import com.example.demo.service.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController implements AddressAPI {

    private final AddressService addressService;

    @PostMapping("/{userId}/add")
    @PreAuthorize("canAccessUser(#userId)")
    public AddressResponseDto addAddress(
            @PathVariable Integer userId,
            @Validated(OnCreate.class)
            @RequestBody AddressRequestDto addressRequestDto) {
        return addressService.addAddress(userId, addressRequestDto);
    }
}
