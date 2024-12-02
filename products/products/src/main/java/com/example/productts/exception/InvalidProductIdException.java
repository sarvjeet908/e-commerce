package com.example.productts.exception;
//default exception handler
public class InvalidProductIdException extends RuntimeException{/* extends Exception then compile time exception customized */
    public InvalidProductIdException(String s) {
        super(s);
    }
}
