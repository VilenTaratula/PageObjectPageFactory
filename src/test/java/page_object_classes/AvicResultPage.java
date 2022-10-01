package page_object_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class AvicResultPage extends BasicPage {
    @FindBy(xpath = "//img[@src='https://avic.ua/assets/frontend/images/avic.svg']")
    private WebElement logoImage;

    @FindBy(xpath = "//a[contains(@data-ecomm-cart,'\"id\":249362')]")
    private WebElement buttonBuyArticleIphone13ProMax;

    @FindBy(xpath = "//div[@class='header-bottom__right-icon']//i[@class='icon icon-cart-new']")
    private WebElement logoCart;

    public AvicResultPage(WebDriver driver) {
        super(driver);
    }

    public AvicHomePage forward() {
        getDriver().navigate().forward();
        return new AvicHomePage(getDriver());
    }

    public AvicHomePage clickLogoOnResultPage() {
        logoImage.click();
        return new AvicHomePage(getDriver());
    }

    public AvicCartPage clickOnLogoCart() {
        logoCart.click();
        return new AvicCartPage(getDriver());
    }

    public String getUrl() {
        return getDriver().getCurrentUrl();
    }

    public AvicCartPage addArticleToCart() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(buttonBuyArticleIphone13ProMax).pause(500).click().build().perform();
        return new AvicCartPage(getDriver());
    }

}
