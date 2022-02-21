package ru.paramonov.project.server.service;

import org.springframework.stereotype.Service;
import ru.paramonov.project.server.common.Account;
import ru.paramonov.project.server.common.Currency;
import ru.paramonov.project.server.exception.NotFoundException;
import ru.paramonov.project.server.repository.AccountRepository;

import java.math.BigDecimal;

@Service
public class AccountService {
    private AccountRepository accountRepository;

    /*
    public Account getByAccountNumber(long accountNumber) {
        Account account = accountRepository.findById(accountNumber);
        if (account == null) {
            throw new NotFoundException(accountNumber);
        }
        return account;
    }

    public Account getByClientId(long clientId) {
        Account account = accountRepository.findById(clientId);
        if (account == null) {
            throw new NotFoundException(clientId);
        }
        return account;
    }

    public Account createAccount(long clientId, long accountNumber, BigDecimal balance, Currency accountCurrency) {
        Account accountCreate = new Account(clientId, balance, accountCurrency);
        //TODO: нужен ли set??
        //accountCreate.set
        return accountRepository.save(accountCreate);
    }

    public void deleteAccount(long accountNumber) {
        if (!accountRepository.existsById(accountNumber)) {
            throw new NotFoundException(accountNumber);
//            Account deleteAccount = accountCrudRepository.findById(accountNumber);
//            accountCrudRepository.delete(deleteAccount);
        }
    }

    //TODO: доработать
    public String updateAccount(long accountNumber, BigDecimal balance, Currency accountCurrency) {
        if (!accountRepository.existsById(accountNumber)) {
            throw new NotFoundException(accountNumber);

            //TODO: нужен ли set??
            //accountCreate.set
//            Account accountCreate = new Account(clientId, accountNumber, balance, accountCurrency, LocalDate.now());
//            return accountCrudRepository.save(accountCreate);
        }
        return "Account with Balance = " + balance + " was created!";
    }
*/
}
    //TODO: реализация
//    public Card getByCardNumber(int cardNumber) {    };

