# Spring JPA Studies

This application developed for Spring JPA capabilities. 
At the beginning there exist only basic operations.
<br/>
In time I will add new branches with different capabilities.

# First Merge

You can check operations over [SpringJpaApplicationTests.java](src/test/java/com/workshop/springjpa/SpringJpaApplicationTests.java) file.

|Function |Description|
|-----|--------|
|Initialize repositories| Three basic repository created     |
|Entity Relations  | Added OneToOne and ManyToMany relations between entities      |
|[StudentInformationRepository.java](src/main/java/com/workshop/springjpa/data/repository/StudentInformationRepository.java)   | Added sort by column name ASC, DESC|
|[StudentService.java](src/main/java/com/workshop/springjpa/service/StudentService.java)   | Added basic CRUD operations and Count function|
|[application.properties](src/main/resources/application.properties)   | Added some JPA configurations|
<br/>

# Technologies

The project is built on Spring Boot architecture. Maven used as build automation tool.

# Project Setup

- **You need valid database**
- Make sure to be in the root directory
- Run the command to run the project locally:

```
mvnw spring-boot:run
```

- Run the command to run the tets:

```
mvnw test
```

- Run the command to create runnable jar file:

```
mvnw package
```

