# Assignement OverView

- Tried to use and add to existing framework in JUnit
- Thought of Using Hamcrest Assertions but since there was only 1 assertion it test, did not add the overhead
- Added the page verification for each page(using wait option.If element not found, timeout exception will be thrown)
- As of now used class variables to store the By Object of locators. This can be further improved with custom junit annotation to return a WebElement/WrappedWebElement
- Wanted to give docker a try unfortunately my personal laptop is unable to bear the load of docker service and was taking lot longer.

# How to run
- Test can be run by just right clicking on com.amazon.TestAssignment.java class and selecting run as Junit.
- To run from terminal (Maven has to be installed) ,run command "mvn clean test -DHOST=host.localhost"
