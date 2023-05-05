package org.epolevikov.kafkaproducer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

@RestController
public class Producer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("api/messages")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void sendMessage(@RequestBody String message) {
        kafkaTemplate.send("messages", message);
    }
}
