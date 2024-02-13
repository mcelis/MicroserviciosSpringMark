package com.ccti.accounts.Controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "/api/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AccountsController {

    @GetMapping("hello")
    public String helloEndPoint(){
        return "Hola desde Microservicios !!!";
    }

    @GetMapping("dateTime")
    public String dateTime(){
        return LocalDateTime.now().toString();
    }
}
