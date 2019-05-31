package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class NewProfilePage {

    private final WebDriver driver;

    @FindBy(xpath = "//input[@id='formInput-date-effectiveDate']")
    private WebElement effectiveDateFoField;

    @FindBy(xpath = "//button[@id='saveForm-btn']")
    private WebElement SaveFormButton;

    @FindBy(xpath = "//div[@class='alert animate-slide ng-binding alert-success']")
    private WebElement newProfilePageCreationAlert;

    @FindBy(xpath = "//button[@id='add-new-acqBin']")
    private WebElement addListOfEkvBinsButton;

    public NewProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getActualDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();
        String output = dateFormat.format(date);
        return output;
    }

    public void newEffectiveDateFieldFilling() { effectiveDateFoField.sendKeys(getActualDate()); }

    public void clickOnSaveFormButton() {SaveFormButton.click();}

    public void newProfilePageValidationChecker() {
        String alertText = newProfilePageCreationAlert.getText();
        Assert.assertTrue("Error", alertText.contains("Новый объект Профиль Участника создан!"));
    }

    public NewAcqBinPage clickOnAddListOfEkvBinsButton() {
        addListOfEkvBinsButton.click();
        return new NewAcqBinPage(driver);
    }
}
