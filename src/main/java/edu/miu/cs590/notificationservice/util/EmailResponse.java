package edu.miu.cs590.notificationservice.util;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmailResponse {
    private HttpStatus httpStatus;
    private int httpCode;
    private boolean success;
    private String message;
    private Objects data;
}
