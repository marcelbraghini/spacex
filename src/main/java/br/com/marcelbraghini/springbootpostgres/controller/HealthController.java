package br.com.marcelbraghini.springbootpostgres.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/health", produces = "application/json")
public class HealthController {

    @GetMapping
    public String check() {
        return "Its up..";
    }

}
