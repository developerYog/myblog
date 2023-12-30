package com.myblogrestapi.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private long id;
    @NotEmpty(message = "Name cant be left empty")
    @Min(value = 3, message = "Please enter a valid name")
    private String name;
    @NotEmpty(message = "Please enter a message cant left empty")
    private String body;
    @Email
    private String email;
}
