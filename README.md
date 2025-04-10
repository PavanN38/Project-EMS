# Employee-Management-SpringBoot

**Introduction**

The Employee Management System is a web-based application built using the Spring Boot framework. The system allows users to perform CRUD (Create, Read, Update, Delete) operations for managing employee information, including the ability to add, update, view, and delete employee records. This application follows the RESTful API architecture and provides a clean separation of concerns between the controller, service, and repository layers.

**Features**

Add Employee: Allows users to add new employees with attributes like name, department, role, etc.

View Employee: Fetch and view detailed information for individual employees.

Update Employee: Modify the details of existing employees.

Delete Employee: Remove employees from the system.

Search Employees: Find employees based on name, department, or other criteria.

RESTful API: Follows the RESTful API principles to manage employee data.
Database Integration: Uses an RDBMS (such as MySQL) to persist employee data.

**Technologies Used**

*Backend:*

Java
Spring Boot
Spring Data JPA (for database interactions)
Spring MVC (for RESTful services)

*Database:*

MySQL 

Build Tool:

Maven

*Other:*

Lombok (to reduce boilerplate code)

**System Architecture**
The system follows the three-tier architecture:

Controller Layer: Responsible for handling HTTP requests and responses.

Service Layer: Implements the business logic for employee management.

Repository Layer: Interacts with the database using Spring Data JPA.


