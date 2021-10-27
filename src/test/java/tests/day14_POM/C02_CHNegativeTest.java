package tests.day14_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.TestBase;

public class C02_CHNegativeTest extends TestBase {
    //Bir test method olustur NegativeLoginTest()
    // https://www.concorthotel.com/ adresine git
    @Test
    public void NegativeLoginTest() {
        driver.get("https://www.concorthotel.com/");

        ConcortHotelPage concortHotelPage = new ConcortHotelPage(driver);

        // login butonuna bas
        concortHotelPage.firstlogInLink.click();

        // test data username: manager1 ,
        concortHotelPage.userNameBox.sendKeys("manager1");

        // test data password : manager1!
        concortHotelPage.passwordBox.sendKeys("Manager1!");
        concortHotelPage.logInButton.click();

        // Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(concortHotelPage.isLoginFailed.isDisplayed());

    }

}
