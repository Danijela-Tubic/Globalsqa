import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BankManager extends BasePage {

    /*Test 1: Logovanje kao Bank Manager
    Test 7: Logout za Bank Managera*/

    private By bankManagerLoginBtn = By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[2]/button");
    private By bankManagerLogout = By.xpath("/html/body/div/div/div[1]/button[2]");
    private By addCustomerBtn = By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/button[1]");
    private By openAccountBtn = By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/button[2]");
    private By customersBtn = By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/button[3]");
    private By homeButton = By.xpath("/html/body/div/div/div[1]/button[1]");


    public BankManager(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public By getBankManagerLoginBtn() {
        return bankManagerLoginBtn;
    }

    public By getAddCustomerBtn() {
        return addCustomerBtn;
    }

    public By getOpenAccountBtn() {
        return openAccountBtn;
    }

    public void bankManagerLoginClick() {
        getDriver().findElement(bankManagerLoginBtn).click();
    }

    public boolean isButtonsDisplayed() {
        return getDriver().findElement(addCustomerBtn).isDisplayed() &&
                getDriver().findElement(openAccountBtn).isDisplayed() &&
                getDriver().findElement(customersBtn).isDisplayed();
    }

    public void addCustomerBtnClick() {
        getDriver().findElement(addCustomerBtn).click();
    }

    public void openAccountBtnClick() {
        getDriver().findElement(openAccountBtn).click();
    }


    public void bankManagerLogout() {
        JavascriptExecutor j = (JavascriptExecutor) getDriver();
        WebElement hidenLogoutBtn = getDriver().findElement(bankManagerLogout);
        j.executeScript("$(arguments[0]).click();", hidenLogoutBtn);

    }

    public void homeBtnClick() {
        getDriver().findElement(homeButton).click();
    }
}
