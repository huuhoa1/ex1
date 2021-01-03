FROM openjdk:8-jre-alpine
VOLUME /tmp
RUN mkdir /app
RUN cd /app
WORKDIR /app
ADD target/subscription*.jar app.jar
ADD run.sh run.sh
ENTRYPOINT sh run.sh
