
### _Circuit Breaker Pattern implementation using Resilience4j_

Create 2 Databases in MySQL:
```sh
CREATE SCHEMA `department_db`;
CREATE SCHEMA `employee_db`;
```
- Run first ServiceRegistryApplication
- Run second ConfigServerApplication
- Run third DepartmentServiceApplication
- Run fourth EmployeeServiceApplication
- Run fifth ApiGatewayApplication

open links:

- http://localhost:8081/api/employees/1
- http://localhost:8081/actuator/health

stop Department-Service

(test and see Circuit Breaker's status)

- call 5 times - http://localhost:8081/api/employees/1 (state": "OPEN")
- wait 5 seconds (state": "HALF_OPEN")
- call 3 times - http://localhost:8081/api/employees/1 (state": "OPEN")

restart Department-Service

- call 3 times - http://localhost:8081/api/employees/1 (state": "CLOSED")
