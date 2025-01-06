# Creating Test Stubs Using Mockito

---

## 🌟 Overview

Mockito is a popular Java-based framework used for creating test stubs and mocks. It simplifies unit testing by allowing developers to mock dependencies and focus on testing the logic of the class under test. This guide walks you through creating test stubs using Mockito, including basic setup, key concepts, and practical examples.

---

## ✨ Features

- 🛠️ Mocking dependencies with minimal boilerplate
- 🔍 Verifying interactions between objects
- 🔄 Creating flexible and reusable test stubs
- ⚠️ Handling edge cases and exceptions with ease

---

## 📋 Table of Contents

1. [📖 Introduction to Test Stubs](#introduction-to-test-stubs)
2. [⚙️ Setting Up Mockito](#setting-up-mockito)
3. [🔧 Creating Test Stubs](#creating-test-stubs)
4. [💡 Examples](#examples)
5. [✅ Best Practices](#best-practices)
6. [🏁 Conclusion](#conclusion)
7. [📜 License](#license)

---

## 📖 Introduction to Test Stubs

Test stubs are objects used in unit testing to replace real implementations of dependencies. They return pre-determined responses to simulate various scenarios and help isolate the code being tested.

---

## ⚙️ Setting Up Mockito

To use Mockito in your project, include the following dependency in your `pom.xml` (for Maven):

```xml
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>5.0.0</version>
    <scope>test</scope>
</dependency>
```

For Gradle:

```gradle
testImplementation 'org.mockito:mockito-core:5.0.0'
```

---

## 🔧 Creating Test Stubs

1. **Mock Dependencies:** Create mock objects using the `Mockito.mock()` method.
   ```java
   MyService myService = Mockito.mock(MyService.class);
   ```

2. **Stub Methods:** Use `when().thenReturn()` to define behavior for specific method calls.
   ```java
   Mockito.when(myService.getData()).thenReturn("Stubbed Data");
   ```

3. **Handle Exceptions:** Simulate exceptions for edge cases using `thenThrow()`.
   ```java
   Mockito.when(myService.getData()).thenThrow(new RuntimeException("Error"));
   ```

4. **Verify Interactions:** Ensure the mock behaves as expected using `Mockito.verify()`.
   ```java
   Mockito.verify(myService).getData();
   ```

---

## 💡 Examples

### Example 1: Simple Stub

```java
@Test
void testSimpleStub() {
    MyService myService = Mockito.mock(MyService.class);
    Mockito.when(myService.getData()).thenReturn("Stubbed Data");

    String result = myService.getData();

    assertEquals("Stubbed Data", result);
}
```

### Example 2: Handling Exceptions

```java
@Test
void testExceptionHandling() {
    MyService myService = Mockito.mock(MyService.class);
    Mockito.when(myService.getData()).thenThrow(new RuntimeException("Error"));

    assertThrows(RuntimeException.class, myService::getData);
}
```

---

## ✅ Best Practices

- **🎯 Keep Tests Focused:** Test one aspect of behavior per unit test.
- **❌ Avoid Over-Stubbing:** Stub only the methods needed for the test.
- **📝 Use Annotations:** Simplify setup with `@Mock` and `@InjectMocks`.
- **✔️ Verify Critical Interactions:** Ensure key methods are called as expected.

---

## 🏁 Conclusion

Mockito is a powerful tool for creating test stubs and ensuring robust unit testing. By isolating dependencies and controlling their behavior, you can write clean, effective tests for your Java applications.

---

## 📜 License

This guide is licensed under the MIT License. See the LICENSE file for more details.

---

### 👨‍💻 Author

Yuval Kogan  
Software Engineer | [GitHub](https://github.com/KoganTheDev) | [LinkedIn](https://www.linkedin.com/in/yuval-kogan/)
