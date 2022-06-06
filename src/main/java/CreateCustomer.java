import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCustomer extends BasePage {
    //Test 2: Kreiranje Customera

    private By addCustomer = By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/button[1]");
    private By customerFirstName = By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/form/div[1]/input");
    private By customerLastName = By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/form/div[2]/input");
    private By customerPostCode = By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/form/div[3]/input");
    private By addCustomerBtn = By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/form/button");

    public CreateCustomer(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public boolean verifyThatThreeFieldsAreVisible() {
        return getDriver().findElement(customerFirstName).isDisplayed() &&
                getDriver().findElement(customerLastName).isDisplayed() &&
                getDriver().findElement(customerPostCode).isDisplayed();
    }

    public void addCustomerFirstName(String addFirstName) {
        getDriver().findElement(customerFirstName).sendKeys(addFirstName);
    }

    public void addCustomerLastName(String addLastName) {
        getDriver().findElement(customerLastName).sendKeys(addLastName);
    }

    public void addCustomerPostCode(String addPostCode) {
        getDriver().findElement(customerPostCode).sendKeys(addPostCode);
    }

    public void clickCustomerSubmitButton() {
        getDriver().findElement(addCustomerBtn).click();
    }

}
