FROM openjdk:17.0.2
COPY target/jira-1.0.jar jira-1.0.jar
COPY resources ./resources

ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "jira-1.0.jar"]

#docker image build -t jira-java-jar:latest .
#docker run --name jira -p 8080:8080 jira-java-jar

