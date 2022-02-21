package ru.paramonov.project.server.common;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "Clients")
@Getter
public class Client {
    @Id
    @GeneratedValue
    private final long clientId;
    private final String clientName;
    private final String clientSurname;
    private final String clientPatronymic;
    private final LocalDate birthDate;

    public Client(long clientId, String clientName, String clientSurname, String clientPatronymic, LocalDate birthDate) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientSurname = clientSurname;
        this.clientPatronymic = clientPatronymic;
        this.birthDate = birthDate;
    }
}
