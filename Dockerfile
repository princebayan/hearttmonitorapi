FROM openjdk:11-jre-slim

LABEL maintainer  = "amir.bayan"
LABEL version     = "0.0.1"
LABEL description = "Heart Monitor API java image"

# Setup the needed files
ADD /build/libs/heartmonitorapi-*-SNAPSHOT.jar heartmonitorapi.jar

COPY /src/main/resources/application-uat.yaml application-uat.yaml

ENV spring_profiles_active uat

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/heartmonitorapi.jar"]
