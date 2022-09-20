package edu.miu.cs590.notificationservice.dto;

import lombok.Data;

@Data
public class EmailSenderDto {
    private String sender;
    private String to;
    private String subject;
    private String message;
}
