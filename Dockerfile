FROM amazoncorretto:11-alpine-jdk
maintainer Fonseca Claudio
copy target/PortfolioArgP-0.0.1-SNAPSHOT Portfolio_Fonseca.jar
ENTRYPOINT ["Java","-jar","/Portfolio_Fonseca.jar"]
