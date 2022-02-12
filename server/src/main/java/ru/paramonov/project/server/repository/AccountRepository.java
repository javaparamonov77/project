package ru.paramonov.project.server.repository;

import ru.paramonov.project.server.common.Account;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AccountRepository {

    /**
     * allAccounts - репозиторий счетов
     */

    private final Set<Account> allAccounts = new HashSet<>();

    /**
     * Вывод множества счетов в Stream'е
     * @return Stream
     */
    public Stream<Account> getAccounts() {
        return allAccounts.stream();
    }

    public void addAccount(Account account) {
        allAccounts.add(account);
    }

    public boolean isAccountExists (long accountNumber) {
        boolean result = false;
        for (Account account : getAccounts().collect(Collectors.toSet())) {
            if (account.getAccountNumber() == accountNumber) {
                result = true;
                break;
            }
        }
        return result;
    }

    public Account getAccountByAccountNumber(long accountNumber) {
        Account accountExt = null;
        for (Account account : getAccounts().collect(Collectors.toSet())) {
            if (account.getAccountNumber() == accountNumber) {
                accountExt = account;
            }
        }
        return accountExt;
    }
}