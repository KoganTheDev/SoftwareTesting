# 💰 Currency Editor - Java Unit Testing Lab

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![JUnit](https://img.shields.io/badge/JUnit-25A162?style=for-the-badge&logo=java&logoColor=white)
![Status](https://img.shields.io/badge/Status-Completed-brightgreen?style=for-the-badge)

---

## 📚 Table of Contents

- [📖 Overview](#-overview)
- [🖇️ Class Diagram](#️-class-diagram)
- [📂 Classes](#-classes)
- [✅ Unit Tests](#-unit-tests)
- [🙋 Author](#-author)

---

## 📖 Overview

The **Currency Editor** project demonstrates the use of **Object-Oriented Programming** principles in Java with a focus on testing and flexibility. It provides robust implementations for handling currencies with support for operations on both single and grouped monetary values. 

### 🔑 Key Features:
- **Arithmetic operations**: Addition, subtraction, multiplication, and negation.
- **Versatile design**: Handle single (`Money`) or grouped (`MoneyBag`) monetary objects.
- **Advanced techniques**: Implements **double dispatch** for seamless operations between classes.

---

## 🖇️ Class Diagram

```plaintext
IMoney
   |
   |--- Money
   |
   |--- MoneyBag
```

---

## 📂 Classes

### 🧩 `IMoney` (Interface)
Defines shared behaviors for `Money` and `MoneyBag`:
- **Addition**: Combine monetary values (`add`).
- **Multiplication**: Scale values by a factor (`multiply`).
- **Negation**: Flip sign of monetary values (`negate`).
- **Zero-check**: Identify zero values (`isZero`).

---

### 💵 `Money` (Class)
Represents a single monetary value:
- **Attributes**: `amount` (integer), `currency` (string).
- **Key Methods**:
  - Arithmetic operations (`add`, `subtract`, `negate`).
  - Value inspection (`isZero`, `currency`).

---

### 🏦 `MoneyBag` (Class)
Manages collections of monetary values:
- **Attributes**: A `Vector<Money>` to store multiple currencies.
- **Key Features**:
  - Supports deferred exchange rate conversions.
  - Combines multiple currencies into a single `MoneyBag`.

---

## ✅ Unit Tests

Comprehensive unit tests ensure the correctness of all operations:
- Arithmetic methods (`add`, `subtract`, `multiply`, `negate`).
- Validation of edge cases (e.g., zero values, mismatched currencies).

### 🔍 Sample Unit Test
```java
@Test
public void testAddMoney() {
    Money usd10 = new Money(10, "USD");
    Money eur5 = new Money(5, "EUR");
    MoneyBag bag = new MoneyBag(usd10, eur5);

    IMoney result = usd10.add(eur5);
    assertEquals(bag, result);
}
```

💡 **Run the tests** with your preferred testing framework (e.g., JUnit).

---

## 🙋 Author

👨‍💻 **Yuval Kogan**  
🌐 [GitHub](https://github.com/KoganTheDev)  
📇 [LinkedIn](https://www.linkedin.com/in/yuval-kogan)
