# WestWing Automation Tasks
# pageobjectmodel
web test automation framework with Page Object Model design using Java + Maven + TestNG

Task 1 & Task 2 : Completed by POM (Page object model)

Technologies/Tools used in building the framework
=================================================
- Eclipse - IDE
- Selenium - WebDriver - Chrome
- Maven - Build automation tool
- Java - Programming language
- TestNG - Test Management library
- Log4J - Logging framework
- Extent Reports - Reporting framework
- JSON/Excel - Test Data
- XML - Static text
- GitHub - Version control
- Jenkins - CI/CD

Framework implements below best practices
=========================================
- Code reusability
- Code readability
- Scalable automation (demonstrated using multiple test classes)
- Uses explicit waits
- Abstraction layer for UI commands like click, sendkeys, etc.
- Parameterization using TestNG XML and config.properties
- Alternate Design approach [Without using inheritance]
- Exception handling [using Try/Catch and TestNG Listener]
- Abstraction layer for test data
- Abstraction layer for static text
- Supports iOS and Android
- Demonstrates how to define UI elements that are common across pages (e.g. menu bar, side bar, etc.)
- How to recover from test failure/ how to write fail safe test cases
- Scrolling for both Android and iOS (using touchaction, uiScrollable, mobile:scroll)
- Demonstrates how to effectively capture Screenshots/Videos
- Supports parallel execution on multiple real Android and iOS devices
- Integrated with Log4J2 Logging framework (supports basic as well as parallel logging)
- Integrated with Extent Reporting framework (supports parallel, screenshots, logging test steps)


# Test Plan for WestWing Application
WestWing is application which is helping to end customer for selecting Home Decoration Products.

Below list of topics which going to help you for to define future testing & automation regression scope 


### For Smoke Test Cases, Please refer below basic check points. Need to check in every release.
   
* Installation
* Differnt Login Overlay
* Add, delete product in wishlist
* Filters on home page
* Product details and price
* One E2E flow


### For Regression Test Cases, Please refer below basic check points. Need to check in every release.


- Number of test cases for login 
- Number of test cases  Product list validation
- Number of test cases for Selected looks and belownging products
- Number of test cases for wishlist single product validaton and multiproduct validation
- E2E flow from login - Home - Looks - model - select first product  - add in wishlist- select product and checkout

### For Non Functional Testing, Please refer below basic check points. Need to check in every release.

- Application Performance
- Navigation of Application
- UI & Look Fill
- Network 4G, Wi-Fi 


### ISSUE/Observation

- Differnt login popup which should be same with all pages
- Application crash sometime while login multiple time


### Scope

- Web (login/product list/wishlist/checkout/payment/ordernumber)

### Descope

- Any moibile and physical devices - Descoped for automation

### Execute Test

- Open project in Eclipse -> Build the project -> Download resources -> Execute it.
- 
### Consideration

- used Single login for all test cases
- Targeted single product to add in wishlist and delete it

