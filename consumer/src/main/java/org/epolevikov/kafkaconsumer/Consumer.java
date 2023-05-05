package org.epolevikov.kafkaconsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Component
public class Consumer {

  @KafkaListener(topics = "messages", id = "group_id")
  public void listen(String message) throws IOException {
    message += "\n";

    Files.write(
      Paths.get("messages.txt"),
      message.getBytes(),
      StandardOpenOption.APPEND);
  }
}
