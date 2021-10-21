package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver(){

    }


    private static WebDriver driver;
    //driver'i baska class'lardan sadece Driver class ismi ile cagirabilmek icin STATİC yaptik
    // hebuz bu driver ile ilgili ayarlar yapmadigim icin baska class'lardan bu driver class'i kullanmasin diye
    // erisimi private yaptik (sadece bu class'in kullanimina cik yaptik)

    public static WebDriver getDriver() {


        if (driver == null) {
            //if'in nedeni bu method her calistiginda yeni bir driver olusturmamasi icin kullaniyoruz
            //if driver'i kontrol edecek eger bir deger atamasi yapildiysa yeni bir driver olusturmayacak

            switch (ConfigReader.getProperty("browser")) {
                //case'i driver'i istedigimiz browser'da calistirmak icin kullaniyoruz
                //configuration.properties dosyasina browser olarak ne yazdiksa tum testlerimiz o browser'da calisacak
                //browser secimi yapilmadiysa default olarak chrome devreye girecek
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;

                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class);
                    driver = new SafariDriver();
                    break;

                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }
            return driver;
        }


        public static void closeDriver () {
             if (driver != null) {
                 driver.quit();
             }
             // burada yeniden null degeri atamamizin sebebi, bir sonraki getDriver()
             // method'u cagirisimizda yeni deger atayabilmek istememizdir
             driver=null;
        }


    }


