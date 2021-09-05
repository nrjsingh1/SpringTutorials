package com.Nrjsingh1.SpringTutorial.RestTemplate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class QuoteController {


    @GetMapping("/quote")
    public Quote getQuote(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://quoters.apps.pcfone.io/api/random";
        Quote quote
                = restTemplate.getForObject(url , Quote.class);
        return quote;
    }
}
