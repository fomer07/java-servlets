
# Java Servlet Example: HelloServlet with Tomcat

## Overview

This project demonstrates a simple Java servlet application that processes a POST request and responds with a greetings, with your name in a web browser. It is built using **Jakarta Servlet API** and is designed to be deployed on **Apache Tomcat**.

### Features:
- Java Servlet responding to POST requests.
- Uses **Jakarta Servlet API** for Tomcat 10 and later.
- Deployable as a **WAR (Web Application Archive)** file.
- Serves the servlet at the `/hello` URL.

---

## Prerequisites

Before you begin, ensure you have the following installed:

1. **Java Development Kit (JDK) 11 or later**: Download from [Oracle](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or use [OpenJDK](https://adoptium.net/).
2. **Apache Tomcat 10 or later**: Download from [Tomcat Official Website](https://tomcat.apache.org/).
3. **Maven (optional)**: If you're using Maven for project management. [Install Maven](https://maven.apache.org/install.html).

---

## Project Setup

### 1. Clone or Download the Project

Clone or download this project to your local machine.

```bash
git clone <https://github.com/fomer07/java-servlets.git>
```

### 2. Project Structure

```bash
JavaServletExample/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── example/
│       │           └── servlet/
│       │               └── HelloServlet.java        # Your servlet class
│       └── webapp/
│           ├── WEB-INF/
│           │   └── web.xml                        # Servlet mapping and configuration
│           └── index.html                        # Optional front-end HTML file
├── pom.xml                                         # Maven configuration file
```

### 3. Install Dependencies (Maven)
If you're using Maven, make sure to install the required dependencies.

**Add Jakarta Servlet API dependency** to your `pom.xml`:

```xml
<dependencies>
    <!-- Jakarta Servlet API for Tomcat 10 or later -->
    <dependency>
        <groupId>jakarta.servlet</groupId>
        <artifactId>jakarta.servlet-api</artifactId>
        <version>6.0.0</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

Run Maven to install the dependencies:

```bash
mvn clean install
```

---

## Servlet Code

In this project, we have a servlet called `HelloServlet` that handles a simple POST request and responds with "Hello, World!".

```java
package com.example.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;


public class HelloServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the name parameter from the form
        String name = request.getParameter("name");

        // Set the response content type
        response.setContentType("text/html");

        // Generate a dynamic HTML response
        response.getWriter().write("<html><body>");
        response.getWriter().write("<h1>Hello, " + name + "!</h1>");
        response.getWriter().write("</body></html>");
    }
}
```

- **`@WebServlet("/hello")`** annotation defines the servlet's URL mapping. In this case, it will respond to requests at `/hello`.
- We have also configured web.xml file, for mapping Servlet with this particular endpoint.

---

## Deployment Configuration (web.xml)

If you are using the traditional `web.xml` file (not required with the `@WebServlet` annotation), make sure to define the servlet mapping:

```xml
<web-app xmlns="http://java.sun.com/xml/ns/javaee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_1.xsd" version="3.1">
    <servlet>
        <servlet-name>HelloServlet</servlet-name>
        <servlet-class>com.example.servlet.HelloServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>HelloServlet</servlet-name>
        <url-pattern>/hello</url-pattern>
    </servlet-mapping>
</web-app>
```

---

## Build and Package

If you're using **Maven**, you can build and package the application as a `.war` file by running the following command:

```bash
mvn clean package
```

This will generate a `target/ServletApplication.war` file that you can deploy to Tomcat.

---

## Deploying on Tomcat

### 1. Copy the WAR File to Tomcat's `webapps` Directory

Once the WAR file is generated, copy the `ServletApplication.war` file to Tomcat's `webapps` directory.

```bash
cp target/ServletApplication.war /path/to/tomcat/webapps/
```

### 2. Start Tomcat Server

If Tomcat is not already running, start it using the `bin/startup.sh` (Linux/macOS) or `bin/startup.bat` (Windows) script.

```bash
/path/to/tomcat/bin/startup.sh    # Linux/macOS
/path/to/tomcat/bin/startup.bat   # Windows
```

Tomcat will automatically deploy the WAR file, and the application will be available at:

```
http://localhost:8080/ServletApplication/index.html
```

---

## Accessing the Application

1. Open a web browser.
2. Navigate to the following URL:

   ```
   http://localhost:8080/ServletApplication/index.html
   ```

3. You should see the form for your name:

4. After you submitting your name, you will be greeted at URL /hello.

   ```
   Hello, <World>!
   ```

---

## Closing Tomcat

After you've finished using the application, you can stop Tomcat by running the following command from the Tomcat `bin/` directory:

- For **Unix/Linux/macOS**:
    ```bash
    ./shutdown.sh
    ```

- For **Windows**:
    ```bash
    shutdown.bat
    ```

This will gracefully stop the Tomcat server and free up resources. Make sure to stop the server if you're done working with the application to avoid consuming unnecessary resources.


## Conclusion

You have successfully created and deployed a Java Servlet application on Tomcat. This basic example can be expanded to build more complex servlet-based web applications. Let me know if you need further help!
