FROM openjdk:10.0.1
VOLUME /tmp
ADD target/springboot-sample-jar.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar