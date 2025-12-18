# Selenium Automation Framework – MakeMyTripp

## 🚀 Project Overview

This repository contains a **Selenium WebDriver automation framework** developed using **Java, TestNG, and Maven**. The framework is designed to automate web application testing and follows industry best practices such as **Page Object Model (POM)**, **Data-Driven Testing**, and **centralized configuration management**.

The automation scripts are developed in **Eclipse IDE** using **TestNG** for test execution and management. The project includes sample automation scenarios for the **MakeMyTripp web application**, along with support for **Excel and JSON based test data**, **screenshot capture on failure**, and **structured test execution using `testng.xml`**.

---

## 🧰 Tech Stack & Tools

| Technology | Purpose |
|-----------|---------|
| Java | Programming Language |
| Selenium WebDriver | Web Automation |
| Maven | Build & Dependency Management |
| TestNG | Test Framework |
| Eclipse IDE | Development Environment |
| Apache POI | Excel Data Handling |
| JSON | Test Data Management |
| Extent Reports | HTML Reporting |
| Git & GitHub | Version Control |

---

## 🗂️ Project Structure

```text
src/main/java
├── base
│   └── TestBase.java
├── pages
│   ├── LoginPage.java
│   └── ProductCartPage.java
├── utilities
│   ├── ConfigReader.java
│   ├── ExtentManager.java
│   ├── ScreenshotUtil.java
│   ├── ExcelUtil.java
│   └── JsonUtil.java
└── listeners

src/main/resources
└── config.properties

src/test/java
├── tests
│   ├── LoginTest.java
│   └── CartTest.java
└── dataproviders

src/test/resources
├── loginData.json
└── testng.xml

pom.xml
TestData.xlsx

📌 Key Features

Selenium WebDriver automation using Java

Maven-based project with dependency management

Page Object Model (POM) for scalable and maintainable code

Data-Driven Testing using Excel and JSON files

Centralized configuration using config.properties

TestNG Listeners for execution tracking and screenshots

Automatic screenshot capture on test failure


Structured test execution using testng.xml

HTML reporting using Extent Reports

▶️ How to Run the Tests
🔧 Prerequisites

Java JDK (Java 17 or compatible)

Maven

Chrome Browser & compatible ChromeDriver

Eclipse IDE (recommended)

▶️ Steps to Execute

1. Clone the repository:
git clone https://github.com/Prabhat-bhardwaj/MakeMyTripp.git

2. Navigate to the project directory:
cd MakeMyTripp

3. Execute tests using Maven:
mvn clean test
OR run the suite directly using testng.xml from Eclipse.

📊 Test Reports

TestNG default reports are generated under:
test-output/
Extent Reports (if enabled) provide detailed HTML execution reports with screenshots for failed test cases.

⚙️ Configuration Management

All configurable values such as:

Application URL

Browser type

Execution settings

are managed through:
src/main/resources/config.properties

📂 Test Data Management

Excel test data is maintained in TestData.xlsx

JSON test data is stored under src/test/resources

TestNG DataProviders are used to supply data to test cases

📂 Test Data Management

Excel test data is maintained in TestData.xlsx

JSON test data is stored under src/test/resources

TestNG DataProviders are used to supply data to test cases

🧑‍💻 Author

Prabhat Bhardwaj
Senior QA Engineer

🔗 GitHub: https://github.com/Prabhat-bhardwaj

🔗 LinkedIn: https://www.linkedin.com/in/qa-prabhat-bhardwaj

⭐ Notes

This framework is designed for real-world automation practice

Structure aligns with enterprise-level Selenium frameworks

Can be extended for CI/CD integration
