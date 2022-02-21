package ru.paramonov.project.server.common;

public interface Card {
    int cardNumber = 0;
    int personalIdentificationNumber = 0;
    String bankName = null;

    int getCardNumber();
    long getAccountNumber();
    int getPersonalIdentificationNumber();
    String getBankName();


}
