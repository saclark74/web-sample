REM docker -H 192.168.10.201:4243 run --rm -p 80:8080 -e spring.profiles.active=dev web-sample
docker -H 192.168.10.201:4243 run --rm -p 80:8080 --env-file=dev.env web-sample