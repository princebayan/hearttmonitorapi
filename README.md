# Heart-Monitor-API
[![SpringBoot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)](http://projects.spring.io/spring-boot/)

[![Build Status](https://github.com/princebayan/hearttmonitorapi/actions/workflows/transaction-engine-pipeline.yaml/badge.svg)](https://github.com/princebayan/transaction-engine/actions)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)
[![Maintenance](https://img.shields.io/badge/Maintained%3F-yes-green.svg)](https://GitHub.com/Naereen/StrapDown.js/graphs/commit-activity)
[![Maintenance](https://img.shields.io/badge/Docker-2CA5E0?style=for-the-badge&logo=docker&logoColor=white)](https://www.docker.com)

Heart Monitor API is a spring boot java application that exposes APIs to receive the heart rate as CSV 
format from the monitor application, also it manages the patients, devices and adding a study for 
a patient


Minimal [Spring Boot](http://projects.spring.io/spring-boot/) sample app.


## Requirements

For building and running the application you need:

- [JDK 11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
- [Gradle 7.5](https://services.gradle.org/distributions/gradle-7.5-bin.zip)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.example.heartmonitorapi.Application` class from your IDE.

<h3>It is preferred to run the application with a spring profile property:</h3> 

<h4>JVM System Parameter</h4>

```shell
-Dspring.profiles.active=dev
```
<h4>Environment Variable</h4>

```shell
export spring_profiles_active=dev
```
<h3>Swagger Documentation</h3>
once the application is up you can access the swagger documentation page from the 
below URL:
<br>

[Localhost Swagger](http://localhost:8089/swagger-ui.html)
<br>
<br>
Also, you can check the swagger documentation from the Cloud Server instance
<br>

[Cloud Swagger](http://137.184.12.5:8089/swagger-ui.html)

## Allure Report
This project use allure to visualize the Junit results, you can check the result
from the Github Action Pipeline by navigating to the stage `Post the link to the report` 
or directly from Github pages feature through the below link:

[Github Pages](https://princebayan.github.io/hearttmonitorapi/)


## Technologies Used

- [Spring Boot Framework](http://projects.spring.io/spring-boot/)
- [Docker](https://www.docker.com)
- [Spring Boot H2 Database](https://www.baeldung.com/spring-boot-h2-database)
- [Project Lombok](https://projectlombok.org/)
- [Allure Report](https://qameta.io/allure-report/)
- [Rest Exception Handling](https://www.baeldung.com/exception-handling-for-rest-with-spring)


## Copyright

Released under the Apache License 2.0. See the [LICENSE](https://github.com/princebayan/hearttmonitorapi/blob/develop/LICENSE.txt) file.
