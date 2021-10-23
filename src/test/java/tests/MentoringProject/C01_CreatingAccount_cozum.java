package tests.MentoringProject;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

/*
 * Part 1:
 *  Open "https://courses.ultimateqa.com/users/sign_up"
 *  create random and valid first name, last name, email and password, store for later validating
 *  fill in account submission form with data above
 *  Click on checkbox with id="user[terms]" to agree with terms and conditions
 *  click on "Sign up" button
 *  go to https://courses.ultimateqa.com/account
 *  validate that first name, last name and email you provided earlier is correct
 *
 * Part 2 (Optional)
 *  sign out of the website
 *  go to "https://courses.ultimateqa.com/users/sign_in"
 *  fill in sign in form with your stored email and password
 *  click on "Sign in" button
 *  validate that message "Signed in successfully." is displayed
 *
 * NOTE:Captcha on this website is un-avoidable,
 * so you will have to solve it by hand to allow script to continue
 */

public class C01_CreatingAccount_cozum {

    static Faker faker = new Faker();
    static String first_name = faker.name().firstName();
    static String last_name = faker.name().lastName();
    static String email = faker.internet().emailAddress();
    static String password = faker.internet().password();
    static WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 500);

    @Test(priority = 1)
    public void test1() throws InterruptedException {
        // * Part 1:
        // *  Open "https://courses.ultimateqa.com/users/sign_up"
        Driver.getDriver().get("https://courses.ultimateqa.com/users/sign_up");

        // *  create random and valid first name, last name, email and password, store for later validating
        // *  fill in account submission form with data above
        // *  Click on checkbox with id="user[terms]" to agree with terms and conditions
        // *  click on "Sign up" button
        Actions actions = new Actions(Driver.getDriver());

        actions.click(Driver.getDriver().findElement(By.id("user[first_name]"))).
                sendKeys(first_name).
                sendKeys(Keys.TAB).
                sendKeys(last_name).
                sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(password).
                sendKeys(Keys.TAB).
                sendKeys(Keys.SPACE).
                click(Driver.getDriver().findElement(By.xpath("//input[@value='Sign up']"))).
                perform();

        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.tagName("h3"))));

        // *  go to https://courses.ultimateqa.com/account
        Driver.getDriver().navigate().to("https://courses.ultimateqa.com/account");

        // *  validate that first name, last name and email you provided earlier is correct
        Driver.getDriver().findElement(By.id("user[email]")).sendKeys(Keys.TAB, first_name, Keys.TAB,
                last_name, Keys.TAB, Keys.TAB, Keys.TAB,
                Keys.TAB, Keys.ENTER);
    }
    @Test(priority = 2)
    public void test2() throws InterruptedException {
        // * Part 2 (Optional)
        // *  sign out of the website
        Driver.getDriver().findElement( By.cssSelector( "a.dropdown__toggle-button" )).click();
        Driver.getDriver().findElement(By.xpath( "//a[contains(text(), 'Sign Out')]" )).click();

        // *  go to "https://courses.ultimateqa.com/users/sign_in"
        Driver.getDriver().navigate().to("https://courses.ultimateqa.com/users/sign_in");

        // *  fill in sign in form with your stored email and password
        // *  click on "Sign in" button
        Thread.sleep(3000);
        Driver.getDriver().findElement(By.id("user[email]")).sendKeys(email,Keys.TAB,password,
                Keys.TAB,Keys.SPACE,Keys.TAB,Keys.TAB,
                Keys.TAB,Keys.TAB);

        Driver.getDriver().findElement(By.xpath("//input[@type='submit']")).click();

        // *  validate that message "Signed in successfully." is displayed
        wait.until(ExpectedConditions.visibilityOf( Driver.getDriver().findElement(By.xpath("//p[text()='Signed in successfully.']"))));
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//p[text()='Signed in successfully.']")).isDisplayed());

    }
}
