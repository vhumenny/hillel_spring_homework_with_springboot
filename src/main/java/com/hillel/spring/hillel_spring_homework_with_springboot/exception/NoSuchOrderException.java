package com.hillel.spring.hillel_spring_homework_with_springboot.exception;

public class NoSuchOrderException extends RuntimeException {

    public NoSuchOrderException(String message) {
        super(message);
    }
}
