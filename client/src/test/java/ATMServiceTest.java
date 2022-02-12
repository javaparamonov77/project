import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.paramonov.project.server.common.Card;
import ru.paramonov.project.client.common.LocalCard;
import ru.paramonov.project.client.service.ATMService;
import ru.paramonov.project.server.common.Account;
import ru.paramonov.project.server.common.Currency;
import ru.paramonov.project.server.exception.PersonalIdentificatorNumberException;
import ru.paramonov.project.server.repository.AccountRepository;
import ru.paramonov.project.server.repository.CardRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ATMServiceTest {

    AccountRepository accountRepository = new AccountRepository();
    CardRepository cardRepository = new CardRepository();

    @BeforeEach
    void setUp() {
        Account account1 = new Account(11111111, BigDecimal.TEN, Currency.USD, LocalDate.now());
        Account account2 = new Account(11111112, BigDecimal.ONE, Currency.EUR, LocalDate.now());
        Account account3 = new Account(11111113, BigDecimal.valueOf(150000.20), Currency.RUB, LocalDate.now().minusDays(1));
        Account account4 = new Account(11111114, BigDecimal.valueOf(250000.21), Currency.RUB, LocalDate.now().minusDays(2));
        Account account5 = new Account(11111115, BigDecimal.valueOf(350000.32), Currency.RUB, LocalDate.now().minusDays(3));
        Account account6 = new Account(11111116, BigDecimal.valueOf(450000.45), Currency.RUB, LocalDate.now().minusDays(4));
        Account account7 = new Account(11111117, BigDecimal.valueOf(550000.66), Currency.RUB, LocalDate.now().minusDays(5));
        Account account8 = new Account(11111118, BigDecimal.valueOf(650000.77), Currency.RUB, LocalDate.now().minusDays(6));
        Account account9 = new Account(11111119, BigDecimal.valueOf(750000.89), Currency.RUB, LocalDate.now().minusDays(7));

        accountRepository.addAccount(account1);
        accountRepository.addAccount(account2);
        accountRepository.addAccount(account3);
        accountRepository.addAccount(account4);
        accountRepository.addAccount(account5);
        accountRepository.addAccount(account6);
        accountRepository.addAccount(account7);
        accountRepository.addAccount(account8);
        accountRepository.addAccount(account9);

        List<Account> accounts = new ArrayList<Account>() {{
            add(account1);
            add(account2);
            add(account3);
            add(account4);
            add(account5);
            add(account6);
            add(account7);
            add(account8);
            add(account9);
        }};

        Card card1 = new LocalCard(211111111, 11111111, 1234);
        Card card2 = new LocalCard(211111112, 11111112, 1234);
        Card card3 = new LocalCard(211111113, 11111113, 1234);
        Card card4 = new LocalCard(211111114, 11111114, 1234);
        Card card5 = new LocalCard(211111115, 11111115, 1234);
        Card card6 = new LocalCard(211111116, 11111116, 1234);
        Card card7 = new LocalCard(211111117, 11111117, 1234);
        Card card8 = new LocalCard(211111118, 11111118, 1234);
        Card card9 = new LocalCard(211111119, 11111119, 1234);

        cardRepository.addCard(card1);

        cardRepository.addCard(card1);
        cardRepository.addCard(card2);
        cardRepository.addCard(card3);
        cardRepository.addCard(card4);
        cardRepository.addCard(card5);
        cardRepository.addCard(card6);
        cardRepository.addCard(card7);
        cardRepository.addCard(card8);
        cardRepository.addCard(card9);

        List<Card> cards = new ArrayList<Card>() {{
            add(card1);
            add(card2);
            add(card3);
            add(card4);
            add(card5);
            add(card6);
            add(card7);
            add(card8);
            add(card9);
        }};

    }

    @Test
    public void testPositiveGetBalance() throws PersonalIdentificatorNumberException {
        ATMService atmService =
                new ATMService(new LocalCard(211111115, 11111115, 1234), accountRepository, cardRepository);
        BigDecimal result = atmService.getBalance();
        Assertions.assertEquals(new BigDecimal("350000.32"), result);

    }

    @Test
    public void nonExistingCardNumberGetBalance() {
        ATMService atmService =
                new ATMService(new LocalCard(287777119, 11111115, 1234), accountRepository, cardRepository);
        assertThrows(NoSuchElementException.class,
                atmService::getBalance);
    }

    @Test
    public void nonExistingAccountNumberGetBalance() {
        ATMService atmService =
                new ATMService(new LocalCard(11111115, 287777119, 1234), accountRepository, cardRepository);
        assertThrows(NoSuchElementException.class,
                atmService::getBalance);
    }

    @Test
    public void incorrectPINGetBalance() {
        ATMService atmService =
                new ATMService(new LocalCard(211111117, 11111117, 7777), accountRepository, cardRepository);
        assertThrows(PersonalIdentificatorNumberException.class,
                atmService::getBalance);

    }
}