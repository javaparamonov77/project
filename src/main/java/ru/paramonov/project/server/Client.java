package ru.paramonov.project.server;

import lombok.Getter;

@Getter
public class Client {
    private final String clientName;
    private final String clientSurname;
    private final String clientPatronymic;

    public Client(String clientName, String clientSurname, String clientPatronymic) {
        this.clientName = clientName;
        this.clientSurname = clientSurname;
        this.clientPatronymic = clientPatronymic;
    }
}
