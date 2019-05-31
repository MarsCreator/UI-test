package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewAcqBinPage {

    private final WebDriver driver;

    @FindBy(xpath = "//button[@class='btn btn-primary ng-scope']")
    private WebElement saveFormButton;

    @FindBy(xpath = "//button[@class='btn btn-block confirm-button ng-binding btn-danger']")
    private WebElement confirmButton;

    @FindBy(xpath = "//div[@class='alert animate-slide ng-binding alert-success']")
    private WebElement newAcqBinSuccessfulCreationAlert;

    @FindBy(xpath = "//span[@class='ng-binding']")
    private WebElement testElem;                                //Эемент необходим для того, чтобы убедиться, что страница прогрузилась

    public NewAcqBinPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        Wait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.elementToBeClickable(testElem));
    }

    public void clickOnSaveAcqFormButton() {
        saveFormButton.click();
        confirmButton.click();
    }

    public void newAcqBinPageValidationChecker() {
        String alertText = newAcqBinSuccessfulCreationAlert.getText();
        Assert.assertTrue("Error", alertText.contains("Новый объект ACQ BIN создан!"));
    }

}
