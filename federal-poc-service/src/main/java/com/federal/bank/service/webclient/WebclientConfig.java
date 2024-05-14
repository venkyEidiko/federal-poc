package com.federal.bank.service.webclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WebclientConfig {

    @Autowired
    private WebClient webClient;

    public String postCall(String url, Object body) {
        Mono<String> data = this.webClient.post()
                .uri(url)
                .body(Mono.just(body), body.getClass())
                .retrieve()
                .onStatus(HttpStatusCode::isError, result -> {
                    return Mono.error(new Exception("Failed to call an API"));
                })
                .bodyToMono(String.class);
        return data.block();
    }

    public String getCall(String url){
        Mono<String> data = this.webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class);
        return data.block();
    }


}
