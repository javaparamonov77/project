package ru.paramonov.project.exceptions;

public class PersonalIdentificatorNumberException extends Exception {
    public String toString()
    {
        return "Incorrect Personal Identificator Number(PIN).";
    }
}
