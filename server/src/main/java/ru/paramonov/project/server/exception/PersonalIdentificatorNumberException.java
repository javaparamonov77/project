package ru.paramonov.project.server.exception;

public class PersonalIdentificatorNumberException extends Exception {
    public String toString()
    {
        return "Incorrect Personal Identificator Number(PIN).";
    }
}
