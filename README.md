# dud
drunter und drueber game 

![MAIN status](https://github.com/lewineder/dud/actions/workflows/scala.yml/badge.svg)
[![codecov](https://codecov.io/gh/lewineder/dud/branch/main/graph/badge.svg?token=PUIFJ9PH30)](https://codecov.io/gh/lewineder/dud)

Compile with `sbt compile`, run with `sbt run`

Run jacoco with `sbt jacoco` and generate a report with `sbt jacocoReport`



Docker was built via

```sh
sudo docker pull hseeberger/scala-sbt:17.0.2_1.6.2_3.1.1
sudo docker build -t dud:v1 .
sudo docker run -ti dud:v1
```