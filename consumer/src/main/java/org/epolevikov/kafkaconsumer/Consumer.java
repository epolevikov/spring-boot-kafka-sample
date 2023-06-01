package org.epolevikov.kafkaconsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Component
public class Consumer {

  @KafkaListener(topics = "messages", id = "consumer_1")
  public void listen1(String message) throws IOException {
    writeMessage(message, "messages_1.txt");
  }

  @KafkaListener(topics = "messages", id = "consumer_2")
  public void listen2(String message) throws IOException {
    writeMessage(message, "messages_2.txt");
  }

  private void writeMessage(String message, String filename) throws IOException {
    message += "\n";

    Files.write(
      Paths.get(filename),
      message.getBytes(),
      StandardOpenOption.APPEND);
  }
}
