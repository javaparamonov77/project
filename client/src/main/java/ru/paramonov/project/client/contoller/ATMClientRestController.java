package ru.paramonov.project.client.contoller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.paramonov.project.client.common.ATMResponse;
import java.util.Arrays;

@RequestMapping(value = "/ATM")
@RestController
public class ATMClientRestController {
    private static final String URL_SERVER = "http://localhost:8082/API/balance";
    private ResponseEntity<String> response;
    private ATMResponse atmResponse;

    @GetMapping("/")
    public String getReady() {
        return "ATM is ready";
    }

    @GetMapping("/cards/{cardNum}/accounts/{accountNum}/{pin}")
    public ATMResponse getBalance(@PathVariable("cardNum") long cardNum,
                                  @PathVariable("accountNum") long accountNum,
                                  @PathVariable("pin") int pin) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("cardNumber", String.valueOf(cardNum));
        headers.add("accountNumber", String.valueOf(accountNum));
        headers.add("pin", String.valueOf(pin));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();

        try {
            response = restTemplate.exchange(URL_SERVER, HttpMethod.POST, entity, String.class);
            atmResponse = new ATMResponse(true,  response.getBody());

        } catch (Exception e) {
            atmResponse = new ATMResponse(false, e.getMessage());
        }
        return atmResponse;
    }
}
