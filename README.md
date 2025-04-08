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
src/main/java/com/onlinecourse
├── controller      # Handles HTTP requests
├── model           # Contains JPA entity classes
├── repository      # Spring Data JPA interfaces
├── service         # (Optional) Business logic layer
└── config          # Security and other configurations

src/main/webapp/WEB-INF/views
└── *.jsp           # JSP view files with JSTL and EL
```

> Note: JSP support requires additional dependencies such as `tomcat-embed-jasper` and JSTL libraries, and all JSP files must reside under `WEB-INF/views/` to prevent direct access [[2]](https://poe.com/citation?message_id=373816026808&citation=2)[[5]](https://poe.com/citation?message_id=373816026808&citation=5).

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

> For more configuration options, refer to [application.properties best practices] [[3]](https://poe.com/citation?message_id=373816026808&citation=3)[[4]](https://poe.com/citation?message_id=373816026808&citation=4).

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

Let me know if you'd like this README customized further with badges, screenshots, or deployment steps!
