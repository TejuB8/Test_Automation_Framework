
# Test Automation Framework

This repository contains a Java-based Test Automation Framework.

The framwork leverages various libraries and tools to facilitate data-driven testing, logging, reporting and integration with cloud-based testing platform like lambdatest.




## 🚀 About Me
Hi, My name is Tejaswini Borakanavar and I have 4 years of experience in Automation testing using technologies like Selenium Webdriver, RestAssured.



## Author

- [@TejuB8](https://github.com/TejuB8)
- EmailAddress: tejuborakanavar19@gmail.com


## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/TejuB8)

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/tejaswini-borakanavar-2a748b1a4/)



## Prerequisites

Before running the framework, ensure the following are installed:

- **Java JDK 11**
- **Maven**

## Features

- **Modular & Scalable Architecture**: Clean, reusable design that is easy to maintain and extend.
- **Cross-Browser Testing**: Supports multiple browsers using configurable CLI parameters.
- **Local & LambdaTest Execution**: Run the same tests locally or on LambdaTest cloud without code changes.
- **Headless Mode Support**: Enables faster execution for CI/CD and resource-efficient runs.
- **Data-Driven Testing**: Supports CSV, JSON, and Excel-based test data sources.
- **Dynamic Test Data Generation** – Uses Faker library to generate realistic, random test data.
- **CLI-Based Execution**: Tests can be executed via Maven Surefire with runtime parameters.
- **Rich HTML Reporting**: Generates detailed Extent Reports after each execution.
- **Centralized Logging**: Captures execution logs using Log4j for easy debugging.
- **CI/CD Ready**: Designed for seamless integration with popular CI pipelines.
- **TestNG-Based Framework**: Leverages TestNG for lifecycle management and flexible test control.


## Tech Stack & Tools Used
- Java 11
- TestNG
- Maven
- LambdaTest
- Extent Reports
- Log4j
- OpenCSV, Gson, Apache POI
- Java Faker


## Setup Instructions

**Clone the Repository**:

```bash
 git clone https://github.com/TejuB8/Test_Automation_Framework.git
 
 cd Test_Automation_Framework
```

**Running Tests on LambdaTest**:

```bash
mvn clean test -Dbrowser=chrome -DisLambdaTest=true -DisHeadless=false -x

```

**Running Tests on chrome browser on Local Machine in Headless mode**:

```bash
mvn clean test -Dbrowser=chrome -DisLambdaTest=false -DisHeadless=true -x

```

## Reports and Logs

- **Reports**: After execution a detailed HTML report will be generated at ./report.html.

- **Logs**: Logs are created during the test execution and stored in the ./logs/ directory. 


## Integrated the project with Github Actions
This automation framework is Integrated with github actions. The tests will ve executed at 11:30 PM IST every single day.
