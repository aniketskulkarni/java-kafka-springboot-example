# java-kafka-springboot-example
Example to demonstrate use of **Kafka**, **Java** and **Springboot**

## Background
This is simple Springboot application to get started on _Kafka_.  
Key points:
- Zookeeper
- Kafka Broker
- Kafka Topic
- Kafka Consumer  

Messages are _published_ and _consumed_ using REST endpoints.

Keep in mind, you need to **download and install Kafka** before running the JAR file.

---
## Download Kafka
- Install the Kafka on a local machine from official web site [https://kafka.apache.org/downloads](https://kafka.apache.org/downloads)
- Extract the contents of compressed file into a folder of your preference.  

---
## Zookeeper and Kafka Broker
- "a centralized service for maintaining configuration information, naming, providing distributed synchronization, and providing group services."
- Kafka is always run as a distributed application as a Cluster.
- Cluster contains one or several Kafka _servers_.
- An individual Kafka server is known as a broker, and a broker could be a physical or virtual server. 
- Kafka uses _ZooKeeper_ by default to coordinate server activity and store metadata about the cluster.

### A. Start Zookeeper on a local machine
```
./zookeeper-server-start.sh ../config/zookeeper.properties
```
- This will start the Zookeeper with default properties.  
- It runs on a default port _2181_.

### B. Start Kafka Broker (Server)
```
./kafka-server-start.sh ../config/server.properties
```
- Starts the Kafka server on default port _9092_.
- It is possible to override these settings from a respected properties file.  

---
## Kafka Topic
- A _Topic_ is a category of messages that a consumer can subscribe to.
- This ensures that consumer receives the only relevant messages that it has subscribed. 
- Using topic, variety of messages can flow through a single Kafka cluster. 
- Producer can send message to a particular topic and consumer consumes from the same topic.

### C. Create a Topic
```
./kafka-topics.sh --create --topic myFirstTopic --bootstrap-server \
 localhost:9092 --replication-factor 1 --partitions 1
```
- Partitions distribute data across Kafka nodes.
- This facilitates the horizontal scaling of single topics across multiple servers.

---
## Kafka Consumer
- Subscribes to topic
- Receives messages send by Producer

---
### D. Run Application
```
java -jar kafka-springboot-examples.jar
```
### E. Send message using Producer
- Use any REST client to publish message
- Details:
    - HTTP Method: _POST_
    - URI: _http://localhost:8090/kafka/messages_
    - Payload: _String message_
    - Consumes: _text/html_

### F. Read message using Consumer
- Use any REST client to read message
- Details:
    - HTTP Method: _GET_
    - URI: _http://localhost:8090/kafka/messages_
    - Produces: _application/json_


- Send messages using POST API and receive messages using GET API.  
- I have not added any security for an API. This is mainly focused on getting started with Kafka.
- Once you have downloaded Kafka, follow A,B,C,D,E and F to test this application.
