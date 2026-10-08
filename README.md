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
```

---

# 📂 Repository Structure

```text
AdvancedJava-JDBC-Servlet-JSP-/
│
├── src/
│   └── com/
│       └── pack1/
│           ├── CallableStatementExample.java
│           ├── ClassA.java
│           ├── ClassB.java
│           ├── ConnectionPool.java
│           ├── InterfaceA.java
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
```

---

## 📁 Directory Structure Explanation

### `src/`

Contains the Java source code of the project.

### `com/pack1/`

Contains the Java classes and JDBC practice programs.

### `JdbcApp1.java` - `JdbcApp18.java`

Contains different Java programs created while learning and practicing
JDBC and database connectivity concepts.

### `CallableStatementExample.java`

Demonstrates the use of `CallableStatement` for working with stored
procedures.

### `ConnectionPool.java`

Contains code related to database connection management and connection
pooling concepts.

### `ClassA.java` and `ClassB.java`

Java classes used for practicing class-related concepts.

### `InterfaceA.java`

Used for practicing the Java interface concept.

### `.gitignore`

Specifies files and folders that should not be tracked by Git.

### `README.md`

Contains the documentation and information about this repository.

---

# 🔌 JDBC Driver

A **JDBC Driver** is a software component that allows a Java application
to communicate with a specific database.

JDBC drivers are generally categorized into four types:

| Type | Name | Description |
|---|---|---|
| Type 1 | JDBC-ODBC Bridge Driver | Uses ODBC for database communication |
| Type 2 | Native-API Driver | Uses native database APIs |
| Type 3 | Network Protocol Driver | Uses middleware for communication |
| Type 4 | Thin Driver | Directly communicates with the database |

This repository mainly uses the **Oracle Thin JDBC Driver (Type 4)**.

---

## 🟠 Oracle Thin Driver

The Oracle Thin Driver allows Java applications to communicate with
Oracle Database using Java.

### Driver Class

```java
oracle.jdbc.OracleDriver
```

### JDBC URL

```text
jdbc:oracle:thin:@localhost:1521:free
```

Example:

```java
Class.forName("oracle.jdbc.OracleDriver");

Connection con = DriverManager.getConnection(
    "jdbc:oracle:thin:@localhost:1521:free",
    "s***m",
    "S*******3"
);
```

---

# 🔗 Connection Interface

The `Connection` interface represents a connection between a Java
application and a database.

It is used to:

- Create statements
- Execute database operations
- Manage transactions
- Commit changes
- Roll back changes
- Close the database connection

Example:

```java
Connection con = DriverManager.getConnection(
    "jdbc:oracle:thin:@localhost:1521:free",
    "system",
    "System123"
);
```

---

# 📝 Statement

The `Statement` interface is used to execute SQL statements against
a database.

Common methods include:

```java
executeQuery()
executeUpdate()
execute()
addBatch()
executeBatch()
```

---

## PreparedStatement

`PreparedStatement` is used to execute parameterized SQL queries.

Example:

```java
PreparedStatement pstmt =
    con.prepareStatement(
        "SELECT * FROM student WHERE id = ?"
    );

pstmt.setInt(1, 101);

ResultSet rs = pstmt.executeQuery();
```

### Advantages

- Supports parameterized queries
- Easier to work with dynamic values
- Can be reused
- Helps prevent SQL injection

---

# 📞 CallableStatement

`CallableStatement` is used to execute stored procedures and stored
functions from a Java application.

Example:

```java
CallableStatement cstmt =
    con.prepareCall("{call procedure_name(?)}");

cstmt.setInt(1, 101);

cstmt.execute();
```

The repository contains:

```text
CallableStatementExample.java
```

for practicing this concept.

---

# 📊 ResultSet

The `ResultSet` interface represents the data returned by a SQL query.

Example:

```java
ResultSet rs = pstmt.executeQuery();

while (rs.next()) {
    System.out.println(rs.getInt(1));
    System.out.println(rs.getString(2));
}
```

The `next()` method moves the cursor to the next row.

Data can be retrieved using column indexes:

```java
rs.getInt(1);
rs.getString(2);
```

or by column names:

```java
rs.getInt("ID");
rs.getString("NAME");
```

---

# 🛠️ CRUD Operations

CRUD stands for:

| Operation | SQL Command | Purpose |
|---|---|---|
| Create | `INSERT` | Add new records |
| Read | `SELECT` | Retrieve records |
| Update | `UPDATE` | Modify existing records |
| Delete | `DELETE` | Remove records |

### INSERT

```sql
INSERT INTO student VALUES (101, 'Mohan');
```

### SELECT

```sql
SELECT * FROM student;
```

### UPDATE

```sql
UPDATE student
SET name = 'Rahul'
WHERE id = 101;
```

### DELETE

```sql
DELETE FROM student
WHERE id = 101;
```

---

# 📦 Batch Processing

JDBC Batch Processing allows multiple SQL operations to be grouped
together and executed as a batch.

Common methods include:

```java
addBatch()
executeBatch()
```

Example:

```java
Statement stmt = con.createStatement();

stmt.addBatch("INSERT INTO student VALUES(101, 'Mohan')");
stmt.addBatch("INSERT INTO student VALUES(102, 'Rahul')");
stmt.addBatch("INSERT INTO student VALUES(103, 'Amit')");

stmt.executeBatch();
```

Batch processing can reduce the number of database communication
requests when multiple operations need to be executed.

---

# 🌐 Java Web Development

This repository also covers concepts related to Java Web Development
using Servlets and JSP.

The major technologies include:

- Java Servlet
- JSP
- JavaBeans
- DAO
- MVC Architecture
- HTML
- Apache Tomcat

---

# 🚀 Servlet

A **Servlet** is a Java program that runs on a web server and handles
client requests and server responses.

Servlets are commonly used to:

- Receive form data
- Process client requests
- Communicate with databases
- Generate dynamic responses
- Forward or include other resources

Common servlet methods include:

```java
doGet()
doPost()
service()
```

---

# 📄 JSP

**JSP (JavaServer Pages)** is used to create dynamic web pages using
Java-based web technologies.

JSP can contain:

- HTML
- JSP elements
- Expression Language
- JSP Standard Actions
- Dynamic content

Example:

```jsp
<jsp:include page="index.html"/>
```

---

# ☕ JavaBeans

JavaBeans are Java classes used to represent and transfer data between
different layers of an application.

A JavaBean generally contains:

- Private data members
- Getter methods
- Setter methods

Example:

```java
public class StudentBean {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

JavaBeans are commonly used with Servlets, JSP and DAO layers.

---

# 🗃️ DAO - Data Access Object

**DAO (Data Access Object)** is a design pattern used to separate
database-related operations from other application logic.

The DAO layer is responsible for operations such as:

- Insert
- Select
- Update
- Delete

Basic structure:

```text
Servlet
   |
   v
  DAO
   |
   v
 JDBC
   |
   v
Oracle Database
```

This makes the application easier to maintain and organize.

---

# 🏗️ MVC Architecture

**MVC (Model-View-Controller)** is an architectural pattern used to
separate different responsibilities of an application.

```text
             Client
               |
               v
        +--------------+
        | Controller   |
        |   Servlet    |
        +------+-------+
               |
               v
        +--------------+
        |    Model     |
        | JavaBean/DAO |
        +------+-------+
               |
               v
        +--------------+
        |   Database   |
        +--------------+

               |
               v
        +--------------+
        |     View     |
        |     JSP      |
        +--------------+
```

### Model

Responsible for data and database-related operations.

Examples:

- JavaBeans
- DAO

### View

Responsible for displaying information to the user.

Example:

- JSP

### Controller

Responsible for receiving requests and controlling application flow.

Example:

- Servlet

---

# 🍪 Session and Cookie Management

Java Web Applications can maintain user-related information using
different session management techniques.

Common techniques include:

- Cookies
- HttpSession
- URL Rewriting
- Hidden Form Fields

These techniques are useful for maintaining state between multiple
HTTP requests.

---

# 🗄️ Oracle Database

This repository uses **Oracle Database** for practicing JDBC and
database connectivity concepts.

Example database configuration:

```text
Database   : Oracle
Host       : localhost
Port       : 1521
Service    : free
Username   : system
```

Example JDBC URL:

```text
jdbc:oracle:thin:@localhost:1521:free
```

> **Note:** Database credentials should not be committed to a public
> GitHub repository in a real-world project.

---

# 🎯 Purpose of This Repository

The main purpose of this repository is to:

- Learn Advanced Java concepts
- Understand JDBC database connectivity
- Practice Oracle database operations
- Understand JDBC drivers
- Practice SQL operations using Java
- Understand Statement and PreparedStatement
- Practice CallableStatement
- Work with ResultSet
- Understand CRUD operations
- Practice batch processing
- Learn Servlet and JSP concepts
- Understand JavaBeans and DAO
- Learn MVC architecture
- Build a strong foundation in Java Web Development

---

# 📈 Learning Progress

This repository represents my hands-on learning journey in Advanced Java.

### Topics Practiced

- ✅ JDBC
- ✅ JDBC Drivers
- ✅ Oracle Thin Driver
- ✅ Connection
- ✅ Statement
- ✅ PreparedStatement
- ✅ CallableStatement
- ✅ ResultSet
- ✅ CRUD Operations
- ✅ Batch Processing
- ✅ Stored Procedures
- ✅ Servlets
- ✅ JSP
- ✅ JavaBeans
- ✅ DAO
- ✅ MVC Architecture
- ✅ Session Management
- ✅ Cookie Management
- ✅ Oracle Database
- ✅ Apache Tomcat

---

# ⚙️ How to Run

### 1. Clone the Repository

```bash
git clone https://github.com/Mohan2410/AdvancedJava-JDBC-Servlet-JSP-.git
```

### 2. Open the Project

Open the project in your Java development environment.

### 3. Configure Oracle Database

Make sure Oracle Database is installed and running.

### 4. Add Oracle JDBC Driver

Add the Oracle JDBC driver to the project's classpath.

### 5. Configure Database Connection

Update the database URL, username and password according to your
local Oracle Database configuration.

Example:

```java
Connection con = DriverManager.getConnection(
    "jdbc:oracle:thin:@localhost:1521:free",
    "system",
    "System123"
);
```

### 6. Run the Programs

Run the required `JdbcApp` or other Java class to practice the
corresponding concept.

---

# 🔧 Tools & Technologies

| Technology | Purpose |
|---|---|
| Java | Programming Language |
| JDBC | Database Connectivity |
| Oracle Database | Relational Database |
| Oracle Thin Driver | JDBC Driver |
| Servlet | Request and Response Handling |
| JSP | Dynamic Web Pages |
| JavaBeans | Data Representation |
| DAO | Data Access Layer |
| MVC | Application Architecture |
| Apache Tomcat | Web Server / Servlet Container |
| HTML | Web Page Structure |
| Eclipse | Development Environment |
| Git | Version Control |
| GitHub | Repository Hosting |

---

# 👨‍💻 Author

**Mohan Gawande**

Java Developer | CSE Graduate | Advanced Java Learner

**GitHub:**  
https://github.com/Mohan2410

---

## ⭐ If you find this repository useful

Feel free to explore the programs and use them for learning and practicing
Advanced Java, JDBC, Servlet and JSP concepts.
