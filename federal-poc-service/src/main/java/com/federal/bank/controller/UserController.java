package com.federal.bank.controller;

import com.federal.bank.model.Camunda.CamundaVariables;
import com.federal.bank.repo.UserRepository;
import com.federal.bank.service.camundaRest.CamundaRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CamundaRestService camundaRestService;

    @GetMapping("/welcome")
    public String getWelcome(){
        return "Welcome to the page";
    }

    @GetMapping("/msg")
    private String getMsg(){
        return "Hello Everyone";
    }


    @GetMapping("/help")
    private String getHelp(){
        camundaRestService.StartProcess();
        return "How can i help you?";
    }


}
