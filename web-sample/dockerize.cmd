REM rm -f dockerized
REM md dockerized
REM cp build\libs\web-sample-0.0.1-SNAPSHOT.jar dockerized
REM cp application-dev.properties dockerized
REM cp application.properties dockerized
REM copy Dockerfile dockerized
docker -H 192.168.10.201:4243 build -t web-sample .