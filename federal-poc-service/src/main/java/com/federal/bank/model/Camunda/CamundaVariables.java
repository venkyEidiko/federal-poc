package com.federal.bank.model.Camunda;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CamundaVariables {

    @JsonProperty(value = "variables")
    private Map<String,Object> variables;

    @JsonProperty(value = "businessKey")
    private String businessKey;
}
