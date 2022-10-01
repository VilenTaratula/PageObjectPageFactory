package page_object_classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AvicCartPage extends AvicHomePage{
    String articleCodeXpath = "//span[@class='code']";

    public AvicCartPage(WebDriver driver) {
        super(driver);
    }

    public String getArticleCode() {
        return findElementByXpath(articleCodeXpath).getText();
    }

}
