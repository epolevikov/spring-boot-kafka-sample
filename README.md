# Spring Boot Kafka Sample

1. git clone
2. cd
3. docker compose up -d

runs

1. **Producer**, port 9000
2. **Kafka**, port 9092
3. **Consumer**, port 9001

**Producer** provides one endpoint named `api/messages`. This endpoint accepts HTTP requests with the `application/json` content type. The request body should match the following schema:

```
{
    topic: string,
    message: string
}
```

**Kafka** contains one topic called `messages`, which consists of one partition.

**Consumer** contains two kafka listeners that read messages from **Kafka**'s _messages_ topic. Each of the consumers then writes a message to a text file. Since the consumers belong to different consumer groups, each message is processed by both of the consumers.

## Example

Move to the `resources` folder and run the `messages_producer.py` script to send the messages from the `messages.csv` file to **Producer**. Then check the content of the `consumer/messages_{1,2}.txt` files to make sure that the messages were processed correctly and were written to the files.
