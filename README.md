# spring-cloud-stream-example

## Prerequisites

This example uses RabbitMQ as messaging implementation.
Therefore a Rabbit-MQ instance muste be running and listening on its standard port 5672.
If you have docker installed, you can run a rabbit-mq container like this:
```
docker run -d --hostname my-rabbit -p 5672:5672 -p 15672:15672 --name some-rabbit rabbitmq:3-management
```
You can access the management console under http://localhost:15672 (guest/guest).

## Run the source application (creates messages)
```
java -jar spring-cloud-stream-sample-sink/target/spring-cloud-stream-sample-sink-0.0.1-SNAPSHOT.jar --server.port=0```
```

## Run the sink application (consumes messages)
```
java -jar spring-cloud-stream-sample-sink/target/spring-cloud-stream-sample-sink-0.0.1-SNAPSHOT.jar --server.port=0```
```