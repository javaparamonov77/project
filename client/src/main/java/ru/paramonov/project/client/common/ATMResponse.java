package ru.paramonov.project.client.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ATMResponse{
    private final boolean successfull;
    private String message;

    public ATMResponse(boolean successfull, String message) {
        this.successfull = successfull;
        this.message = message;
    }

    @Override
    public String toString() {
        return "AtmResponse{" +
                "successfull=" + successfull +
                ", message ='" + message + '\'' +
                '}';
    }
}