package ru.paramonov.project.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.paramonov.project.server.common.LocalCard;
import ru.paramonov.project.server.repository.CardRepository;
import java.util.List;

@Controller
@RequestMapping("/card_controller")
public class ATMCardServerController {
    public ATMCardServerController(CardRepository cardRepository){
        this.cardRepository = cardRepository;
    }
    private final CardRepository cardRepository;

    @GetMapping("/add_cards")
    public String getAddCardPage() {
        return "/card_controller/add_new_card";
    }

    @PostMapping("/cards")
    public String addCard (@RequestParam (required = false, name = "card") long accountNumber){
        LocalCard card = new LocalCard(accountNumber);
        System.out.println("card: " + card.getPersonalIdentificationNumber());
        cardRepository.save(card);
        return "redirect:/card_controller/cards";
    }

    @GetMapping("/cards")
    public String getCards (Model model){
        List<LocalCard> cards = cardRepository.findAll();
        model.addAttribute("cards", cards);
        return "/card_controller/cards";
    }

}
