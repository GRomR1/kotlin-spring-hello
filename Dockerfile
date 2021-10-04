ARG VERSION=8u302

FROM openjdk:${VERSION}-jdk as BUILD
COPY . /src
WORKDIR /src
RUN ./gradlew --no-daemon bootJar

FROM openjdk:${VERSION}-jre-slim
WORKDIR /app
COPY --from=BUILD /src/app/build/libs/app.jar /app/run.jar
CMD ["java","-jar","run.jar"]
