FROM gradle:jdk22 as builder
ENV TZ=Asia/Seoul
ENV PROJECT_NAME="seminar"
WORKDIR /workspace/app

COPY . .
RUN chmod 755 ./gradlew && \
    ./gradlew clean && \
    ./gradlew bootJar

FROM openjdk:22
ENV TZ=Asia/Seoul
ENV PROJECT_NAME="seminar"
ARG JAR_FILE=/workspace/app/build/libs/*.jar
COPY --from=builder $JAR_FILE app.jar
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
ENTRYPOINT ["java", "-jar", "app.jar"]