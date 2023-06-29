import requests


def main():
    with open("messages.csv") as messages:
        for i, message in enumerate(messages):
            if i == 0:
                continue

            topic, message = message.strip().split(",")
            
            requests.post("http://localhost:9000/api/messages")


if __name__ == "__main__":
    main()
