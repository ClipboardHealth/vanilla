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

## Instructions to Execute Test

execute test using IDE by running amazon.test.AssignedWorkflowTest
or execute test by command line if maven is configured
command : mvn clean test -DHOST=host.localhost

execute test in Docker

run docker compose to start docker container
command : docker-compose -f docker-compose-v3-swarm.yml up -d

then run test by command or IDE 
mvn clean test -DHOST=host.docker.container

You can also set the browser variable to run the test with Chrome/Firefox/Edge using -DBROWSER=Chrome

In order to generate a report, we should install the Allure command-line interpreter.
 
For Win 
1. Download the latest version as a zip archive from bintray https://jfrog.com/distribution/?bintrayRD=1#files/io%2Fqameta%2Fallure%2Fallure%2F2.7.0.
2. Unpack the archive to the allure-command-line directory.
3. Navigate to the bin directory.
4. Add allure to system PATH.

For Mac, you can install Allure with brew.
1.brew install allure 

then trigger command from project directory : "allure serve allure-results"
Report will be opened in the browser.
