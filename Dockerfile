FROM java:8

EXPOSE 9000 9001 9998 9999

ADD ./build/libs/syshealth-0.0.1-SNAPSHOT.jar /syshealth-0.0.1-SNAPSHOT.jar
ADD ./runjar.sh /runjar.sh

CMD "/runjar.sh"