package tests.MentoringProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.List;

public class C02_WebTable2 {
    @Test
    public void test() {
        //go to url : https://en.wikipedia.org/wiki/Dell
        //go to table which name is 'List of companies acquired by Dell Inc.'
        //print row 5 of the table on console
        //also print on console the 2nd and 3rd elements (middle 2 elements) in line 10
        //( 2nd and 3rd elements : April 2, 2012 A global market-leader for thin client systems)
        Driver.getDriver().get("https://en.wikipedia.org/wiki/Dell");

        WebElement table= Driver.getDriver().findElement(By.xpath("//table[@class='wikitable sortable jquery-tablesorter']"));
        Assert.assertTrue(table.isDisplayed());

        System.out.println(Driver.getDriver().findElement(By.xpath("//table[3]//tr[5]")).getText());

        List<WebElement> line10= Driver.getDriver().findElements(By.xpath("//table[3]//tr[10]//td"));
        //line10.stream().forEach(t->System.out.println(t.getText()));

        System.out.println(line10.size());
        System.out.println(line10.get(0).getText());
        System.out.println(line10.get(1).getText());

    }
}
