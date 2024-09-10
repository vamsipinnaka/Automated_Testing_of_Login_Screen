package vamsi;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class German_login_3 {

    private WebDriver driver;
    private OpenBrowser openBrowser;

    @BeforeClass
    public void setUp() {
        // Initialize ChromeDriver and configure browser settings
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // Maximize the browser window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // Set implicit wait
        openBrowser = new OpenBrowser(); // Initialize OpenBrowser class
    }

    @Test(dataProvider = "testData",priority=3)
    public void loginTest(String email, String password) {
        driver.get("https://app.germanyiscalling.com/common/login/"); // Navigate to login page
        German_Pom p = new German_Pom(driver); // Initialize Page Object Model class
        p.enterEmail(email); // Enter email
        p.enterPassword(password); // Enter password
        p.clickLoginButton(); // Click login button
        
        SoftAssert s = new SoftAssert(); // Initialize SoftAssert
        String currentUrl = driver.getCurrentUrl(); // Get current URL
        String expectedUrl = "https://app.germanyiscalling.com/cv/upload/"; // Expected URL after successful login

        if (currentUrl.equals(expectedUrl)) {
            Reporter.log("Login passed", true); // Log success message
        } else {
            Reporter.log("Login failed", true); // Log failure message
            String error = p.getErrorMessage(); // Retrieve and log error message
            Reporter.log(error, true);
            s.assertEquals(currentUrl, "https://app.germanyiscalling.com/common/login/"); // Assert URL
        }
        s.assertAll(); // Verify all soft assertions
    }

    @DataProvider(name = "testData")
    public Object[][] provideTestData() throws IOException {
        // Fetch test data from Excel
        String[] data = openBrowser.getTestData(3); // Fetch data from the 4th row (0-based index)
        return new Object[][] { { data[0], data[1] } }; // Return data as a 2D array
    }

    @AfterClass
    public void tearDown() {
        driver.quit(); // Close the browser and quit WebDriver
    }
}
