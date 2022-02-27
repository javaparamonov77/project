package ru.paramonov.project.server.common;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cards")
public class LocalCard implements Card {
    @Id
    @GeneratedValue
    private long cardNumber;
    private int personalIdentificationNumber;
    private long accountNumber;

    public LocalCard(){}
    public LocalCard(long accountNumber /* String bankName*/) {
        personalIdentificationNumber = PINGenerator();
        this.accountNumber = accountNumber;
    }

    private int PINGenerator(){
        int min = 1000;
        int max = 8999;
        return min + (int)(Math.random() * max);
    }

    @Override
    public long getAccountNumber() {
        return accountNumber;
    }

    @Override
    public long getCardNumber() {
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