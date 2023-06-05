# Spring Boot Kafka Sample

1. git clone
2. cd
3. docker compose up -d

runs

1. **Producer**, port 9000
2. **Kafka**, port 9092
3. **Consumer**, port 9001

**Producer** provides one endpoint named `api/messages`. This endpoint accepts HTTP requests with the `text/plain` content type. The content of the request body is sent to **Kafka** (specifically, to the _messages_ topic, which consists of one partition).

**Consumer** contains two kafka listeners that read messages from **Kafka**'s _messages_ topic. Each of the consumers then writes a message to a text file. Since the consumers belong to different consumer groups, each message is processed by both of the consumers.

## Example

Run the `write_messages.sh` script to send the following messages to **producer**:

```
Message one
Message two
Message three
```

Then run `cat consumer/messages_{1,2}.txt` to make sure that the messages were processed correctly and were written to the files.
