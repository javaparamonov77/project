package ru.paramonov.project.client;

public class ExternalCard implements Card{
    private final int cardNumber;
    private final int personalIdentificationNumber;
    private final long accountNumber;

    public ExternalCard(int cardNumber, long accountNumber, int personalIdentificationNumber) {
        this.cardNumber = cardNumber;
        this.accountNumber = accountNumber;
        this.personalIdentificationNumber = personalIdentificationNumber;
    }

    @Override
    public long getAccountNumber()  {
        return accountNumber;
    }

    @Override
    public int getCardNumber()  {
        return cardNumber;
    }

    @Override
    public String getBankName() {
        return "ExternalBank";
    }

    @Override
    public int getPersonalIdentificationNumber() {
        return personalIdentificationNumber;
    }
}
