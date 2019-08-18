
#imagem base
FROM openjdk:8-alpine

#pessou que criou a imagem
MAINTAINER Allan T.

COPY /target /var/www/

#apartir de que pasta o conteiner deve comecar
WORKDIR /var/www

#RUN executa algo DURANTE A CRIACAO DO CONTEINER

#comando para ser executado depois que a imagem estiver criada
ENTRYPOINT java -jar demo-0.0.1-SNAPSHOT.jar

EXPOSE 8080