#### Spring Boot - TODO application

##### Let's start by understanding the dependencies requirement

Step 1: The minimal dependency required for setting a Web endpoint using Spring boot is
```		
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

Step 2: Adding an in-memory database requires the following dependencies
```xml
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
```
Spring Data dependency which comes with JPA for Hibernate ORM
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

MySql Connector to connect with the DB(in-memory in this case)

```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
```

Step 3: Understanding the code

Creating End Points:

*   `@RestController` defines the class which holds the endpoints
*   `@RequesetMapping` defines the type of HTTP verb for the 
*   `@Service` holds the implementation of the service which is `@Autowired` in the controller
*   `@Entity` is the POJO of the database table

Step 4: Execute the following commands:

*   `mvn clean compile package`
*   `java -jar target/demo-0.0.1-SNAPSHOT.jar`

Step 5:
*   Hit http://localhost:8080/todo to see the magic

