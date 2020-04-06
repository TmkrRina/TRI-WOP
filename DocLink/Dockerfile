FROM openjdk:11

RUN mkdir /app

WORKDIR /app

#RUN curl -L https://services.gradle.org/distributions/gradle-6.3-bin.zip -o gradle-6.3-bin.zip
#RUN apt-get install -y unzip
#RUN unzip gradle-6.3-bin.zip
#
#ENV GRADLE_HOME=/app/gradle-6.3
#ENV PATH=$PATH:$GRADLE_HOME/bin

RUN mkdir /DocLink
WORKDIR /DocLink

COPY . .

RUN ls -al

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/DocLink/build/libs/doclink-0.0.1-SNAPSHOT.jar"]
#ENTRYPOINT ["gradle", "bootRun"]
