package com.hillel.spring.hillel_spring_homework_with_springboot.exception;

public class NoSuchProductException extends RuntimeException {

    public NoSuchProductException(String message) {
        super(message);
    }
}
