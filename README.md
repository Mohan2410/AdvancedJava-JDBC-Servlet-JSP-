# Advanced Java - JDBC, Servlet & JSP

A collection of Advanced Java programs developed while learning and practicing
JDBC, Servlets, JSP, JavaBeans, DAO, MVC architecture, and Oracle Database.

This repository contains multiple programs created during my learning and
hands-on practice with database connectivity and Java-based web development.

---

## 📌 About the Repository

This repository contains different Advanced Java programs that demonstrate
how Java applications communicate with databases and how Java Web Applications
are developed using Servlets and JSP.

The repository covers concepts such as:

- JDBC (Java Database Connectivity)
- JDBC Drivers
- Oracle Thin Driver
- Database Connectivity
- Connection Interface
- Statement
- PreparedStatement
- CallableStatement
- ResultSet Interface
- CRUD Operations
- Batch Processing
- Stored Procedures
- Java Servlets
- JSP (JavaServer Pages)
- JavaBeans
- DAO (Data Access Object)
- MVC Architecture
- Request and Response Handling
- Session and Cookie Management
- Oracle Database
- Apache Tomcat

---

## 🛠️ Technologies Used

- **Java**
- **JDBC**
- **Oracle Thin JDBC Driver**
- **Oracle Database**
- **Servlet**
- **JSP**
- **JavaBeans**
- **DAO Pattern**
- **MVC Architecture**
- **HTML**
- **Apache Tomcat**
- **Eclipse IDE**
- **Git & GitHub**

---

# 📚 JDBC - Java Database Connectivity

## What is JDBC?

**JDBC (Java Database Connectivity)** is a Java API that allows Java
applications to connect with databases and perform database operations.

Using JDBC, a Java application can:

- Establish a connection with a database
- Execute SQL queries
- Insert records
- Retrieve records
- Update records
- Delete records
- Process query results
- Execute stored procedures
- Perform batch processing
- Manage database transactions

---

## 🔄 JDBC Architecture

The basic JDBC architecture can be represented as:

```text
+----------------------+
|   Java Application   |
+----------+-----------+
           |
           v
+----------------------+
|        JDBC          |
|        API           |
+----------+-----------+
           |
           v
+----------------------+
|    JDBC Driver       |
+----------+-----------+
           |
           v
+----------------------+
|      Database        |
+----------------------+

📂 Repository Structure
AdvancedJava-JDBC-Servlet-JSP-/
│
├── src/
│   └── com/
│       └── pack1/
│
│           ├── CallableStatementExample.java
│           ├── ClassA.java
│           ├── ClassB.java
│           ├── ConnectionPool.java
│           ├── InterfaceA.java
│           │
│           ├── JdbcApp1.java
│           ├── JdbcApp2.java
│           ├── JdbcApp3.java
│           ├── JdbcApp4.java
│           ├── JdbcApp5.java
│           ├── JdbcApp6.java
│           ├── JdbcApp7.java
│           ├── JdbcApp8.java
│           ├── JdbcApp9.java
│           ├── JdbcApp10.java
│           ├── JdbcApp12.java
│           ├── JdbcApp13.java
│           ├── JdbcApp13MovieTicket.java
│           ├── JdbcApp15.java
│           ├── JdbcApp16.java
│           ├── JdbcApp17.java
│           └── JdbcApp18.java
│
├── .gitignore
└── README.md
