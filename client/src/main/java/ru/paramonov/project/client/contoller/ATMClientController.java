package ru.paramonov.project.client.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.paramonov.project.client.service.ATMService;
import ru.paramonov.project.server.exception.PersonalIdentificatorNumberException;
import ru.paramonov.project.server.service.Verification;

//@RequestMapping(value = "/ATM")
@Controller
public class ATMClientController {
    private ATMService atmService;
    private int errorPINcounter = 3;
    //TODO: получать в клиенте от банкомата
    private final int cardNumber = 1;
//    private Verification verification;
//    private CardRepository cardRepository;
    //TODO: определение статуса готовности конкретного банкомата
    @GetMapping("/")
    public String getATMStatus(){
        return "/menu";
    }
    @GetMapping("/exit")
    public void exit(){
        System.exit(0);
    }
    @GetMapping("/pin")
    public String getPIN(){
        return "/pin";
    }

    @PostMapping("/pin/validation")
    public String PINValidation(@RequestParam (name = "pin") int pin, /*int cardNumber,*/ Model model) throws PersonalIdentificatorNumberException {
        //        verification = new Verification(pin, this.cardNumber, cardRepository);

//        verification = new Verification(pin,  cardNumber);
        if(atmService.verificationService(pin, cardNumber))
            return "redirect:/account";
        else {
            if(errorPINcounter > 0){
                --errorPINcounter;
                model.addAttribute("errorPINMessage", "Количество оставшихся попыток " + errorPINcounter + "!");
                return "/errorPIN";
            }
            else return "/cardHasBlocked";
        }
    }

}
