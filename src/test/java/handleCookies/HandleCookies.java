package handleCookies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HandleCookies {

    @Test
    public void handleCookies () {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.amazon.com");
        //Getting all cookie from the website:
        Set<Cookie> allCookies = driver.manage().getCookies();

        //import org.openqa.selenium.Cookie;
        int numberOfCookies = allCookies.size();
        System.out.println("Number of cookies: " + numberOfCookies);
        System.out.println("-------------------------------------");
        allCookies.stream().forEach(t-> System.out.println("Cookies names: "+t.getName() + "\nCookies values: "+ t.getValue()));
        System.out.println("-------------------------------------");

        // Getting cookie by their name:
        System.out.println("Cookie named 'i18n-prefs': " + driver.manage().getCookieNamed("i18n-prefs"));
        System.out.println("-------------------------------------");

        // How add cookie:
        Cookie myCookie = new Cookie("My Favorite Cookie","Cookie Monster 1");
        driver.manage().addCookie(myCookie);

        //We should do assignment again to see the changes, because we do not add it to the Set.
        allCookies = driver.manage().getCookies();
        System.out.println("Number of cookies: " + allCookies.size());
        allCookies.stream().forEach(t-> System.out.println("Cookies names: "+t.getName() + "\nCookies values: "+ t.getValue()));
        System.out.println("-------------------------------------");

        //How to delete cookies:
        driver.manage().deleteCookieNamed("session-id");

        //We should do assignment again to see the changes, because we do not delete it from the Set.
        allCookies = driver.manage().getCookies();
        System.out.println("Number of cookies: " + allCookies.size());
        allCookies.stream().forEach(t-> System.out.println("Cookies names: "+t.getName() + "\nCookies values: "+ t.getValue()));
        System.out.println("-------------------------------------");

        //How to delete all cookies:
        driver.manage().deleteAllCookies();
        allCookies = driver.manage().getCookies();
        System.out.println("Number of cookies: " + allCookies.size());
        allCookies.stream().forEach(t-> System.out.println("Cookies names: "+t.getName() + "\nCookies values: "+ t.getValue()));
    }
}
