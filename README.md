# Java Selenium Cucumber Automation Project

[![Build Status](https://travis-ci.org/your-username/java-selenium-cucumber.svg?branch=master)](https://travis-ci.org/your-username/java-selenium-cucumber "Travis CI")
[![codecov](https://codecov.io/gh/your-username/java-selenium-cucumber/branch/master/graph/badge.svg)](https://codecov.io/gh/your-username/java-selenium-cucumber)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.your-username/java-selenium-cucumber.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22io.github.your-username%22%20AND%20a:%22java-selenium-cucumber%22)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

## Overview:

This project is an automated testing framework built using **Java**, **Selenium**, and **Cucumber**. It leverages the power of Cucumber to define test scenarios in plain language (Gherkin), while Selenium handles the web interactions.

## Problem Statement:
- Automating web application testing using scenarios written in a human-readable format (Gherkin).
- Running end-to-end tests that cover the user interface through Selenium WebDriver.

## Solution:
This project allows the execution of BDD (Behavior-Driven Development) style tests, where the scenarios are defined in the `*.feature` files, and the steps are implemented using Java. Selenium is used to interact with the web elements, providing a powerful combination for end-to-end testing.

## Files

- [pom.xml](#pom-xml)
- [login.feature](#login-feature)
- [webDriverSetup.java](#webdriver-setup)
- [testRunner.java](#test-runner)
- [webTest.java](#web-test)

## Functions

- [elementsWeb.java](#elementsweb-java)
- [component.java](#component-java)

### pom.xml

The `pom.xml` file is the configuration file for **Maven**, and it manages the project's dependencies. Key dependencies for this project include:
- **Selenium**: For browser automation.
- **Cucumber**: For BDD-style testing.
- **JUnit**: For running the Cucumber tests.

### login.feature

The `login.feature` file contains the Gherkin scenarios that define the login tests for the web application. The tests are written in a natural language format, making them easy to understand.

#### Example Scenario:

```gherkin
Feature: Login functionality

  Scenario: Valid user login
    Given the user is on the login page
    When the user enters valid credentials
    Then the user should be logged in successfully
```
This scenario outlines the steps for testing a valid user login, which are later implemented in the step definitions.

## webDriverSetup.java

The webDriverSetup.java file is responsible for configuring the Selenium WebDriver. It sets up the browser instance and manages the browser lifecycle, including opening and closing the browser.

## testRunner.java

The testRunner.java file is the Cucumber test runner. It is used to execute the Cucumber scenarios defined in the *.feature files. This runner links the feature files with the step definitions and manages the execution of the tests.

### Example Test Runner:

```java
@RunWith(Cucumber.class)
@CucumberOptions(
  features = "features",
  glue = "steps",
  plugin = {"pretty", "html:target/cucumber-reports"}
)
public class testRunner {
}
```

This runner looks for feature files in the features folder and step definitions in the steps package.

## webTest.java

The webTest.java file contains the step definitions that link the Gherkin steps to the actual test code. This file translates the plain English steps into Selenium actions.

### Example Step Definition:

