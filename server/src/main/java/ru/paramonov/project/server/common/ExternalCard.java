package ru.paramonov.project.server.common;

//TODO: выходит за рамки MVP (для дальнейшей проработки)
public class ExternalCard implements Card {
    private final long cardNumber;
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
    public long getCardNumber()  {
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
