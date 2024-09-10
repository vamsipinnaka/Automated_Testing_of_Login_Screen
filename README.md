# Automated_Testing_of_Login_Screen
This repository contains automated test scripts designed to ensure the reliability and functionality of the login screen in an application
# Project Documentation

## Test Execution Steps

### Prerequisites:
- Verify that your machine has Maven, Eclipse IDE, and Java installed.
- Verify that the Drivers executable is loaded and that the system environment variables or the code have the proper path specified for it.

### Setup:
1. Create a project repository on your computer/IDE.
2. Go to the project directory and locate the `pom.xml` file there.

### Dependencies:
- Make sure your `pom.xml` contains the Apache POI and TestNG dependencies. If not, add the necessary dependencies for TestNG (to execute tests) and Apache POI (to perform Excel operations).

### Test Data:
- Put the test data-containing Excel file (`vamsi.xlsx`) in the folder (`./testdata/vamsi.xlsx`), which is relative to the root of your project. Data from "Sheet1" in the Excel file of test data:
  
  | username                                        | password                                      |
  |-------------------------------------------------|-----------------------------------------------|
  | 200303124421@paruluniversity.ac.in              | 200303124421@paruluniversity.ac.in            |
  | 200303124421@paruluniversity.ac.in              | sfsfasf                                       |
  | svhvxashvdh                                     | 200303124421@paruluniversity.ac.in            |
  |                                                 |                                               |
  | 200303124421@paruluniversity.ac.in              |                                               |
  |                                                 | 200303124421@paruluniversity.ac.in            |

### Configuration:
- If the ChromeDriver path is not set globally, update it in the `German_login_*` classes.
- Create a `pom` class to store all web elements of the web page (WebElement Repository).
- Create an Excel utility to avoid hard-coding data.
- Make sure the `German_login_*` classes' URL is accurate for your testing setup.

### Execution:
- We can execute individual test cases directly by clicking the run button in the IDE.
- We can run the test suite using your IDE’s TestNG integration.

### Review Results:
- Check the TestNG reports generated in the “test-output/emailable-reports.html”.

## Assumptions:
- The Google Chrome version that is installed on your computer is compatible with the ChromeDriver version.
- The test data in the Excel file `vamsi.xlsx` is precise and has the structure that is anticipated: The password and email should be in the designated rows of the file.

## Additional Information

### Limitations:
- The assumption made by the test scripts is that the structure and content of the error messages and login page are constant. The `German_Pom` class's XPath locators may need to be updated in response to any modifications made to the page structure.

### Challenges:
- The way in which various error messages are handled and any layout modifications to the login page may result in unexpected test failures. It could be necessary to update and maintain locators on a regular basis.

### Potential Improvements:
- **Refactor Test Classes:** To reduce code duplication, consider rearranging the test classes to utilize a single class with dynamic row fetching.
- **Parameterization:** To handle a greater range of test cases or user situations in a more scalable way, use parameterized tests.
