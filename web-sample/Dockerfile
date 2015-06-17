FROM ggtools/java8

MAINTAINER Scott Clark <saclark74@yahoo.com>

EXPOSE 8080

CMD java -jar  web-sample-0.0.1-SNAPSHOT.jar
ADD build/libs/web-sample-0.0.1-SNAPSHOT.jar .
#ADD web-sample-0.0.1-SNAPSHOT.jar .
ADD application.properties .
ADD application-dev.properties .


