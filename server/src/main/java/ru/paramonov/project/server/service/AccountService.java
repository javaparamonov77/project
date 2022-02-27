package ru.paramonov.project.server.service;

import org.springframework.stereotype.Service;
import ru.paramonov.project.server.common.Account;
import ru.paramonov.project.server.common.Card;
import ru.paramonov.project.server.common.Currency;
import ru.paramonov.project.server.common.LocalCard;
import ru.paramonov.project.server.repository.AccountRepository;
import ru.paramonov.project.server.repository.LocalCardRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final LocalCardRepository cardRepository;

    public AccountService(AccountRepository accountRepository, LocalCardRepository cardRepository) {
        this.accountRepository = accountRepository;
        this.cardRepository = cardRepository;
    }

    public Optional<Card> getCardByCardNumber(long cardNumber) {
        return Optional.of(cardRepository.getOne(cardNumber));
    }

    public Optional<Account> getAccountByAccountNumber(long accountNumber) {
        return Optional.of(accountRepository.getOne(accountNumber));
    }


    public boolean cardIsPresent(long cardNumber) {
        return cardRepository.existsById(cardNumber);
    }

    public boolean accountIsPresent(long accountNumber) {
        return accountRepository.existsById(accountNumber);
    }

    public Stream<Account> getAllAccounts() {
        List<Account> list = accountRepository.findAll();
        return list.stream();
    }

    public Stream<LocalCard> getAllCards() {
        List<LocalCard> list = cardRepository.findAll();
        return list.stream();
    }

    public boolean doVerificationPIN(long cardNumber, long accountNumber, int pin) {
        boolean result = false;
        if (cardIsPresent(cardNumber) && accountIsPresent(accountNumber)) {
            Card card = getCardByCardNumber(cardNumber).get();
            if (card.getAccountNumber() == accountNumber) {
                if (card.getPersonalIdentificationNumber() == pin) {
                    result = true;
                }
            }
        }
        return result;
    }

    public boolean isExistsDataDB (long cardNumber, long accountNumber) {
        return cardIsPresent(cardNumber) && accountIsPresent(accountNumber);
    }


   public BigDecimal getBalance ( long accountId) {
            Account account = getAccountByAccountNumber(accountId).get();
            return account.getBalance();
        }

    public Currency getAccountCurrency (long accountId) {
        Account account = getAccountByAccountNumber(accountId).get();
        return account.getAccountCurrency();
    }
}

