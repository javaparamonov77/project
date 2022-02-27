package ru.paramonov.project.server.common;

import lombok.Getter;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name = "Accounts")
@Getter
public class Account {
    @Id
    @GeneratedValue
    private long accountNumber;
    private long clientId;
    private BigDecimal balance;
    private Currency accountCurrency;
    private LocalDate creationDate;

    public Account(){}

    public Account(long clientId, BigDecimal balance, Currency accountCurrency) {
        this.clientId = clientId;
        this.balance = balance;
        this.accountCurrency = accountCurrency;
        creationDate = LocalDate.now();
    }
}
