# Spring Boot Kafka Sample

1. git clone
2. cd
3. docker compose up -d

runs

1. **producer**, which listens for http requests on `localhost:9000/api/messages` and writes messages to
2. **kafka** (port 9092), to which
3. **consumer** (port 9001) is subscribed.

**Kafka** contains one topic called _messages_. The topic consists of one partition.

**Consumer** contains two kafka listeners that read messages from the _messages_ topic. Each of the consumers then writes a message to a text file. Since the consumers belong to different consumer groups, each message is processed by both the consumers.

## Example

Run the `write_messages.sh` script to send the following messages to **producer**:

```
Message one
Message two
Message three
```

Then run `cat consumer/messages_{1,2}.txt` to make sure that the messages were processed correctly and were written to the files.
