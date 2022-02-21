package ru.paramonov.project.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.paramonov.project.server.common.Card;
import ru.paramonov.project.server.exception.PersonalIdentificatorNumberException;
import ru.paramonov.project.server.repository.CardRepository;

import java.util.NoSuchElementException;

/**
 * PIN Verification
 */


//@Service
public class Verification {
    private CardRepository cardRepository;
    private final int personalIdentificationNumber;
    private final int cardNumber;

//    public void setCardRepository(CardRepository cardRepository) {
//        this.cardRepository = cardRepository;
//    }

//    public Verification (int personalIdentificationNumber, int cardNumber) {
//        this.cardNumber = cardNumber;
//        this.personalIdentificationNumber = personalIdentificationNumber;
//    }
    public Verification (int personalIdentificationNumber, int cardNumber, CardRepository cardRepository) {
        this.cardNumber = cardNumber;
        this.personalIdentificationNumber = personalIdentificationNumber;
        this.cardRepository = cardRepository;
    }

    public boolean doVerification() throws PersonalIdentificatorNumberException {
        boolean resultOfVerification;
        if (cardRepository.existsById(cardNumber)){
            Card card = cardRepository.getOne(cardNumber);
            if (card.getCardNumber() == cardNumber && card.getPersonalIdentificationNumber() == personalIdentificationNumber)
                resultOfVerification = true;
            else
                throw new PersonalIdentificatorNumberException();
        } else
        //TODO: подумать как обрабатывать ситуацию, если в самом репозитории такой карты нет
            throw new NoSuchElementException();
        return resultOfVerification;
    }
}
