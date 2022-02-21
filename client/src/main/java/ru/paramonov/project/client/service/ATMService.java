package ru.paramonov.project.client.service;

import org.springframework.stereotype.Service;
import ru.paramonov.project.server.common.Card;
import ru.paramonov.project.server.common.Account;
import ru.paramonov.project.server.exception.PersonalIdentificatorNumberException;
import ru.paramonov.project.server.repository.AccountRepository;
import ru.paramonov.project.server.repository.CardRepository;
import ru.paramonov.project.server.service.Verification;
import java.math.BigDecimal;


public class ATMService {
    private final AccountRepository accountRepository;
    private final CardRepository cardRepository;
    private BigDecimal accountBalance;
    private Verification verification;
    private int pin;
    private int cardNumber;

    public ATMService(AccountRepository accountRepository, CardRepository cardRepository){
        this.cardRepository = cardRepository;
        this.accountRepository = accountRepository;
//        this.pin = pin;
//        this.cardNumber = cardNumber;
    }

    public boolean verificationService (int pin,  int cardNumber) throws PersonalIdentificatorNumberException {
        verification = new Verification(pin, cardNumber, cardRepository);
        return verification.doVerification();
    }


    public BigDecimal getBalance() throws PersonalIdentificatorNumberException {
        boolean verificationFlag = verificationService(pin, cardNumber);
            Card cardInterior = cardRepository.getOne(cardNumber);
            if (accountRepository.existsById(cardInterior.getAccountNumber()) && verificationFlag){
                    Account accountInterior = accountRepository.findById(cardInterior.getAccountNumber());
                    accountBalance = accountInterior.getBalance();
                }
        return accountBalance;
    }
}
