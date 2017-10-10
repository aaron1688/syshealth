FROM java:8

EXPOSE 9000 9001

ADD ./build/libs/syshealth-0.0.1-SNAPSHOT.jar /syshealth-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/syshealth-0.0.1-SNAPSHOT.jar"]