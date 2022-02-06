package ru.paramonov.project.server;

import ru.paramonov.project.client.Card;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CardRepository {
    /**
     * allCards - репозиторий карт
     */

    private final Set<Card> allCards = new HashSet<>();

    /**
     * Вывод множества карт в Stream'е
     * @return Stream
     */
    public Stream<Card> getCards() {
        return allCards.stream();
    }

    public void addCard (Card card) {
        allCards.add(card);
    }

    public boolean isCardExists (int cardNumber) {
        boolean result = false;
        for (Card card : getCards().collect(Collectors.toSet())) {
            if (card.getCardNumber() == cardNumber) {
                result = true;
                break;
            }
        }
        return result;
    }

    public Card getCardByCardNumber(int cardNumber) {
        Card cardExt = null;
        for (Card card : getCards().collect(Collectors.toSet())) {
            if (card.getCardNumber() == cardNumber) {
                cardExt = card;
            }
        }
        return cardExt;
    }

}
