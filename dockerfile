FROM openjdk:17
WORKDIR /app
COPY ./target/springboot-aws.jar /app
CMD ["java", "-jar", "springboot-aws.jar"]