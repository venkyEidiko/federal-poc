package com.federal.bank.model.Camunda;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CamundaChildVariable {

    @JsonProperty(value = "type")
    private String type;

    @JsonProperty(value = "value")
    private String value;
}
