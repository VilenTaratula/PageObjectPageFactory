import org.testng.annotations.*;
import page_object_classes.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class AvicSiteTest extends SiteTest {

    @Test
    public void testLogoCorrectUrl() {
        AvicHomePage avicHomePage = new AvicHomePage(getDriver())
                .clickOnLogoHomePage()
                .clickLogoOnResultPage()
                .back()
                .forward()
                .refresh();
        assertEquals(avicHomePage.getUrl(), expectedHomePageUrl);
    }

    @Test
    public void testCorrectUrlAfterClickOnSideBarNotebooks() {
        AvicResultPage avicResultPage = new AvicHomePage(getDriver())
                .clickOnSideBarNotebooks();
        assertEquals(avicResultPage.getUrl(), expectedNoteBookPageUrl);
    }

    @Test
    public void testTitle() {
        AvicHomePage avicHomePage = new AvicHomePage(getDriver());
        assertEquals(avicHomePage.getTitle(), expectedTitle);
    }

    @Test
    public void testLoginWithIncorrectPhoneAndPassword() {
        AvicLoginPage avicLoginPage = new AvicHomePage(getDriver())
                .clickOnSignInLogo()
                .sendKeysToPhoneNumberField(wrongPhoneNumber)
                .sendKeysToPasswordField(wrongPassword)
                .clickSubmitButton();
        assertTrue(avicLoginPage.findMessageWindow());
    }

    @Test
    public void testCart() {
        AvicCartPage avicCartPage = new AvicHomePage(getDriver())
                .clickOnArticleFromSideBar()
                .addArticleToCart();
        String expectedResult = avicCartPage.getArticleCode();
        avicCartPage.refresh()
                .clickOnLogoHomePage()
                .clickOnLogoCart();
        String actualResult = avicCartPage.getArticleCode();
        String message = "Expected: \"" + expectedResult + "\" differs from: \"" + actualResult + "\"";
        assertEquals(avicCartPage.getArticleCode(), expectedResult, message);
    }

}
