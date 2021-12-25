package com.example.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @RestController
    public class HatConsumerResource {

        @Value( "${producer.port}" )
        private Integer producerPort;

        private final RestTemplate restTemplate;

        HatConsumerResource(RestTemplateBuilder restTemplateBuilder) {
            this.restTemplate = restTemplateBuilder.build();
        }

        @RequestMapping("/wearhat/{hatId}")
        String getMessage(@PathVariable("hatId") Long personId, @RequestHeader("authorization") String authorizationHeader) {

            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", authorizationHeader);
            HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

            ResponseEntity<Hat> response = restTemplate.exchange("http://localhost:"+producerPort+"/hat/{hatId}", HttpMethod.GET, requestEntity, Hat.class, personId);
            Hat hat = response.getBody();

            return "Enjoy your new " + hat.getName();
        }

    }
}
