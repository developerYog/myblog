package com.myblogrestapi.payload;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
public class PostDto {
    private long id;
    @NotEmpty(message = "Field cant be empty")
    @Min(value = 3, message = "Kindly enter a valid Title")
    private String title;
    @NotEmpty(message = "Field cant be empty")
    private String description;
    @NotEmpty(message = "Field cant be empty")
    private String content;
}
