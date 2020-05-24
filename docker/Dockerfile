FROM openjdk:8-jdk-alpine
MAINTAINER leilei<leileideve@163.com>
VOLUME /docker/springboot
EXPOSE 80
ADD springboot-shiro.jar application.jar
ENTRYPOINT ["java","-Xmx350m","-jar" ,"application.jar"]