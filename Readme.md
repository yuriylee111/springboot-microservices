[![Build Status](http://localhost:8081/buildStatus/icon?job=springboot-microservices)](http://localhost:8081/job/springboot-microservices/)
### _API Gateway using Spring Cloud Gateway_

Create 2 Databases in MySQL:
```sh
CREATE SCHEMA `department_db`;
CREATE SCHEMA `employee_db`;
```
- Run first ServiceRegistryApplication
- Run second DepartmentServiceApplication
- Run third EmployeeServiceApplication
- Run fourth ApiGatewayApplication

open link http://localhost:8761/

JSON patterns are in postman.txt
