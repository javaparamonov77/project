package ru.paramonov.project.server;
import ru.paramonov.project.client.Card;
import ru.paramonov.project.exceptions.PersonalIdentificatorNumberException;
import java.util.NoSuchElementException;

/**
 * PIN Verification
 */

public class Verification {
    private final CardRepository cardRepository;
    private final int personalIdentificationNumber;
    private final int cardNumber;

    public Verification (int personalIdentificationNumber, int cardNumber, CardRepository cardRepository) {
        this.cardNumber = cardNumber;
        this.personalIdentificationNumber = personalIdentificationNumber;
        this.cardRepository = cardRepository;
    }

    public boolean doVerification() throws PersonalIdentificatorNumberException {
        boolean resultOfVerification;
        if (cardRepository.isCardExists(cardNumber)){
            Card card = cardRepository.getCardByCardNumber(cardNumber);
            if (card.getCardNumber() == cardNumber && card.getPersonalIdentificationNumber() == personalIdentificationNumber)
                resultOfVerification = true;
            else throw new PersonalIdentificatorNumberException();
        } else
            throw new NoSuchElementException();
        return resultOfVerification;
    }
}
