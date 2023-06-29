import requests


def main():
    with open("messages.csv") as messages:
        for i, message in enumerate(messages):
            if i == 0: # skip header
                continue

            topic, message = message.strip().split(",")

            request_body = {
                "topic": topic,
                "message": message
            }
            
            response = requests.post("http://localhost:9000/api/kafka-topics", json=request_body)
            
            if 200 <= response.status_code < 300:
                print(f"messaage '{message}' successfully sent to topic '{topic}'")


if __name__ == "__main__":
    main()
