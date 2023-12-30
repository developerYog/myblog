package com.myblogrestapi.exception;

import lombok.Getter;
@Getter
public class BlogApiException extends RuntimeException{

    public BlogApiException(String message) {
        super(message);
    }

    public BlogApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
