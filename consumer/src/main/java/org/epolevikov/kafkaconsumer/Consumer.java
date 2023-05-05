package org.epolevikov.kafkaconsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class Consumer {
  private final Logger logger = LoggerFactory.getLogger(Consumer.class);

  @KafkaListener(topics = "messages", id = "group_id")
  public void listen(String message) {
    logger.info(message);
  }
}
