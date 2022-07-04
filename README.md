# Assignment

[Click here to read the assignment](./docs/assignment.md)

## vanilla

This is a base starter kit framework that you can use to build your tests for the above assignment.
However, if you are more comfortable with your own tool kit, feel free to use that as well!

## External dependencies

For this project to run, you would need to install below 3 dependencies on your machine:

- **[Java 11](https://openjdk.java.net/projects/jdk/11/)** (as the core programming language)
- **[Maven 3.8.5](https://maven.apache.org/download.cgi)** (for dependency management)
- **[Google Chrome latest version](https://www.google.com/chrome/?brand=CHBD&gclid=Cj0KCQjwr-SSBhC9ARIsANhzu15P0PA-n9Zp4NpxKaOHVGtBD1TZQH0HlQQE6hUfsOFAU1nf-Rzdlf4aAoTJEALw_wcB&gclsrc=aw.ds)** (browser to run your tests)

> If your JAVA_HOME is set to anything other than JDK 11, you would need to update the path. Else your project
> will not run. Also, do remember to set the correct JDK settings in your IDE.

## Getting Started

For easiest way to getting started, extract this project and open it from IntelliJ.
> Then Do a dry run on test in : test -> java -> TestSandbox class and see if your setup is correct.  

Tip: Do remember to update this readme file for anything else that you think needs updating here!

## Success

## Dependencies were added to the project

- **[Selenide 6.6.6](https://selenide.org/index.html)**
- **[Allure-report](https://docs.qameta.io/allure/)**

## Running tests and generating a report

Command to run tests
> mvn clean test

When the tests are done.
Then the folder allure-results will be automatically created in the root of the project

<p align="left"><img src="../vanilla/docs/allure/allure-result.png" width="350px" height="350px"/></p>

To generate an allure-report you should use the command

> allure generate --clean

To view the results of the tests. Then open allure-report -> index.html

<p align="left"><img src="../vanilla/docs/allure/allure-report.png" width="340px" height="340px"/></p>

### An example of allure-report

<p align="center"><img src="../vanilla/docs/allure/allure-result-3.png" width="850px" height="600px"/></p>
<p align="center"><img src="../vanilla/docs/allure/allure-result-1.png" width="950px" height="600px"/></p>
<p align="center"><img src="../vanilla/docs/allure/allure-result-2.png" width="950px" height="600px"/></p>

### Note to allure-report:
1. Screenshots are added to the report if the test fails
2. Steps and additional parameters are customizable

