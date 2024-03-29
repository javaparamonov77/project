import ru.paramonov.project.server.common.Card;
import ru.paramonov.project.server.common.LocalCard;
import ru.paramonov.project.server.repository.AccountRepository;
import ru.paramonov.project.server.repository.LocalCardRepository;
import java.util.ArrayList;
import java.util.List;

public class ATMServiceTest {

    AccountRepository accountRepository;
    LocalCardRepository cardRepository;

//    @BeforeEach
//    void setUp() {
//        Account account1 = new Account(111, 11111111, BigDecimal.TEN, Currency.USD);
//        Account account2 = new Account(222, 11111112, BigDecimal.ONE, Currency.EUR);
//        Account account3 = new Account(333, 11111113, BigDecimal.valueOf(150000.20), Currency.RUB);
//        Account account4 = new Account(111, 11111114, BigDecimal.valueOf(250000.21), Currency.RUB);
//        Account account5 = new Account(222, 11111115, BigDecimal.valueOf(350000.32), Currency.RUB);
//        Account account6 = new Account(333, 11111116, BigDecimal.valueOf(450000.45), Currency.RUB);
//        Account account7 = new Account(444, 11111117, BigDecimal.valueOf(550000.66), Currency.RUB);
//        Account account8 = new Account(555, 11111118, BigDecimal.valueOf(650000.77), Currency.RUB);
//        Account account9 = new Account(666, 11111119, BigDecimal.valueOf(750000.89), Currency.RUB);
//
//        accountRepository.addAccount(account1);
//        accountRepository.addAccount(account2);
//        accountRepository.addAccount(account3);
//        accountRepository.addAccount(account4);
//        accountRepository.addAccount(account5);
//        accountRepository.addAccount(account6);
//        accountRepository.addAccount(account7);
//        accountRepository.addAccount(account8);
//        accountRepository.addAccount(account9);
//
//        List<Account> accounts = new ArrayList<Account>() {{
//            add(account1);
//            add(account2);
//            add(account3);
//            add(account4);
//            add(account5);
//            add(account6);
//            add(account7);
//            add(account8);
//            add(account9);
//        }};

//        Card card1 = new LocalCard(211111111, 11111111, 1234);
//        Card card2 = new LocalCard(211111112, 11111112, 1234);
//        Card card3 = new LocalCard(211111113, 11111113, 1234);
//        Card card4 = new LocalCard(211111114, 11111114, 1234);
//        Card card5 = new LocalCard(211111115, 11111115, 1234);
//        Card card6 = new LocalCard(211111116, 11111116, 1234);
//        Card card7 = new LocalCard(211111117, 11111117, 1234);
//        Card card8 = new LocalCard(211111118, 11111118, 1234);
//        Card card9 = new LocalCard(211111119, 11111119, 1234);

        Card card1 = new LocalCard(211111111);
        Card card2 = new LocalCard(211111112);
        Card card3 = new LocalCard(211111113);
        Card card4 = new LocalCard(211111114);
        Card card5 = new LocalCard(211111115);
        Card card6 = new LocalCard(211111116);
        Card card7 = new LocalCard(211111117);
        Card card8 = new LocalCard(211111118);
        Card card9 = new LocalCard(211111119);

//        cardRepository.addCard(card1);
//
//        cardRepository.addCard(card1);
//        cardRepository.addCard(card2);
//        cardRepository.addCard(card3);
//        cardRepository.addCard(card4);
//        cardRepository.addCard(card5);
//        cardRepository.addCard(card6);
//        cardRepository.addCard(card7);
//        cardRepository.addCard(card8);
//        cardRepository.addCard(card9);

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

//    }

//    @Test
//    public void testPositiveGetBalance() throws PersonalIdentificatorNumberException {
//        ATMService atmService =
//                new ATMService(new LocalCard(211111115), accountRepository, cardRepository);
//        BigDecimal result = atmService.getBalance();
//        Assertions.assertEquals(new BigDecimal("350000.32"), result);
//
//    }
//
//    @Test
//    public void nonExistingCardNumberGetBalance() {
//        ATMService atmService =
//                new ATMService(new LocalCard(287777119), accountRepository, cardRepository);
//        assertThrows(NoSuchElementException.class,
//                atmService::getBalance);
//    }
//
//    @Test
//    public void nonExistingAccountNumberGetBalance() {
//        ATMService atmService =
//                new ATMService(new LocalCard(11111115), accountRepository, cardRepository);
//        assertThrows(NoSuchElementException.class,
//                atmService::getBalance);
//    }
//
//    @Test
//    public void incorrectPINGetBalance() {
//        ATMService atmService =
//                new ATMService(new LocalCard(211111117), accountRepository, cardRepository);
//        assertThrows(PersonalIdentificatorNumberException.class,
//                atmService::getBalance);
//
//    }
}