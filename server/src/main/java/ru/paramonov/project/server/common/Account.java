package ru.paramonov.project.server.common;

import lombok.Getter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class Account {
    private final long accountNumber;
    private final BigDecimal balance;
    private final Currency accountCurrency;
    private final LocalDate creationDate;

    public Account(long accountNumber, BigDecimal balance, Currency accountCurrency, LocalDate creationDate) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountCurrency = accountCurrency;
        this.creationDate = creationDate;
    }
}
