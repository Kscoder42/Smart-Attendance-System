# Smart Attendance System

A **Java + MySQL based Smart Attendance Management System** built using **JDBC**.  
This is a console-based application that allows managing students and marking attendance efficiently.

---

## 🚀 Features
- Add new students
- View all students
- Mark attendance (Present / Absent)
- View attendance records
- JDBC-based MySQL integration
- Clean layered architecture (DAO, Model, Utility)

---

## 🛠 Tech Stack
- **Java (JDK 17)**
- **MySQL 8**
- **JDBC**
- **Git & GitHub**

---

## 📁 Project Structure
```
Smart-Attendance-System/
│
├── src/
│   ├── main/        # Main application logic
│   ├── dao/         # Database access layer
│   ├── model/       # Entity classes
│   └── util/        # DB connection utility
│
├── lib/             # MySQL Connector JAR
├── bin/             # Compiled class files
└── README.md
```

---

## ⚙️ How to Run

### 1️⃣ Compile
```bash
javac -d bin src/util/DBConnection.java src/dao/StudentDAO.java src/model/Student.java src/main/Main.java
```

### 2️⃣ Run
```bash
java -cp "bin;lib/mysql-connector-j-9.5.0.jar" main.Main
```

---

## 🗄 Database Schema
```sql
CREATE DATABASE attendance_system;
USE attendance_system;

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    roll_number INT UNIQUE
);

CREATE TABLE attendance (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    date DATE,
    status VARCHAR(10),
    FOREIGN KEY (student_id) REFERENCES students(id)
);
```

---

## 👨‍💻 Author
**Krishna Sandilya**  
GitHub: https://github.com/Kscoder42

---

## 📌 Future Enhancements
- GUI using JavaFX
- Spring Boot version
- Login & role-based access
- Attendance reports (CSV / PDF)
