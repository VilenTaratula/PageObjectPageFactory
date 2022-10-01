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

public class AvicHomePage extends BasicPage{
    @FindBy(xpath = "//img[@src='https://avic.ua/assets/frontend/images/avic.svg']")
    private WebElement logoImage;

    @FindBy(xpath = "//a[@href='https://avic.ua/ua/noutbuki-i-aksessuaryi']//span[@class='sidebar-item-title']")
    private WebElement sideBarNotebooks;

    @FindBy(xpath = "//a[normalize-space()='']//div[@class='header-bottom__login flex-wrap middle-xs']")
    private WebElement signInLogo;

    @FindBy(xpath = "//body/div[@id='mm-0']/main[@class='main main-page']/section[@class='category-slider']/div[@class='container']/div[@class='row sidebar-overlay']/div[@class='sidebar-wrapp']/div[@class='sidebar']/div[@class='menu-lvl first-level']/ul[@class='sidebar-list sidebar-list--fl']/li[1]/a[1]")
    private WebElement sideBarApple;

    @FindBy(xpath = "//a[normalize-space()='iPhone']//i[@class='icon icon-expand-more']")
    private WebElement sideBarIphone;

    @FindBy(xpath = "//li[contains(@class,'single-hover-block')]/a[contains(@href,'/ua/iphone/seriya--iphone-13-promax')]")
    public WebElement iphone13ProMax;

    public AvicHomePage(WebDriver driver) {
        super(driver);
    }

    public String getTitle(){
    return getDriver().getTitle();
    }
    public String getUrl() {
    return getDriver().getCurrentUrl();
    }

    public AvicHomePage refresh() {
        getDriver().navigate().refresh();
        return this;
    }

    public AvicResultPage back() {
        getDriver().navigate().back();
        return new AvicResultPage(getDriver());
    }

    public AvicResultPage clickOnLogoHomePage(){
        logoImage.click();
        return new AvicResultPage(getDriver());
    }
    public AvicResultPage clickOnSideBarNotebooks() {
        sideBarNotebooks.click();
        return new AvicResultPage(getDriver());
    }

    public AvicLoginPage clickOnSignInLogo() {
        signInLogo.click();
        return new AvicLoginPage(getDriver());
    }

    public AvicResultPage clickOnArticleFromSideBar() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(sideBarApple).pause(500).perform();
        actions.moveToElement(sideBarIphone).pause(500).perform();
        actions.moveToElement(iphone13ProMax).pause(500).click().perform();
        return new AvicResultPage(getDriver());
    }
    public WebElement findElementByXpath(String xpath) {
        return (new WebDriverWait(getDriver(), Duration.of(10, ChronoUnit.SECONDS)))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }


}
