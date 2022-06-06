import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccount extends BasePage {
    //Test 3: Kreiranje Accounta za tog Customera

    private By customerNameField = By.xpath("//*[@id=\"userSelect\"]");
    private By currencyField = By.xpath("//*[@id=\"currency\"]");
    private By processBtn = By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/form/button");

    public CreateAccount(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public boolean isProcessBtnDisplayed() {
        return getDriver().findElement(processBtn).isDisplayed();
    }

    public void customerFieldSelect(String fullName) {
        Select select = new Select(getDriver().findElement(customerNameField));
        getDriver().findElement(customerNameField).click();
        select.selectByVisibleText(fullName);
    }

    public void currencyFieldSelect(String options) {
        Select select = new Select(getDriver().findElement(currencyField));
        getDriver().findElement(currencyField).click();
        select.selectByVisibleText(options);
    }

    public void processBtnClick() {
        getDriver().findElement(processBtn).click();
    }

}
