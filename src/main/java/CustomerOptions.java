import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerOptions extends BasePage {

    //Test 4: Logovanje kao Customer
    //Test 5: Uspešan Deposit za nekog Customera
    //Test 6: Uspešan Withdrawal za nekog Customera
    //Test 8: Logout za Customera


    private By customerLoginHomeBtn = By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[1]/button");
    private By userSelectYourName = By.id("userSelect");
    private By customerLoginBtn = By.xpath("/html/body/div/div/div[2]/div/form/button");
    private By welcomeMessage = By.xpath("//*[contains (text(), ' Welcome ')]");
    private By customerLogoutBtn = By.xpath("/html/body/div/div/div[1]/button[2]");
    private By deposit = By.xpath("/html/body/div[1]/div/div[2]/div/div[3]/button[2]");
    private By amountInDeposit = By.xpath("/html/body/div[1]/div/div[2]/div/div[4]/div/form/div/input");
    private By depositBtnAfterAmount = By.xpath("/html/body/div[1]/div/div[2]/div/div[4]/div/form/button");
    private By depositMessage = By.xpath("/html/body/div[1]/div/div[2]/div/div[4]/div/span");
    private By withdrawl = By.xpath("/html/body/div[1]/div/div[2]/div/div[3]/button[3]");
    private By amountInWithdrawl = By.xpath("/html/body/div[1]/div/div[2]/div/div[4]/div/form/div/input");
    private By withdrawlBtnAfterAmount = By.xpath("/html/body/div[1]/div/div[2]/div/div[4]/div/form/button");
    private By withdrawlMessage = By.xpath("/html/body/div[1]/div/div[2]/div/div[4]/div/span");


    public CustomerOptions(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void customerHomeLoginBtnClick() {
        getDriver().findElement(customerLoginHomeBtn).click();
    }

    public boolean verifyThatYourNameFieldIsDisplayed () {
        return getDriver().findElement(userSelectYourName).isDisplayed();
    }

    public void selectCustomersName(String customersName) {
        Select select = new Select(getDriver().findElement(userSelectYourName));
        getDriver().findElement(userSelectYourName).click();
        select.selectByVisibleText(customersName);
    }

    public By getCustomerLoginHomeBtn() {
        return customerLoginHomeBtn;
    }

    public By getCustomerLoginBtn() {
        return customerLoginBtn;
    }

    public By getWithdrawlBtnAfterAmount() {
        return withdrawlBtnAfterAmount;
    }

    public By getDepositBtnAfterAmount() {
        return depositBtnAfterAmount;
    }

    public void loginButtonClick() {
        getDriver().findElement(customerLoginBtn).click();
    }

    public String welcomeMessageDisplayed (){
        String actualWelcomeMessage = welcomeMessage.toString();
        return actualWelcomeMessage;
    }

    public void depositClick() {
        getDriver().findElement(deposit).click();
    }

    public boolean isDepositBtnClicked() {
        return getDriver().findElement(amountInDeposit).isDisplayed();

    }

    public void fillDepositAmountField(int amount) {
        getDriver().findElement(amountInDeposit).sendKeys((String.valueOf(amount)));
    }

    public void depositBtnAfterAmountClick() {
        getDriver().findElement(depositBtnAfterAmount).click();
    }

//    public String getDepositeMessage() {
//        return getDriver().findElement(depositMessage).getText();
//    }
//
//    public String depositSuccessfulMessage (){
//        String actualSuccessfulMessage = depositMessage.toString();
//        return actualSuccessfulMessage;
 //   }

    public boolean verifyThatDepositBtnAfterAmountIsClicked() {
        return getDriver().findElement(depositMessage).isDisplayed();
    }

    public void withdrawlClick() {
        getDriver().findElement(withdrawl).click();
    }

    public boolean isWithdrawlBtnClicked() {
        return getDriver().findElement(amountInWithdrawl).isDisplayed();

    }

    public void fillWithdrawlField(int amount) {
        getDriver().findElement(amountInWithdrawl).sendKeys((String.valueOf(amount)));
    }

    public void withdrawlBtnAfterAmountClick() {
        getDriver().findElement(withdrawlBtnAfterAmount).click();
    }

    public boolean verifyThatWithdrawlBtnAfterAmountIsClicked() {
        return getDriver().findElement(withdrawlMessage).isDisplayed();
    }


//    public String getWithdrawlMessage() {
//        return getDriver().findElement(withdrawlMessage).toString();
//    }

    public void customerLogout() {
        getDriver().findElement(customerLogoutBtn).click();
    }

}
