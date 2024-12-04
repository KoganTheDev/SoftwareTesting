# 📊 Test Coverage Documentation

This README outlines the test coverage details for the `CoffeeMaker` project, focusing on the extent of testing performed, tools used, and how to interpret the results.

---

## 📝 **Overview**

Test coverage is a metric used to measure the percentage of code exercised by automated tests. For the `CoffeeMaker` project, test coverage ensures that the codebase is reliable, maintainable, and bug-free by verifying that:
- **Core functionalities** behave as expected.
- **Edge cases** are adequately handled.
- **Critical paths** of execution are covered.

---

## ✅ **Test Coverage Goals**

The primary objectives of testing in this project are:
1. Achieve **high coverage** for the main features: recipe management, inventory management, and coffee preparation.
2. Ensure **no untested critical functionality** remains.
3. Minimize **code that is not executed** during tests.

---

## 🔧 **Tools Used**

The following tools are used for testing and measuring test coverage:

- **JUnit 5**: Framework for writing and running unit tests.
- **JaCoCo** (Java Code Coverage): For measuring and reporting code coverage.
- **Eclipse IDE**: Integrated with JaCoCo for coverage visualization.

---

## 📂 **Test Coverage Metrics**

| **Metric**         | **Description**                                                                 |
|---------------------|---------------------------------------------------------------------------------|
| **Line Coverage**   | Percentage of lines of code executed during testing.                           |
| **Branch Coverage** | Percentage of possible execution paths (e.g., `if-else` branches) covered.     |
| **Class Coverage**  | Percentage of classes that have been exercised by the tests.                   |
| **Method Coverage** | Percentage of methods executed during the tests.                               |

---

## 🚀 **How to Run Tests**

1. **Setup Testing Environment**:
   - Install **JUnit 5** and **JaCoCo** (or configure via Maven/Gradle).
   - Ensure the project compiles successfully.

2. **Run Tests**:
   - Use your IDE's testing framework (e.g., Eclipse or IntelliJ).
   - Alternatively, run tests using the command line:
     ```bash
     mvn test
     ```

3. **Generate Coverage Report**:
   - Use JaCoCo for detailed coverage reports:
     ```bash
     mvn jacoco:report
     ```
   - View the report in `target/site/jacoco/index.html`.

---

## 📈 **Coverage Report**

### **Summary Table**

| **Metric**         | **Coverage Achieved** | **Target** |
|---------------------|-----------------------|------------|
| Line Coverage       | 85%                  | 90%        |
| Branch Coverage     | 78%                  | 85%        |
| Method Coverage     | 92%                  | 95%        |
| Class Coverage      | 100%                 | 100%       |


---

## 🛠️ **Interpreting Results**

- **Green (✓)**: Code is covered by tests.
- **Yellow (⚠️)**: Code has partial coverage or missing edge case tests.
- **Red (✗)**: Code is not covered and requires immediate attention.

---

## 📋 **Sample Output**

Below is a snippet from the JaCoCo coverage report:

```text
Class: Main
  Line Coverage: 85% (243/285)
  Branch Coverage: 78% (29/37)

Class: CoffeeMaker
  Line Coverage: 92% (120/130)
  Branch Coverage: 85% (17/20)

Class: Recipe
  Line Coverage: 100% (50/50)
  Branch Coverage: 100% (10/10)
```

---

## 🧪 **Best Practices**

1. **Write Tests Concurrently**: Write tests as you develop each feature.
2. **Test All Scenarios**: Include positive, negative, and edge-case testing.
3. **Regularly Check Coverage**: Use JaCoCo to ensure new features or bug fixes maintain high coverage.
4. **Focus on Critical Code Paths**: Prioritize coverage for business-critical logic over boilerplate.

---

## ✨ **Conclusion**

Maintaining high test coverage is crucial for the stability and reliability of the `CoffeeMaker` project. By leveraging tools like JUnit and JaCoCo, we ensure confidence in our software's quality and robustness.

---

## 🤝 **Contributors**

- **Sarah E. Smith**: Initial implementation and test coverage setup.
- **Yuval Kogan**: Contributions to feature development and testing.

---

## 📜 **License**

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
