package ru.paramonov.project.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.paramonov.project.server.common.Currency;
import ru.paramonov.project.server.service.AccountService;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;

@RestController
@RequestMapping("/API")
public class APIRestController {
        @Autowired
        AccountService accountService;
        BigDecimal actualBalance;
        Currency accountCurrency;
        ResponseEntity<String> responseEntity;

        @PostMapping("/balance")
        public ResponseEntity<String> getBalance(@RequestHeader("accountNumber") long accountNumber,
                                                 @RequestHeader("cardNumber")long cardNumber,
                                                 @RequestHeader("pin") int pin) {

            try{
                if(accountService.doVerification(cardNumber, accountNumber, pin)){
                    actualBalance = accountService.getBalance(accountNumber);
                    accountCurrency = accountService.getAccountCurrency(accountNumber);
                    responseEntity = new ResponseEntity<>(("actualBalance:" + actualBalance + " / Currency: " + accountCurrency), HttpStatus.OK);
                } else
                    responseEntity = new ResponseEntity<>("Верификация не пройдена", HttpStatus.CONFLICT);
            } catch (EntityNotFoundException e){
                responseEntity = new ResponseEntity<>("Запрашиваемый объект отсутствует в БД", HttpStatus.NOT_FOUND);
            }
            return responseEntity;
        }
    }
