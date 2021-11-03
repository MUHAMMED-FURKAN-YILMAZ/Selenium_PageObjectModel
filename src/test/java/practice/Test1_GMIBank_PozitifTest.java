package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GMIBankPage;

public class Test1_GMIBank_PozitifTest {

    GMIBankPage gmiBankPage;

    @Test
    public void signInTest(){
        gmiBankPage.gmiBankLogIn();

        Assert.assertTrue(gmiBankPage.girisOnay.isDisplayed());
    }

    @Test
    public void signOutTest(){
        gmiBankPage.girisOnay.click();
        gmiBankPage.signOutButonu.click();
    }

}
