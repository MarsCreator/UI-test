package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthorizationPage {

    private final WebDriver driver;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement entranceButton;

    public AuthorizationPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void loginInput (String login) {
        loginField.sendKeys(login);
    }

    public void passwordInput (String password) {
        passwordField.sendKeys(password);
    }

    public NewParticipantPage clickOnEntranceButton() {
        entranceButton.click();
        return new NewParticipantPage(driver);
    }
}
