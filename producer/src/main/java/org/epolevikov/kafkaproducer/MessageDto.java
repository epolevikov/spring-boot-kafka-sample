package org.epolevikov.kafkaproducer;

public class MessageDto {
  private String topic;
  private String message;

  public MessageDto(String topic, String message) {
    this.topic = topic;
    this.message = message;
  }

  public String getTopic() {
    return topic;
  }

  public void setTopic(String topic) {
    this.topic = topic;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
