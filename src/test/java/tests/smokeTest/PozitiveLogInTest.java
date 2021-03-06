package tests.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class PozitiveLogInTest {


    @Test
    public void positiveLoginTest(){
        //Bir test method olustur positiveLoginTest()
        // https://qa-environment.concorthotel.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

        QAConcortPage qaConcortPage=new QAConcortPage();

        // login butonuna bas
        qaConcortPage.firstlogInLink.click(); //

        //test data username: manager ,
        qaConcortPage.userNameBox.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));

        //test data password : Manager1!
        qaConcortPage.passwordBox.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        qaConcortPage.logInButton.click();

        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(qaConcortPage.isLoginPass.isDisplayed());

        Driver.closeDriver();


    }

}
