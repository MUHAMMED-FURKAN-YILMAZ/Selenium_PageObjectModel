package tests.MentoringProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.List;

public class C02_WebTable {


    @Test
    public void test()  {
        //go to url : https://en.wikipedia.org/wiki/Dell
        //go to table which name is 'List of companies acquired by Dell Inc.'
        //print row 5 of the table on console
        //also print on console the 2nd and 3rd elements (middle 2 elements) in line 10
        //( 2nd and 3rd elements : April 2, 2012 A global market-leader for thin client systems)

        Driver.getDriver().get("https://en.wikipedia.org/wiki/Dell");

        WebElement row5OfTable=Driver.getDriver().findElement(By.xpath("//table[3]//tr[5]"));
        System.out.println(row5OfTable.getText());



        List<WebElement> row10=Driver.getDriver().findElements(By.xpath("//table[3]//tr[10]//td"));
        row10.stream().forEach(t->System.out.println(t.getText()));
        System.out.println(row10.size());
        System.out.println("2nd element of line 10-> "+ row10.get(0).getText());
        System.out.println("3nd element of line 10-> "+ row10.get(1).getText());

    }




}
