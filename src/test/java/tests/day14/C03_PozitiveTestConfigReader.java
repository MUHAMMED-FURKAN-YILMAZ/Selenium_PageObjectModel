package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class C03_PozitiveTestConfigReader extends TestBase {

    @Test
    public void positiveTestConfig(){


        // https://www.concorthotel.com/ adresine git
        driver.get(ConfigReader.getProperty("CHUrl"));

        ConcortHotelPage concortHotelPage=new ConcortHotelPage(driver);

        // login butonuna bas
        concortHotelPage.firstlogInLink.click();

        // test data username: manager ,
        concortHotelPage.userNameBox.sendKeys(ConfigReader.getProperty("CHValidUsername"));

        // test data password : Manager1!
        concortHotelPage.passwordBox.sendKeys(ConfigReader.getProperty("CHValidPassword"));
        concortHotelPage.logInButton.click();

        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(concortHotelPage.isLoginPass.isDisplayed());

    }
}
