# 🎯 Unit Testing Methods and Classes in C#

![C#](https://img.shields.io/badge/C%23-%23239120.svg?style=flat&logo=c-sharp&logoColor=white)
![Visual Studio](https://img.shields.io/badge/Visual%20Studio-5C2D91.svg?style=flat&logo=visual-studio&logoColor=white)
![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)

> A professional guide to mastering **unit testing** in C# using **Visual Studio** and the **MSTest Framework**. This repository offers a hands-on approach to ensure your code is reliable, maintainable, and bug-free. 🚀

---

## 📚 Table of Contents

1. [🔍 Overview](#-overview)
2. [🛠 Technologies Used](#-technologies-used)
3. [📜 License](#-license)
4. [👤 Author](#-author)

---

## 🔍 Overview

Unit testing is an essential skill for developers to ensure **code quality** and **robustness**. This project demonstrates how to:
- Create testable **methods** and **classes**.
- Use test attributes such as `[TestMethod]`, `[TestClass]`, `[TestInitialize]`, and `[TestCleanup]`.
- Leverage **Visual Studio Test Explorer** for streamlined testing workflows.

Whether you're a beginner or an experienced developer, this repository provides everything you need to kickstart or refine your unit testing journey.

---

## 🛠 Technologies Used

| Technology       | Purpose                       |
|-------------------|-------------------------------|
| **C#**           | Programming language         |
| **MSTest**       | Unit testing framework       |
| **Visual Studio**| Integrated development tool  |
| **Git/GitHub**   | Version control and hosting  |

---

## ⚙️ Usage

### Writing a Test Class  
Here's how to create a test class with MSTest:  

```csharp
using Microsoft.VisualStudio.TestTools.UnitTesting;

[TestClass]
public class CalculatorTests
{
    private Calculator _calculator;

    [TestInitialize]
    public void Setup()
    {
        _calculator = new Calculator();
    }

    [TestMethod]
    public void Add_ShouldReturnSumOfTwoNumbers()
    {
        int result = _calculator.Add(2, 3);
        Assert.AreEqual(5, result);
    }

    [TestCleanup]
    public void Cleanup()
    {
        // Clean up resources if needed
    }
}
```

## 📜 License

This project is licensed under the [MIT License](LICENSE). Feel free to use, modify, and distribute this project as needed.

---

## 👤 Author

**Yuval Kogan**  
💻 [GitHub](https://github.com/KoganTheDev)  
🌐 [LinkedIn](https://www.linkedin.com/in/yuval-kogan)  
