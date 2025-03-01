package com.capgeminitrainning.AddressBookApp.exception;

//custom exception
public class AddressNotFoundException extends RuntimeException{
    public AddressNotFoundException(String message){
        super(message);
    }
}