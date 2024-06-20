package com.example.demo.dto.exception;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class MultiExceptionBody {

    private String message;
    private Map<String, String> errors;

    public MultiExceptionBody(String message) {
        this.message = message;
    }

}
