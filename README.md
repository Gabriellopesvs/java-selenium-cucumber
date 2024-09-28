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
    Given the website "https://example.com" is accessed
    When the user logs in with the following credentials:
      | name      | password  |
      | myUser    | myPass    |
    Then the user should be logged in and see a success message
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

### Example Step Definitions:

- Accessing the website:

```java
Accessing the website:
```

This initializes the Selenium WebDriver and navigates to the given URL.

- Logging in with credentials:

```java
@When("the user logs in with the following credentials:")
public void the_user_logs_in_with_the_following_credentials(io.cucumber.datatable.DataTable dataTable) {
    List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);
    String name = comp.getValue(table, 0);
    String password = comp.getValue(table, 1);
    comp.commandPage(driver, "name", page.name(), "click", null);
    comp.commandPage(driver, "name", page.name(), "send", name);
    comp.commandPage(driver, "id", page.password(), "click", null);
    comp.commandPage(driver, "id", page.password(), "send", password);
}
```

This method fills in the login form with the provided username and password using Selenium.

- Validating successful login:

```java
@Then("the user should be logged in and see a success message")
public void the_user_should_be_logged_in_and_see_a_success_message() {
    comp.commandPage(driver, "xpath", page.button(), "click", null);
    init.quitPage();
}
```

This validates that the login was successful and closes the browser after.

## elementsWeb.java

The elementsWeb.java file contains locators for web elements. It centralizes the management of web element locators, making it easier to update if the web page structure changes.

```java
public String name() { return "username"; }
public String password() {return "password";}
```

## component.java

The component.java file likely contains helper functions or reusable components that are used across multiple test scenarios, simplifying test code and promoting reuse.

## What's New?

This project now supports the following technologies:
- Java 11+
- Selenium WebDriver 4.x
- Cucumber 6.x for BDD-style testing.

### How to Use This Project:

To use this project, simply clone the repository and configure the required dependencies using Maven.

## Running the Tests:

You can run the Cucumber tests using the following Maven command:

```bash
mvn test
```
