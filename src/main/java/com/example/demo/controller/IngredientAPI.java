package com.example.demo.controller;

import com.example.demo.dto.exception.ExceptionBody;
import com.example.demo.dto.request.IngredientRequestDto;
import com.example.demo.dto.response.IngredientResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "Ingredient controller", description = "Operations related to ingredient: create, update, get by id, delete by id")
public interface IngredientAPI {
    @Operation(summary = "Create new ingredient(only admin)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ingredient created successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = IngredientResponseDto.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ExceptionBody.class))),
            @ApiResponse(responseCode = "403", description = "Access denied",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ExceptionBody.class))),
            @ApiResponse(responseCode = "404", description = "Ingredient already exists",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ExceptionBody.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ExceptionBody.class))),
    })
    IngredientResponseDto createIngredient(IngredientRequestDto ingredientRequestDto);

    @Operation(summary = "Update ingredient(only admin)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ingredient updated successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = IngredientResponseDto.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ExceptionBody.class))),
            @ApiResponse(responseCode = "403", description = "Access denied",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ExceptionBody.class))),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ExceptionBody.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ExceptionBody.class))),
    })
    IngredientResponseDto update(int id, IngredientRequestDto ingredientRequestDto);

    @Operation(summary = "Get ingredient by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ingredient received successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = IngredientResponseDto.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ExceptionBody.class))),
            @ApiResponse(responseCode = "403", description = "Access denied",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ExceptionBody.class))),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ExceptionBody.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ExceptionBody.class))),
    })
    IngredientResponseDto getById(@PathVariable int id);

    @Operation(summary = "Delete ingredient by id(only admin)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ingredient deleted successfully"),
            @ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ExceptionBody.class))),
            @ApiResponse(responseCode = "403", description = "Access denied",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ExceptionBody.class))),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ExceptionBody.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ExceptionBody.class))),
    })
    void deleteById(@PathVariable int id);
}
