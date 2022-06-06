import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class XYZBankTest {

    private WebDriver driver;
    private WebDriverWait driverWait;
    private BasePage basePage;
    private BankManager bankManager;
    private CustomerOptions customerOptions;
    private CreateAccount createAccount;
    private CreateCustomer createCustomer;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tubic\\Desktop\\IT BOOTCAMP\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));

        bankManager = new BankManager(driver, driverWait);
        createCustomer = new CreateCustomer(driver, driverWait);
        createAccount = new CreateAccount(driver, driverWait);
        customerOptions = new CustomerOptions(driver, driverWait);
        basePage = new BasePage(driver, driverWait);


        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

    }

    //Test 1: Logovanje kao Bank Manager
    @Test(priority = 1)
    public void bankManagerLogin() throws InterruptedException {
        driverWait.until(ExpectedConditions.elementToBeClickable(bankManager.getBankManagerLoginBtn()));
        Thread.sleep(5000);
        bankManager.bankManagerLoginClick();
        Assert.assertTrue(bankManager.isButtonsDisplayed());

    }

    //Test 2: Kreiranje Customera
    @Test(priority = 2)
    public void createNewCustomer() throws InterruptedException {

        Thread.sleep(3000);
        driverWait.until(ExpectedConditions.elementToBeClickable(bankManager.getAddCustomerBtn()));
        bankManager.addCustomerBtnClick();
        Thread.sleep(5000);
        Assert.assertTrue(createCustomer.verifyThatThreeFieldsAreVisible());
        createCustomer.addCustomerFirstName("Danijela");
        createCustomer.addCustomerLastName("Tubić");
        createCustomer.addCustomerPostCode("1223");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        createCustomer.clickCustomerSubmitButton();
        String actualResult = basePage.alertMessages();
        Assert.assertTrue(actualResult.contains("Customer added successfully"));
        basePage.skipAlertMessages();

    }

    //    //Test 3: Kreiranje Accounta za tog Customera
    @Test(priority = 3)
    public void createAccount() throws InterruptedException {
        driverWait.until(ExpectedConditions.elementToBeClickable(bankManager.getOpenAccountBtn()));
        bankManager.openAccountBtnClick();
        Thread.sleep(5000);
        Assert.assertTrue(createAccount.isProcessBtnDisplayed());
        Thread.sleep(3000);
        createAccount.customerFieldSelect("Danijela Tubić");
        createAccount.currencyFieldSelect("Dollar");
        createAccount.processBtnClick();
        String actualResult = basePage.alertMessages();
        Assert.assertTrue(actualResult.contains("Account created successfully"));
        basePage.skipAlertMessages();

    }

    @Test (priority = 4)
    public void managerLogout () {
        bankManager.bankManagerLogout();
        Assert.assertTrue(customerOptions.verifyThatYourNameFieldIsDisplayed());
        bankManager.homeBtnClick();
    }

    //Test 4: Logovanje kao Customer
    @Test(priority = 5)
    public void CustomerLogin() throws InterruptedException {
        Thread.sleep(3000);
        driverWait.until(ExpectedConditions.elementToBeClickable(customerOptions.getCustomerLoginHomeBtn()));
        customerOptions.customerHomeLoginBtnClick();
        customerOptions.verifyThatYourNameFieldIsDisplayed();
        customerOptions.selectCustomersName("Danijela Tubić");
        driverWait.until(ExpectedConditions.elementToBeClickable(customerOptions.getCustomerLoginBtn()));
        customerOptions.loginButtonClick();
        String actualWelcomeMessage = customerOptions.welcomeMessageDisplayed();
        Assert.assertTrue(actualWelcomeMessage.contains("Welcome"));
    }

    //    //Test 5: Uspešan Deposit za nekog Customera
    @Test(priority = 6)
    public void depositTest() throws InterruptedException {
        Thread.sleep(3000);
        customerOptions.depositClick();
        customerOptions.isDepositBtnClicked();
        customerOptions.fillDepositAmountField(300);
        driverWait.until(ExpectedConditions.elementToBeClickable(customerOptions.getDepositBtnAfterAmount()));
        Thread.sleep(3000);
        customerOptions.depositBtnAfterAmountClick();
        Assert.assertTrue(customerOptions.verifyThatDepositBtnAfterAmountIsClicked());
        Thread.sleep(3000);
    }

    //    //Test 6: Uspešan Withdrawal za nekog Customera
    @Test(priority = 7)
    public void withdrawlTest() throws InterruptedException {
        Thread.sleep(3000);
        customerOptions.withdrawlClick();
        customerOptions.isWithdrawlBtnClicked();
        Thread.sleep(3000);
        customerOptions.fillWithdrawlField(200);
        Thread.sleep(3000);
        driverWait.until(ExpectedConditions.elementToBeClickable(customerOptions.getWithdrawlBtnAfterAmount()));
        customerOptions.withdrawlBtnAfterAmountClick();
        Assert.assertTrue(customerOptions.verifyThatWithdrawlBtnAfterAmountIsClicked());
    }

   //Test 8: Logout za Customera
    @Test (priority = 8)
    public void customerLogout(){
        customerOptions.customerLogout();
        Assert.assertTrue(customerOptions.verifyThatYourNameFieldIsDisplayed());
        }

    @AfterClass
    public void afterClass(){
        driver.close();
        driver.quit();
    }
    }



