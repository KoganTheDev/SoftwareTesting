# 🚀 **Test-Driven Development (TDD)**: Student Management System
## 🔍 **Overview**

Welcome to the **Student Management System**! This project demonstrates how to apply **Test-Driven Development (TDD)** to manage a list of students, ensuring valid student names and no duplicates. 

TDD is a powerful methodology in software development where you **write tests first**, then write the minimal code to make those tests pass, and finally **refactor** the code to ensure it's clean and maintainable.

In this project, we’re using **JUnit** to write tests for the following:
- **Student Name Validation**
- **Student List Management**

## 📚 **Table of Contents**

- [🔍 Overview](#overview)
- [💡 What is TDD?](#what-is-tdd)
- [🛠 Project Structure](#project-structure)
- [🔄 TDD Process](#tdd-process)
- [🧪 Testing Example](#testing-example)
- [⚙️ Usage](#usage)
- [📜 License](#license)
- [👨‍💻 Author](#author)

## 💡 **What is TDD?**

**Test-Driven Development (TDD)** is a software development approach that emphasizes writing **tests before** writing the actual code. The TDD cycle consists of three simple steps:

1. **Red**: Write a **failing test** that defines the behavior or feature.
2. **Green**: Write the **minimal code** to make the test pass.
3. **Refactor**: Clean up the code to improve structure while ensuring the tests continue to pass.

### **Why TDD?**
- Ensures code is **bug-free** and **robust**.
- Helps create **self-documenting code** with tests.
- Encourages small, **incremental improvements**.

## 🛠 **Project Structure**

This project consists of two core classes:
1. **`Student`**: Represents a student and validates the student's name based on specific rules.
2. **`StudentList`**: Manages a list of students, enforcing unique student names.

---

### `Student` Class

The `Student` class handles:
- Storing a student’s **name**.
- Validating the name by ensuring it does not contain digits, spaces, or special characters.

### `StudentList` Class

The `StudentList` class supports:
- **Adding**, **removing**, and **editing** students.
- Ensuring that **student names remain unique** in the list.

---

## 🔄 **TDD Process**

### Step 1: **Write Tests**

We start by writing tests to define the expected behavior of the classes. For this project, we write tests for:

- **Student Name Validation** (check for spaces, digits, special characters).
- **Student List Operations** (add, remove, and edit students).

### Step 2: **Write Code to Pass Tests**

Once the tests are written, we implement the necessary functionality in the `Student` and `StudentList` classes to make the tests pass.

### Step 3: **Refactor**

After the tests pass, we refactor the code to enhance its readability and maintainability while ensuring the tests continue to pass.

---

## 🧪 **Testing Example**

### **1. Student Name Validation Tests**

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    
    @Test
    public void testValidName() {
        Student student = new Student("JohnDoe");
        assertTrue(student.isNameValid(), "Name should be valid!");
    }

    @Test
    public void testNameWithDigits() {
        Student student = new Student("John123");
        assertFalse(student.isNameValid(), "Name should not contain digits!");
    }

    @Test
    public void testNameWithSpaces() {
        Student student = new Student("John Doe");
        assertFalse(student.isNameValid(), "Name should not contain spaces!");
    }

    @Test
    public void testNameWithSpecialCharacters() {
        Student student = new Student("John@Doe");
        assertFalse(student.isNameValid(), "Name should not contain special characters!");
    }
}
```

---

### **2. Student List Management Tests**

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentListTest {
    
    @Test
    public void testAddStudent() {
        StudentList studentList = new StudentList();
        Student student = new Student("JohnDoe");
        assertTrue(studentList.addStudent(student), "Student should be added!");
    }

    @Test
    public void testAddDuplicateStudent() {
        StudentList studentList = new StudentList();
        Student student = new Student("JohnDoe");
        studentList.addStudent(student);
        assertFalse(studentList.addStudent(student), "Duplicate student should not be added!");
    }

    @Test
    public void testRemoveStudent() {
        StudentList studentList = new StudentList();
        Student student = new Student("JohnDoe");
        studentList.addStudent(student);
        assertTrue(studentList.removeStudentFromStudentList(student), "Student should be removed!");
    }

    @Test
    public void testEditStudent() {
        StudentList studentList = new StudentList();
        Student oldStudent = new Student("JohnDoe");
        Student newStudent = new Student("JaneDoe");
        studentList.addStudent(oldStudent);
        assertTrue(studentList.editStudentInStudentList(oldStudent, newStudent), "Student should be updated!");
    }
}
```

---

## ⚙️ **Usage**

Here’s an example of how to use the `Student` and `StudentList` classes:

```java
public class Main {
    public static void main(String[] args) {
        // Create new students
        Student student1 = new Student("JohnDoe");
        Student student2 = new Student("JaneDoe");

        // Create a student list
        StudentList studentList = new StudentList();

        // Add students to the list
        studentList.addStudent(student1);
        studentList.addStudent(student2);

        // Display all students
        System.out.println("Student List: ");
        for (Student student : studentList.getStudents()) {
            System.out.println(student.getName());
        }
    }
}
```

---

## 📜 **License**

This project is licensed under the **MIT License**. See the [LICENSE](LICENSE) file for more information.

---

## 👨‍💻 **Author**

- **Yuval Kogan**  
  [GitHub](https://github.com/KoganTheDev)  
  **Email**: [yuval.kogan@example.com](mailto:yuval.kogan@example.com)

---

### **Connect with me:**

- **LinkedIn**: [Yuval Kogan](https://www.linkedin.com/in/yuval-kogan)
- **GitHub**: [KoganTheDev](https://github.com/KoganTheDev)
