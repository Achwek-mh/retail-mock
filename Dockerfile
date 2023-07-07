FROM aksnfug/maven-jdk11-gradle
EXPOSE 8090
ARG JAR_FILE=retail-cbs-common/.mvn/wrapper/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT  ["java","-jar","/app.jar"]
