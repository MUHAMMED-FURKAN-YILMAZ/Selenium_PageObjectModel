package tests.day14_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class C05_NegativeTestConfigReader extends TestBase {

    @Test
    public void test(){
        //https://www.concorthotel.com/ adresine git
        driver.get(ConfigReader.getProperty("CHUrl"));

        ConcortHotelPage concortHotelPage=new ConcortHotelPage(driver);

        // login butonuna bas
        concortHotelPage.firstlogInLink.click();

        // test data username: manager1
        concortHotelPage.userNameBox.sendKeys(ConfigReader.getProperty("CHInvalidUsername"));

        // test data password : manager1!
        concortHotelPage.passwordBox.sendKeys(ConfigReader.getProperty("CHInvalidPassword"));
        concortHotelPage.logInButton.click();

        // Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(concortHotelPage.isLoginFailed.isDisplayed());
    }
}
