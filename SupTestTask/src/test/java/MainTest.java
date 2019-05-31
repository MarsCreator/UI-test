import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

public class MainTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setDriver() {
        driver = new ChromeDriver();
    }

    @Before
    public void setUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("url");
    }

    public MainTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
    }

    @Test
    public void supTest() throws InterruptedException {
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        authorizationPage.loginInput("login");
        authorizationPage.passwordInput("password");

        NewParticipantPage newParticipantPage = authorizationPage.clickOnEntranceButton();
        newParticipantPage.addNewParticipant();
        newParticipantPage.newFormFieldsFilling();
        newParticipantPage.newFormValidationChecker();

        NewNetworkIdPage newNetworkIdPage = newParticipantPage.clickOnAddNewBankInPs();
        newNetworkIdPage.newBankInPsFieldsFilling();
        newNetworkIdPage.newBankInPsValidationChecker();

        NewProfilePage newProfilePage = newNetworkIdPage.clickOnAddNewBankProfile();
        newProfilePage.newEffectiveDateFieldFilling();
        newProfilePage.clickOnSaveFormButton();
        newProfilePage.newProfilePageValidationChecker();

        NewAcqBinPage newAcqBinPage = newProfilePage.clickOnAddListOfEkvBinsButton();
        newAcqBinPage.clickOnSaveAcqFormButton();
        newAcqBinPage.newAcqBinPageValidationChecker();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
