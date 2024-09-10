package vamsi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class German_Pom {
    // Define WebElements using @FindBy annotation
    @FindBy(xpath = "//input[@id='username']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//button[normalize-space()='Log In']")
    private WebElement login;

    @FindBy(xpath = "//li[contains(text(),'Please enter a correct username and password. Note')]")
    private WebElement errorMessage;


    // Constructor to initialize WebDriver and PageFactory elements
    public German_Pom(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Method to enter email
    public void enterEmail(String email) {
        this.email.clear();
        this.email.sendKeys(email);
    }

    // Method to enter password
    public void enterPassword(String password) {
        this.password.clear();
        this.password.sendKeys(password);
    }

    // Method to click on login button
    public void clickLoginButton() {
        login.click();
    }

    // Method to get error message after login attempt
    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
