package tests.day19;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_Raporlama extends TestBaseRapor{

    @Test
    public void test1(){
        // amazon sayfasina gidip
        // nutella icin arama yapalim
        // sonuc yazisinin 1000'den az oldugunu test edelim

        extentTest=extentReports.createTest("Nutella testi","sonuc sayisi 1000'den az olmali");

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("amazon sayfasina gidildi");



        WebElement aramaKutusu=Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys(ConfigReader.getProperty("amazonArananKelime")+Keys.ENTER);
        extentTest.pass("Searchbox'ta nutella icin arama yapildi");

        WebElement sonucSayisiElementi=Driver.getDriver().findElement(By.xpath("(//span[@dir='auto'])[1]"));

        String sonucYazisi= sonucSayisiElementi.getText();
        String sonucArrayi[]=sonucYazisi.split(" ");
        int sonucSayisi=Integer.parseInt(sonucArrayi[2]);
        extentTest.info("sonuc yazisi int haline getirildi");

        Assert.assertTrue(sonucSayisi<1000);
        extentTest.pass("sonuc sayisinin 1000'den az oldugu tespit edildi");


    }

    @Test
    public void test2(){
        // amazon sayfasina gidip
        // samsung icin arama yapalim
        // sonuc yazisinin 1000'den az oldugunu test edelim

        extentTest=extentReports.createTest("Samsung testi","sonuc sayisi 1000'den az olmali");

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("amazon sayfasina gidildi");


        WebElement aramaKutusu=Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Samnsung"+Keys.ENTER);
        extentTest.pass("Searchbox'ta nutella icin arama yapildi");

        WebElement sonucSayisiElementi=Driver.getDriver().findElement(By.xpath("(//span[@dir='auto'])[1]"));

        String sonucYazisi= sonucSayisiElementi.getText();
        String sonucArrayi[]=sonucYazisi.split(" ");

        String sonucAdedi=sonucArrayi[3];
        sonucAdedi=sonucAdedi.replace(",","");
        int sonucSayisi=Integer.parseInt(sonucAdedi);
        extentTest.info("sonuc yazisi int haline getirildi");

        Assert.assertTrue(sonucSayisi<1000);
        extentTest.pass("sonuc sayisinin 1000'den az oldugu tespit edildi");
    }

    @Test
    public void test3(){
        // amazon sayfasina gidip
        // electronic kategorisinde java icin arama yapalim
        // ilk sonucun cikan sonuclardan ilkinin isminde java oldugunu test edelim

        extentTest=extentReports.createTest("Java testi","ilk urunde java olmali");

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("amazona gidildi");

        Select select=new Select(Driver.getDriver().findElement(By.id("searchDropdownBox")));
        select.selectByVisibleText("Electronics");
        extentTest.info("amazon dropdown'dan Electronics secildi");

        WebElement aramaKutusu=Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+Keys.ENTER);
        extentTest.info("arama kutusunda java yazilip arandi");

        String ilkElementYazisi=Driver.getDriver().findElement(By.xpath("        //span[text()='UNFUSED J2A040 40k EEPROM with 2 Track Hi CO Magstripe Compatible JCOP21 36K Java JCOP Based Smart Card with SDK Kit 5 Pcs']\n")).getText();


        Assert.assertTrue(ilkElementYazisi.contains("Java"));
        extentTest.info("Secili urunde java kelimesi arandi");

    }
}
