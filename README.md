# ToDo Application

A Java application to store and retrieve todo list/tasks.

## Getting Started

Below instructions will tell you what are the prerequisites that
needs to be installed, configurations that has to be done to run the project.

### Prerequisites

Below are the softwares that needs to be installed as a dependency

```
Java 11

sudo apt-get install software-properties-common
sudo add-apt-repository ppa:openjdk-r/ppa
sudo apt-get update
sudo apt install openjdk-11-jdk


Maven

sudo apt-get install maven
```

### Installing

A step by step series of examples that tell you how to get a development env running

1 . Git clone the repo to any Linux machine.

2 . Cd to the directory and follow the below steps to build the packages
```


### Building the packages

Below are the steps to build the JAR file and to start the backend server

```bash
mvn package -DskipTests

./mvnw spring-boot:run
```

This will start the application on port 8080

Access the api's by navigating to

```bash
http://<ip address of container>:8080/
```

The application uses the in memeory database "h2". The console can be accessed by

```bash
http://localhost:8080/h2-console
```

The crednetials can be found in application.properties


### Accessing the end points

Below are the end points which are accessible

1 . To create a new todo list, send a post request to
```bash
http://localhost:8080/todo
```

2 . To list all Todo's navigate to
```bash
http://localhost:8080/todo
```

3 . To list a particular todo item, send a get request to
```bash
http://localhost:8080/todo/<id>
```

4 . To list all completed todo's navigate to
```bash
http://localhost:8080/todo/completed
```

5 . To list all non completed todo's navigate to
```bash
http://localhost:8080/todo/not-completed
```

6 . To delete a particular todo, send delete request to
```bash
http://localhost:8080/todo/delete/<id>
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

