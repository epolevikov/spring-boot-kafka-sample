# Spring Boot Kafka Sample

1. git clone
2. cd
3. docker compose up -d

runs

1. **producer**, which listens for http requests on `localhost:9000/api/messages` and writes messages to
2. **kafka** (port 9092), to which
3. **consumer** (port 9001) is subscribed.

**Consumer** reads messages from **kafka** and writes them to `consumer/messages.txt` file.

## Example

Run the `write_messages.sh` script to send the following messages to **producer**:

```
Message one
Message two
Message three
```

Then run `cat consumer/messages.txt` to make sure that the messages were processed correctly and were written to the file.
