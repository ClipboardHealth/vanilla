# 1. Execution on Local machine :
`Browser choices are : chrome, firefox, edge`

`Pre-Requisite : GlobalProperties.Proprties file - 'Env' should be set to 'local', 'Browser' should be set to 'chrome'`

Execution is possible in multiple ways :
1. Right click 'testng.xml' and select "Run"
2. Click on Maven toolbar on far right in IntelliJ IDE and expand project folder. Right click on 'package' and select "Run Maven Build"
3. Right click Test1 file (src/test/java/com/testCases/Test1.java) and select "Run"

# 2. Execution on Selenium Grid :
`Browser choices are : chrome, firefox, ie, safari(mac) depending on selenium grid support`

Pre-Requisites :
1. GlobalProperties.Properties file - 'Env' should be set to 'selenium_grid'
2. Download Selenium server standalone package - https://www.selenium.dev/downloads/
3. Copy jar file to project directory
4. Open terminal from the project directory and Run the command (replace filename with downloaded filename) :
    1. `java -jar filename.jar standalone`
5. Verify hub and note is up at : http://localhost:4444/grid/console
6. To execute test, use either #1/#2,#3 step from Local execution procedure. 

For reports, modify run/debug configuration. Go to "Listeners" section and select checkbox "Use default reporters" and apply the configuration change. Now if we execute with testng.xml, it will create a test-output directory and the reports can be viewed there, example index.html
