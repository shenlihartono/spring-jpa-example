#### Spring JPA Example

To run in using mysql driver on runtime, use this command:

```
mvn spring-boot:run -Dspring-boot.run.profiles=mysql
```

or if you prefer to use postgres:
```
mvn spring-boot:run -Dspring-boot.run.profiles=postgres
```

Option for running h2 in-memory db:
```
mvn spring-boot:run -Dspring-boot.run.profiles=h2
```

Try access the h2 console from browser:
`http://localhost:8001/h2`

Please set the value of `JDBC URL` according to the value in h2 properties file.

Note: 

when running using IDE, please set the VM option in Run Configuration:
 
```-Dspring.profiles.active=profile```