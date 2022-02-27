package ru.paramonov.project.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.paramonov.project.server.common.Currency;
import ru.paramonov.project.server.service.AccountService;
import java.math.BigDecimal;

@RestController
@RequestMapping("/API")
public class APIRestController {
        private final AccountService accountService;
        private BigDecimal actualBalance;
        private Currency accountCurrency;
        private ResponseEntity<String> responseEntity;
        private int PINcounter = 3;

    public APIRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/balance")
        public ResponseEntity<String> getBalance(@RequestHeader("accountNumber") long accountNumber,
                                                 @RequestHeader("cardNumber")long cardNumber,
                                                 @RequestHeader("pin") int pin) {
            try{
                if(accountService.isExistsDataDB(cardNumber, accountNumber)){
                    if(accountService.doVerificationPIN(cardNumber, accountNumber, pin)){
                        actualBalance = accountService.getBalance(accountNumber);
                        accountCurrency = accountService.getAccountCurrency(accountNumber);
                        responseEntity = new ResponseEntity<>(("actualBalance:" + actualBalance + " / Currency: " + accountCurrency), HttpStatus.OK);
                    } else {
                        --PINcounter;
                        if (PINcounter > 0) {
                            responseEntity = new ResponseEntity<>("Некорректно введен ПИН-код, оставшееся количество попыток: " + PINcounter, HttpStatus.FORBIDDEN);
                        } else {
                            responseEntity = new ResponseEntity<>("Превышено количество разрешенных попыток ввода ПИН-кода. Карта заблокирована", HttpStatus.LOCKED);
                        }
                    }
                }
                else responseEntity = new ResponseEntity<>("Запрашиваемый объект отсутствует в БД", HttpStatus.NOT_FOUND);
            } catch (Exception e){
                responseEntity = new ResponseEntity<>("Внутренняя ошибка", HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return responseEntity;
        }
    }
