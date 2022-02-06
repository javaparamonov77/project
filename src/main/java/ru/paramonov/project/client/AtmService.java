package ru.paramonov.project.client;

import ru.paramonov.project.exceptions.PersonalIdentificatorNumberException;
import ru.paramonov.project.server.Account;
import ru.paramonov.project.server.AccountRepository;
import ru.paramonov.project.server.CardRepository;
import ru.paramonov.project.server.Verification;

import java.math.BigDecimal;

public class AtmService {
    private final AccountRepository accountRepository;
    private final CardRepository cardRepository;
    private final Card card;
    private Verification verification;
    boolean verificationFlag;
    //TODO: доработка функционала работы с выдачей/внесением наличных
    // private BigDecimal cashAmount;
    // private String message;

    public AtmService (Card card, AccountRepository accountRepository, CardRepository cardRepository){
        this.card = card;
        this.cardRepository = cardRepository;
        this.accountRepository = accountRepository;
    }

    public BigDecimal getBalance() throws PersonalIdentificatorNumberException {
        verification = new Verification(card.getPersonalIdentificationNumber(), card.getCardNumber(), cardRepository);
        verificationFlag = verification.doVerification();
        BigDecimal accountBalance = null;
        if (cardRepository.isCardExists(card.getCardNumber())){
            Card cardInterior = cardRepository.getCardByCardNumber(card.getCardNumber());
            if (accountRepository.isAccountExists(cardInterior.getAccountNumber()) && verificationFlag){
                    Account accountInterior = accountRepository.getAccountByAccountNumber(cardInterior.getAccountNumber());
                    accountBalance = accountInterior.getBalance();
                }
            }
        return accountBalance;
    }
    //TODO: доработка функционала работы с выдачей/внесением наличных
    /*

    public String placementOfCash(){
        message = "Внесена сумма: " + cashAmount;
      return message;
    }
    public String withdrawalOfCash(){
        message = "Сумма снятия: " + cashAmount;
        return message;
    }
    */
}
