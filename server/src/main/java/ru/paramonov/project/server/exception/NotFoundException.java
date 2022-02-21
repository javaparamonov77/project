package ru.paramonov.project.server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    public NotFoundException(int id) {
        super("Card with ID " + id + " not found");
    }
    public NotFoundException(long id) {
        super("Account or Client with number " + id + " not found");
    }
    //TODO: нужна ли стринговая реализация?
    public NotFoundException(String name) {
        super("Card with ID " + name + " not found");
    }
}
