package page_object_classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AvicLoginPage extends BasicPage{

    @FindBy(xpath = "//input[@data-validate='login']")
    private WebElement phoneNumberField;

    @FindBy(xpath = "//input[contains(@class,'validate show-password')]")
    private WebElement passwordField;
    @FindBy(xpath = "//button[contains(@class,'button-reset main-btn submit main-btn--green')]")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='col-xs-12 js_message']")
    private WebElement messageWindow;

    public AvicLoginPage(WebDriver driver) {
        super(driver);
    }

    public AvicLoginPage sendKeysToPhoneNumberField(String phoneNumber) {
        phoneNumberField.sendKeys(phoneNumber);
        return this;
    }
    public AvicLoginPage sendKeysToPasswordField(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public AvicLoginPage clickSubmitButton() {
        submitButton.click();
        return new AvicLoginPage(getDriver());
    }
    public boolean findMessageWindow() {
        return messageWindow.isDisplayed();
    }
}
