package ru.paramonov.project.client.service;

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
    private final Card card;
    private Verification verification;
    boolean verificationFlag;
    private BigDecimal accountBalance;
    //private String message;

    public ATMService(Card card, AccountRepository accountRepository, CardRepository cardRepository){
        this.card = card;
        this.cardRepository = cardRepository;
        this.accountRepository = accountRepository;
    }

    public BigDecimal getBalance() throws PersonalIdentificatorNumberException {
        verification = new Verification(card.getPersonalIdentificationNumber(), card.getCardNumber(), cardRepository);
        verificationFlag = verification.doVerification();
        if (cardRepository.isCardExists(card.getCardNumber())){
            Card cardInterior = cardRepository.getCardByCardNumber(card.getCardNumber());
            if (accountRepository.isAccountExists(cardInterior.getAccountNumber()) && verificationFlag){
                    Account accountInterior = accountRepository.getAccountByAccountNumber(cardInterior.getAccountNumber());
                    accountBalance = accountInterior.getBalance();
                }
            }
        return accountBalance;
    }

    //TODO: выходит за рамки MVP (для дальнейшей проработки)
    public boolean isLocalCard(Card card){
       return ("MyBank".equals(card.getBankName()));
    }
}
