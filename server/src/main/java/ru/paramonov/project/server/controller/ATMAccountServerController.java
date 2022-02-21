package ru.paramonov.project.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.paramonov.project.server.common.Account;
import ru.paramonov.project.server.common.Currency;
import ru.paramonov.project.server.repository.AccountRepository;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/account_controller")
public class ATMAccountServerController {
    public ATMAccountServerController(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }
    private final AccountRepository accountRepository;

    @GetMapping("/add_account")
    public String getAddAccountPage() {
        return "/account_controller/add_new_account";
    }

    @PostMapping("/accounts")
    public String addAccount (@RequestParam (required = false, name = "clientId")  long clientId,
                              @RequestParam (required = false, name = "balance") BigDecimal balance,
                              @RequestParam (required = false, name = "accountCurrency") Currency accountCurrency){
        Account account = new Account(clientId, balance, accountCurrency);
        accountRepository.save(account);
        return "redirect:/account_controller/accounts";
    }

    @GetMapping("/accounts")
    public String getAccounts (Model model){
        List<Account> accounts = accountRepository.findAll();
        model.addAttribute("accounts", accounts);
        return "/account_controller/accounts";
    }
}
