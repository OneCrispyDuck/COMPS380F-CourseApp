# COMPS380F-CourseApp
Web Application Design &amp; Development Course (HKMU)

```markdown
# COMPS380F - CourseApp

A Spring Boot web application built for the COMP S380F – Web Applications Design and Development course at Hong Kong Metropolitan University.

## 📚 Project Overview

This project serves as a starter template for developing a secure, data-driven web application using modern Java technologies. It follows the Model-View-Controller (MVC) architecture and is configured to support Spring Web, Spring Security, Spring Data JPA, and JSP-based views.

## 🚀 Technologies Used

- **Java 17**
- **Spring Boot 3.4.4** (latest stable)
- **Gradle**
- **Spring Web**
- **Spring Security**
- **Spring Data JPA**
- **H2 Database** (for development and testing)
- **JSP (Java Server Pages)** with JSTL/EL (using embedded Tomcat and Jasper)
- **Thymeleaf** (initial setup, can be replaced with JSP)
- **Spring Boot DevTools** (for hot reloading)

## 📂 Project Structure

```
```
src/main/java/com/onlinecourse
├── controller      # Handles HTTP requests
├── model           # Contains JPA entity classes
├── repository      # Spring Data JPA interfaces
├── service         # (Optional) Business logic layer
└── config          # Security and other configurations

src/main/webapp/WEB-INF/views
└── *.jsp           # JSP view files with JSTL and EL
```
## 📁 Suggested Folder Structure to Commit (DIRECTORY SET UP)
Sub-Packages for MVC Structure
Inside src/main/java/com/onlinecourse/courseapp/, create the following packages:

- controller – for your Spring MVC controllers (e.g., UserController, LectureController)
- model – for entity classes (e.g., User, Lecture, Poll, Comment)
- repository – for interfaces that extend JpaRepository
- service – for service layer logic (optional but recommended)
- config – for Spring configurations like SecurityConfig
```
courseapp/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── onlinecourse/
│       │           └── courseapp/
│       │               ├── CourseappApplication.java
│       │               ├── controller/
│       │               ├── model/
│       │               ├── repository/
│       │               ├── service/
│       │               └── config/
│       ├── resources/
│       └── webapp/
│           └── WEB-INF/
│               └── views/
```

> Note: JSP support requires additional dependencies such as `tomcat-embed-jasper` and JSTL libraries, and all JSP files must reside under `WEB-INF/views/` to prevent direct access [[2]](https://poe.com/citation?message_id=373816026808&citation=2)[[5]](https://poe.com/citation?message_id=373816026808&citation=5).
> JSP View Directory
Under src/main, manually create the following directory structure for your JSP files:
```
src/main/webapp/WEB-INF/views/
```
This is where you will store all your JSP files like:

index.jsp
register.jsp
login.jsp
lecture.jsp
poll.jsp


## ⚙️ Configuration

All key settings are defined in the `application.properties` file:

```properties
spring.mvc.view.prefix=/WEB-INF/views/
spring.mvc.view.suffix=.jsp
spring.datasource.url=jdbc:h2:./Data/myDB;AUTO_SERVER=TRUE
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
🔍 Explanation of Properties
- spring.datasource.url=jdbc:h2:mem:courseappdb
Sets up an in-memory H2 database named courseappdb.

- spring.jpa.hibernate.ddl-auto=update
Automatically updates the database schema based on your entity classes.

- spring.h2.console.enabled=true
Enables access to the H2 web console. You can visit it at:
👉 http://localhost:8080/h2-console

- spring.mvc.view.prefix=/WEB-INF/views/
Tells Spring Boot where to look for JSP files.

- spring.mvc.view.suffix=.jsp
Automatically appends .jsp to view names returned by your controllers.
This setup is aligned with the configurations discussed in our course material for using Spring Boot with H2 and JSP

Verdic:
_application.properties_ file is aligned with the Spring Boot setup for:
- H2 in-memory database usage
- JSP-based view rendering
- Enabling and accessing the H2 developer console
> For more configuration options, refer to [application.properties best practices] 

## build.gradle.kts:
To ensure proper JSP and JSTL support in Spring Boot application, additions are essential for rendering .jsp files correctly at runtime.
Spring Boot does not support **JSP out-fo-the-box**. 

🔍 Why These Dependencies?
```
- tomcat-embed-jasper: Enables JSP rendering inside embedded Tomcat.
- jakarta.servlet.jsp.jstl-api and org.glassfish.web:jakarta.servlet.jsp.jstl: Provide JSTL tag libraries support (like <c:forEach>, <c:if>).
- jakarta.el-api: Supports ${} expression language used in JSPs.
- compileOnly for Jasper avoids conflicts with Tomcat’s embedded server.
```
#### Core spring boot & additional features:
```build.gradle.kts
implementation("org.springframework.boot:spring-boot-starter-web")
implementation("org.springframework.boot:spring-boot-starter-data-jpa")
implementation("org.springframework.boot:spring-boot-starter-security")
implementation("org.springframework.boot:spring-boot-devtools")
```
These handle the core web, data access (JPA), security, and dev-time enhancements.

#### H2 In-Memory Database:
```
implementation("com.h2database:h2")
```
This is perfect for development and testing, and matches the application.properties H2 config.
build.gradle.kts is now fully configured for JSP, JSTL, H2, and Spring Boot development.

You can now:
```
- Place JSP files in /src/main/webapp/WEB-INF/views/
- Use JSTL tags (<c:forEach>, <c:if>, etc.) in your JSP views
- Use EL syntax like ${user.username} safely
- Access your in-memory database at http://localhost:8080/h2-console
```

## 🛠️ How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/OneCrispyDuck/COMPS380F-CourseApp.git
   ```
2. Open the project in IntelliJ IDEA using:
   **File > Open > Import Project from External Model > Gradle** [[2]](https://poe.com/citation?message_id=373816026808&citation=2).
3. Build and run the application:
   ```bash
   ./gradlew bootRun
   ```
4. Visit `http://localhost:8080` in your browser.

## ✅ Features

- Secure login and session management
- Data persistence using Spring Data JPA and H2
- Modular MVC architecture
- JSP views with JSTL and EL
- Ready for extension (e.g., Voting History, Comment History)

## 🧪 Testing

Use Spring Boot Test dependencies and H2 for unit and integration testing during development [[5]](https://poe.com/citation?message_id=373816026808&citation=5).

## 📌 License

This project is for academic use only, as part of COMP S380F coursework.

---

**Happy coding!** 🎓
```

---

