package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewParticipantPage {

    private final WebDriver driver;

    @FindBy(xpath = "//span[@class='glyphicon glyphicon-plus']")
    private WebElement addNewParticipantButton;

    @FindBy(xpath = "//a[@id='bankLink-api/participant/1060']")
    private WebElement mirPayButton;  //Элемент найден для того, чтобы убедиться, что данное меню прогрузилось,
                                      // иначе нажатие на кнопку "Добавление нового участника" провалится

    @FindBy(xpath = "//button[@id='saveForm-btn']")
    private WebElement saveFormButton;

    @FindBy(xpath = "//select[@id='formInput-select-participantType']")
    private WebElement participantTypeButton;

    @FindBy(xpath = "//option[@label='Кредитная организация']")
    private WebElement participantTypeChooseButton;

    @FindBy(xpath = "//input[@id='formInput-typeahead-bic']")
    private WebElement bicField;

    @FindBy(xpath = "//input[@id='formInput-fullName']")
    private WebElement fullNameField;

    @FindBy(xpath = "//input[@id='formInput-name']")
    private WebElement nameField;

    @FindBy(xpath = "//input[@id='formInput-nameTrans']")
    private WebElement transNameField;

    @FindBy(xpath = "//input[@id='formInput-address1']")
    private WebElement firstAddressField;

    @FindBy(xpath = "//input[@id='formInput-address2']")
    private WebElement secondAddressField;

    @FindBy(xpath = "//input[@id='formInput-ksInCb']")
    private WebElement ksInCbField;

    @FindBy(xpath = "//input[@id='formInput-inn']")
    private WebElement innField;

    @FindBy(xpath = "//input[@id='formInput-kpp']")
    private WebElement kppField;

    @FindBy(xpath = "//input[@id='formInput-license']")
    private WebElement LicenseField;

    @FindBy(xpath = "//div[@class='alert animate-slide ng-binding alert-success']")
    private WebElement newFormSuccessfulCreationAlert;

    @FindBy(xpath = "//button[@id='add-new-bankInPs']")
    private WebElement addNewBankInPsButton;

    public NewParticipantPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void addNewParticipant() {
        Wait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(mirPayButton));
        addNewParticipantButton.click();
    }

    public void newFormFieldsFilling() {
        participantTypeButton.click();
        participantTypeChooseButton.click();
        bicField.sendKeys("234567890");
        fullNameField.sendKeys("Яковлев Марк");
        nameField.sendKeys("SDET School");
        transNameField.sendKeys("Yakovlev Mark");
        firstAddressField.sendKeys("г. Москва 1");
        secondAddressField.sendKeys("г. Москва 2");
        ksInCbField.sendKeys("30101000000000000957");
        innField.sendKeys("7103002406");
        kppField.sendKeys("710201001");
        LicenseField.sendKeys("3159");
        saveFormButton.click();
    }

    public void newFormValidationChecker() {
        String actualText = newFormSuccessfulCreationAlert.getText();
        Assert.assertTrue("Error", actualText.contains("Новый объект Участник создан!"));
    }

    public NewNetworkIdPage clickOnAddNewBankInPs() {
        addNewBankInPsButton.click();
        return new NewNetworkIdPage(driver);
    }
}
