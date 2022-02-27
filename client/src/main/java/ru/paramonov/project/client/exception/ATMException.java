package ru.paramonov.project.client.exception;

public class ATMException extends RuntimeException{

    public ATMException(){
        super();
    }
    public ATMException(String message){
        super(message);
    }
}
