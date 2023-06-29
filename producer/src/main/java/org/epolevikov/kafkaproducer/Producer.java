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
  public void sendMessage(@RequestBody MessageDto message) {
    kafkaTemplate.send(message.getTopic(), message.getMessage())
        .whenComplete((sendResult, error) -> {
          if (sendResult != null) {
            System.out.println("Message " + message.getMessage() +
                " successfully sent to topic " + message.getTopic());
          } else {
            System.out.println("Error happened while sending message "
                + message.getMessage() + " to topic " + message.getTopic()
                + ". Details: " + error.getMessage());
          }
        });

    // kafkaTemplate blocks on 'send' and infinitely polls a topic if
    // the topic does not exist. TODO: fix the issue (maybe somehow
    // specify a timeout?).
  }
}
