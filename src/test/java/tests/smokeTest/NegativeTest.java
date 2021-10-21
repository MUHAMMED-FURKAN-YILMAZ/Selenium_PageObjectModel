package tests.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class NegativeTest {

    //1) smokeTest paketi altinda yeni bir Class olustur: NegativeTest
    //3 Farkli test Methodunda 3 senaryoyu test et
    // - yanlisSifre
    // - yanlisKulllanici
    // - yanlisSifreKullanici
    //test data yanlis username: manager1 , yanlis password : manager1!
    //2) https://qa-environment.concorthotel.com/ adresine git
    //3) Login butonuna bas
    //4) Verilen senaryolar ile giris yapilamadigini test et

    QAConcortPage qaConcortPage;


    @Test
    public void invalidPassword(){

        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

        qaConcortPage=new QAConcortPage();

        qaConcortPage.firstlogInLink.click();

        qaConcortPage.userNameBox.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        qaConcortPage.passwordBox.sendKeys(ConfigReader.getProperty("CHQAInvalidPassword"));
        qaConcortPage.logInButton.click();

        Assert.assertTrue(qaConcortPage.isLoginFailed.isDisplayed());


    }

    @Test(priority = 1)
    public void invalidUserName(){

        qaConcortPage=new QAConcortPage();

        qaConcortPage.userNameBox.clear();
        qaConcortPage.userNameBox.sendKeys(ConfigReader.getProperty("CHQAInvalidUsername"));

        qaConcortPage.passwordBox.clear();
        qaConcortPage.passwordBox.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        qaConcortPage.logInButton.click();

        Assert.assertTrue(qaConcortPage.isLoginFailed.isDisplayed());


    }

    @Test(priority = 2)
    public void invaliUserNamePassword(){

        qaConcortPage=new QAConcortPage();

        qaConcortPage.userNameBox.clear();
        qaConcortPage.userNameBox.sendKeys(ConfigReader.getProperty("CHQAInvalidUsername"));

        qaConcortPage.passwordBox.clear();
        qaConcortPage.passwordBox.sendKeys(ConfigReader.getProperty("CHQAInvalidPassword"));
        qaConcortPage.logInButton.click();

        Assert.assertTrue(qaConcortPage.isLoginFailed.isDisplayed());

        Driver.closeDriver();

    }



}
