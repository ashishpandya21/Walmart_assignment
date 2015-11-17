# Walmart_assignment

1. Import the project to eclipse or any IDE of your choice.

2. Also if Selenium set up is not there download latest Selenium webdriver and related libs at one location. e.g: desktop/abc/selenium-webdriver

3. Once step 2 complete, for imported project we need to configure build path
Proj name > build path > configure build path 
then import all libs downloaded for selenium webdriver into here.

4. Next once the code has got all its dependent file, to run code click on 'test-output' directory. Right click on "Testing.xml" and Run as "TestNG Suite".

5. In code its been divided as 
@BeforeTest : so that method executes before actual test scenarios are tested
@Test : testing scenarios during Run time.
@AfterTest : post above two method done, this is testcase quit closing browser and session mostly.

6. Code is divided into methods login, searchProduct and addItemsToCart. So each method takes care of functionality it needs to cover.

7. PFA another file AshishAssignment.java for code review.
