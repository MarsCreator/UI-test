package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewNetworkIdPage {

    private final WebDriver driver;

    @FindBy(xpath = "//select[@id='formInput-select-networkId']")
    private WebElement networkIdField;

    @FindBy(xpath = "//option[@label='МИР']")
    private WebElement networkIdChooseButton;

    @FindBy(xpath = "//button[@class='btn btn-primary ng-scope']")
    private WebElement saveNetworkIdChangesButton;

    @FindBy(xpath = "//div[@class='alert animate-slide ng-binding alert-success']")
    private WebElement newBankInPsCreationAlert;

    @FindBy(xpath = "//button[@id='add-new-bankProfile']")
    private WebElement addNewBankProfileButton;

    public NewNetworkIdPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void newBankInPsFieldsFilling() {
        networkIdField.click();
        networkIdChooseButton.click();
        saveNetworkIdChangesButton.click();
    }

    public void newBankInPsValidationChecker() {
        String alertText = newBankInPsCreationAlert.getText();
        Assert.assertTrue("Error", alertText.contains("Новый объект Участник в платежной системе создан!"));
    }

    public NewProfilePage clickOnAddNewBankProfile() {
        addNewBankProfileButton.click();
        return new NewProfilePage(driver);
    }
}
