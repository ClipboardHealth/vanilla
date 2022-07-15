# Clipboard Amazon Assignment

#Initial framework setup pulled from Amuthansakthivel(Staff Software Engineer - TestOps - Clipboard Health). 
#Based on the ideas and learning from his youtube video automated this assignment

### Assignment test cases and checklist
Validate “AboutThisItem” section presence in second highest priced item
1. Open https://www.amazon.in/. Note: Clicking on above URL may redirect you to amazon.com. Change it to amazon.in
2. Click on the hamburger menu in the top left corner.
3. Scroll own and then Click on the TV, Appliances and Electronics link under shop by Department section.
4. Then click on Televisions under Tv, Audio & Cameras sub section.
5. Scroll down and filter the results by Brand ‘Samsung’.
6. Sort the Samsung results with price High to Low.
7. Click on the second highest priced item (whatever that maybe at the time of automating).
8. Switch the Window
9. Assert that “About this item” section is present and log this section text to console/report.

## Running Tests :

Prerequisites: Java 8+ , Maven 3.6.3 Installed and path set

1. There are multiple ways to run the tests. During development phase you can use the **testng.xml** present in the root folder to run. Right click and choose run.
2. Each of the testng xml file should contain the test classes to pick for the run.
3. User can also choose the thread-count parameter to run the tests in parallel.
4. User can also choose to run via maven commands which is highly recommended.
5. Maven profiles are configured in the pom.xml. You can run these from IDE Terminal or any OS Terminal inside the
   project folder.

`mvn clean test -Pall` - To run all the tests available in the testng.xml

Note : User should not try to run the test from test class - Might end up in NPE. Because the listeners are configured only in testng.xml

## Libraries Used :

1. **Selenium** - Web Automation
2. **TestNG** - Unit Testing Library
3. **Extent Reports** - Reporting Library to generate beautiful html reports
4. **AssertJ** - Fluent Assertion Library in Java
5. **WebDriverManager** - Executables management
6. **Lombok** - To reduce boilerplate codes

**Note : All the aforementioned libraries are open-source and does not include any license.**

## Capabilities:

1. This framework has the capability to run the tests in local and remote selenium grid.
2. It can also be extended to run on clouds like browser stack or seetest.
3. Web Tests can be run on chrome or edge browsers.
4. Configuration can be changed from config.properties inside src/test/resources
5. Utility methods available for Web Interactions *(SeleniumActions.java)*
6. Integration with Jenkins for scheduling is easy. :raising_hand:
7. Can be integrated with Jenkins and docker execution can be done

## Adding more tests :
Prerequisites: Java 8+ , Maven 3.6.3 Installed and path set

1. Tests should be added as per the convention followed. New testng tests should be created inside the src/test/java
   folder.
2. All the tests should extend BaseTest.java
3. Each test created should define the description as mandatory parameters. This will be helpful while creating
   the extent reports.
4. All the tests should be follow AAA pattern - **ARRANGE, ACT and ASSERT**
5. Have maximum of one to two assertions per test.
6. Tests should interact only with the Facade layer. This can be used to wrap the business logic.

## Questions :
Framework developed by Amuthansakthivel
For any further clarification - please reach out to `mech.amuthansakthivel@gmail.com`
