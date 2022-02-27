package ru.paramonov.project.server.common;

public interface Card {
    long cardNumber = 0;
    int personalIdentificationNumber = 0;
    String bankName = null;

    long getCardNumber();
    long getAccountNumber();
    int getPersonalIdentificationNumber();
    String getBankName();


}
