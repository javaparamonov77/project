package ru.paramonov.project.client;

import ru.paramonov.project.server.Account;

public class LocalCard implements Card {
    private final int cardNumber;
    private final int personalIdentificationNumber;
    private final long accountNumber;

    public LocalCard(int cardNumber, long accountNumber, int personalIdentificationNumber) {
        this.cardNumber = cardNumber;
        this.accountNumber = accountNumber;
        this.personalIdentificationNumber = personalIdentificationNumber;
    }

    @Override
    public long getAccountNumber() {
        return accountNumber;
    }

    @Override
    public int getCardNumber() {
        return cardNumber;
    }

    @Override
    public String getBankName() {
        return "MyBank";
    }

    public int getPersonalIdentificationNumber() {
        return personalIdentificationNumber;
    }
}
