package edu.miu.cs590.notificationservice.util;


import org.springframework.http.HttpStatus;

import java.util.Objects;

public class NotificationUtility {
    public static EmailResponse getSuccessfulServerResponse(String message){
        return EmailResponse.builder()
                .success(true)
                .message(message)
                .httpStatus(HttpStatus.OK)
                .httpCode(HttpStatus.OK.value())
                .build();

    }

    public static EmailResponse getSuccessfulServerResponse(Object data, String message){
        return EmailResponse.builder()
                .success(true)
                .message(message)
                .data((Objects) data)
                .httpStatus(HttpStatus.OK)
                .httpCode(HttpStatus.OK.value())
                .build();

    }

    public static EmailResponse getFailedServerResponse(String message){
        return EmailResponse.builder()
                .success(false)
                .message(message)
                .httpStatus(HttpStatus.NOT_ACCEPTABLE)
                .httpCode(HttpStatus.NOT_ACCEPTABLE.value())
                .build();

    }

    public static EmailResponse getFailedServerResponse(Object data, String message){
        return EmailResponse.builder()
                .success(false)
                .message(message)
                .data((Objects) data)
                .httpStatus(HttpStatus.NOT_ACCEPTABLE)
                .httpCode(HttpStatus.NOT_ACCEPTABLE.value())
                .build();

    }

}
