package tests.MentoringProject;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;

public class C01_ {
    /**
     * Part 1:
     *  Open "https://courses.ultimateqa.com/users/sign_up"
     *  create random and valid first name, last name, email and password, store for later validating
     *  fill in account submission form with data above
     *  Click on checkbox with id="user[terms]" to agree with terms and conditions
     *  click on "Sign up" button
     *  go to https://courses.ultimateqa.com/account
     *  validate that first name, last name and email you provided earlier is correct
     */
     @Test
    public void test() throws InterruptedException {
         Driver.getDriver().get("https://courses.ultimateqa.com/users/sign_up");

         Faker faker=new Faker();
         String name = faker.name().name();
         String lastName = faker.name().lastName();
         String password = faker.internet().password();
         String email = faker.internet().emailAddress();


         Actions actions=new Actions(Driver.getDriver());

         actions
                 .sendKeys(name)
                 .sendKeys(Keys.TAB)
                 .sendKeys(lastName)
                 .sendKeys(Keys.TAB)
                 .sendKeys(email)
                 .sendKeys(Keys.TAB)
                 .sendKeys(password)
                 .sendKeys(Keys.TAB)
                 .sendKeys(Keys.SPACE)
                 .sendKeys(Keys.TAB)
                 .sendKeys(Keys.TAB)
                 .sendKeys(Keys.TAB)
                 .sendKeys(Keys.TAB)
                 .sendKeys(Keys.TAB)
                 .sendKeys(Keys.ENTER).perform();


         Thread.sleep(45000);


         Driver.getDriver().navigate().to("https://courses.ultimateqa.com/account");


         Assert.assertTrue(Driver.getDriver().findElement(By.id("user[email]")).getAttribute("value").equals(email));
         Assert.assertTrue(Driver.getDriver().findElement(By.id("user[first_name]")).getAttribute("value").equals(name));
         Assert.assertTrue(Driver.getDriver().findElement(By.id("user[last_name]")).getAttribute("value").equals(lastName));



         /*
          * Part 2 (Optional)
          *  sign out of the website
          *  go to "https://courses.ultimateqa.com/users/sign_in"
          *  fill in sign in form with your stored email and password
          *  click on "Sign in" button
          *  validate that message "Signed in successfully." is displayed
          *
          * NOTE:Captcha on this website is un-avoidable,
          * so you will have to solve it by hand to allow script to continue
          **/

        Driver.getDriver().findElement(By.xpath("//a[@class='dropdown__toggle-button']")).click();
        Driver.getDriver().findElement(By.partialLinkText("Sign Out")).click();

        Driver.getDriver().get("https://courses.ultimateqa.com/users/sign_in");

        actions
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(password).perform();

        actions.click(Driver.getDriver().findElement(By.xpath("//input[@value='Sign in']"))).perform();


         Thread.sleep(45000);

         SoftAssert softAssert=new SoftAssert();

        WebElement successfullyText=Driver.getDriver().findElement(By.tagName("p"));

        softAssert.assertTrue(successfullyText.isDisplayed(),"basarili yazisi goruntulenemiyor");

         System.out.println("Gayet Basarili");

     }



}
