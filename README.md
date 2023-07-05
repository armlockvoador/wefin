## Environment configuration with container docker 

### Pull image docker 
> docker pull mongo

### Build jar
> mvn clean install

### Build image project
> docker build -t youbotapp:1.0 .

### Create image database
> docker run -d -p 27017:27017 --name wifindb mongo:latest

### Link app to database
> docker run -p 8080:8080 --name wefinapp --link wefindb:mongo -d youbotapp:1.0

###  docker ps

CONTAINER ID   IMAGE           COMMAND                  CREATED          STATUS          PORTS                      NAMES

9e66672db5f8   wefinapp:1.0   "java -jar app.jar"      41 minutes ago   Up 41 minutes   0.0.0.0:8080->8080/tcp     wefinapp
071264b92527   mongo:latest    "docker-entrypoint.s…"   46 minutes ago   Up 46 minutes   0.0.0.0:27017->27017/tcp   wefindb

## database and build project 
> The collections are in the admin database

>  for run the project start the docker in your machine before runing the docker-compose

## Architecture

> The architecture is hexagon, using ports to acces the domain.
