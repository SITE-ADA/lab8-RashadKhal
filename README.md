[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/Qr3lBpHw)
# University Management System

This project is a simple university management system built using a microservice architecture. The system manages students, courses, enrollments, and course relationships.

The project consists of two main microservices:

- student-service
- course-service

---

# Technologies Used

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- OpenFeign
- RestTemplate
- Lombok
- Swagger / OpenAPI
- Maven

---

# Microservices

## student-service

Responsible for student management.

Main features:
- create student
- list students
- get student by ID
- update student
- delete student

Port:
```text
9090
```

---

## course-service

Responsible for course management and enrollment operations.

Main features:
- create course
- list courses
- get course by ID
- update course
- delete course
- enroll student into course
- prerequisite validation
- retrieve courses by student name
- display course students

Port:
```text
8081
```

---

# Database

The project uses PostgreSQL.

Two separate databases are required:

- studentDB
- courseDB

---

# PostgreSQL Configuration

## course-service

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/courseDB
spring.datasource.username=postgres
spring.datasource.password=passwordc
```

## student-service

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/studentDB
spring.datasource.username=postgres
spring.datasource.password=passwords
```

---

# Creating Databases

Create the following databases inside PostgreSQL:

```sql
CREATE DATABASE studentDB;
CREATE DATABASE courseDB;
```

---

# Running the Project

## 1. Start PostgreSQL

Make sure PostgreSQL service is running.

---

## 2. Run student-service

```bash
cd student-service
mvn spring-boot:run
```

Service URL:
```text
http://localhost:9090
```

---

## 3. Run course-service

```bash
cd course-service
mvn spring-boot:run
```

Service URL:
```text
http://localhost:8081
```

---

# Swagger URLs

## student-service Swagger

```text
http://localhost:9090/swagger-ui/index.html
```

## course-service Swagger

```text
http://localhost:8081/swagger-ui/index.html
```

---

# Main Features

## 1. Enrollment Date

When a student is enrolled into a course, the system automatically stores the enrollment date.

Example response:

```json
{
  "enrollmentId": 1,
  "courseId": 2,
  "studentId": 1,
  "message": "Student enrolled successfully.",
  "enrollmentDate": "2026-05-20"
}
```

---

## 2. Prerequisite Validation

Courses may contain prerequisite courses.

If the student has not completed the prerequisite course, the enrollment request is rejected.

Example error response:

```json
{
  "timestamp": "2026-05-20T14:20:11",
  "status": 400,
  "error": "Bad Request",
  "message": "Student must complete prerequisite course with id: 1",
  "path": "/api/v1/courses/2/students/1"
}
```

---

## 3. Get Courses By Student Name

The system supports retrieving courses associated with a student using the student's name.

Endpoint:

```text
GET /api/v1/courses/search?studentName=Rashad
```

---

# Endpoint Examples

---

# Student Endpoints

## Create Student

```http
POST /api/v1/students
```

Request:

```json
{
  "firstName": "Rashad",
  "lastName": "Khalilli",
  "email": "rashad@example.com",
  "age": 21
}
```

---

## Get All Students

```http
GET /api/v1/students
```

---

## Get Student By ID

```http
GET /api/v1/students/1
```

---

# Course Endpoints

## Create Course

```http
POST /api/v1/courses
```

Request:

```json
{
  "title": "Programming Fundamentals",
  "code": "CS101",
  "credits": 5,
  "prerequisiteCourseId": null
}
```

---

## Create Course With Prerequisite

```http
POST /api/v1/courses
```

Request:

```json
{
  "title": "Data Structures",
  "code": "CS201",
  "credits": 5,
  "prerequisiteCourseId": 1
}
```

---

## Enroll Student Into Course

```http
POST /api/v1/courses/1/students/1
```

---

## Get Course Students

```http
GET /api/v1/courses/1/students
```

---

## Search Courses By Student Name

```http
GET /api/v1/courses/search?studentName=Rashad
```

---

# Important Notes

- course-service communicates with student-service using Feign Client.
- Enrollment information is stored inside course-service.
- Swagger/OpenAPI documentation is provided in Azerbaijani.
- Hibernate `ddl-auto=update` is used, so tables are created automatically.
- A student cannot enroll in the same course more than once.

---

# Project Structure

```text
university-management-system
│
├── student-service
│
└── course-service
```

---

