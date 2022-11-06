FROM eclipse-temurin:19-jdk-alpine

# -----------------------------------------------------------------------------

MAINTAINER Felipe Toledo G Oliveira <ftgo@ppgsc.ufrn.br>

# -----------------------------------------------------------------------------

#ARG app
#ARG profile
#
#ENV APP=${app}
#ENV PROFILE=${profile}

# -----------------------------------------------------------------------------

WORKDIR /app

#COPY target/${app}.jar ./
#
#CMD java -jar -Dspring.profiles.active=${PROFILE} /app/${APP}.jar
