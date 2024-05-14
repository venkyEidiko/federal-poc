package com.federal.bank.service.camundaRest;

import com.federal.bank.model.Camunda.CamundaChildVariable;
import com.federal.bank.model.Camunda.CamundaVariables;
import com.federal.bank.service.webclient.WebclientConfig;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Service
public class CamundaRestService {

    private static final Logger LOGGER = Logger.getLogger(CamundaRestService.class.getName());
    private static final String START_PROCESS_URL  ="/process-definition/key/federal-poc-engine-process/start";

    @Autowired
    private WebclientConfig webClient;


    public void StartProcess(){

        CamundaChildVariable  name = CamundaChildVariable.builder()
                .type("String").value("Ram")
                .build();
        CamundaChildVariable  age = CamundaChildVariable.builder()
                .type("Integer").value("30")
                .build();
        CamundaChildVariable  gender = CamundaChildVariable.builder()
                .type("String").value("M")
                .build();

        Map<String,Object> map = new HashMap<>();
        map.put("age",age);
        map.put("name",name);
        map.put("gender",gender);

        CamundaVariables camundaVariables = CamundaVariables.builder()
                .variables(map)
                .businessKey("TestingAPI")
                .build();

        String result = webClient.postCall(START_PROCESS_URL,camundaVariables);

        LOGGER.info("String res :::" + result);


    }


}
