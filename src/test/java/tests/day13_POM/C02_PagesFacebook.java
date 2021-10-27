package tests.day13_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.TestBase;

public class C02_PagesFacebook extends TestBase {

    @Test
    public void test(){
        // facebook login sayfasina gidin
        driver.get("https://www.facebook.com");
        FacebookPage facebookPage=new FacebookPage(driver);

        // page sayfasinda cookiesGec() methodu olustur
// Eger cookies sorunu varsa bu method kullanilabilir
//        facebookPage.cookiesGec();

        // kullanici adi : techproed@hotmail.com
        facebookPage.emailBox.sendKeys("techproed@hotmail.com");

        // sifre : 12345
        facebookPage.passwordBox.sendKeys("12345");

        facebookPage.loginButton.click();

        //yazdigimizda giris yapamadigimizi test edin
        Assert.assertTrue(facebookPage.girilemediYaziElementi.isDisplayed());

    }




}
