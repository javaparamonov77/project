package ru.paramonov.project.server.service;

import org.springframework.stereotype.Service;
import ru.paramonov.project.server.common.Account;
import ru.paramonov.project.server.common.Card;
import ru.paramonov.project.server.common.LocalCard;
import ru.paramonov.project.server.exception.NotFoundException;
import ru.paramonov.project.server.repository.AccountRepository;
import ru.paramonov.project.server.repository.CardRepository;

import java.util.stream.Collectors;

@Service
public class CardService {
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    private CardRepository cardRepository;


//
//    public boolean isCardExists (int cardNumber) {
//        return cardRepository.existsById(cardNumber);
//    }


}



