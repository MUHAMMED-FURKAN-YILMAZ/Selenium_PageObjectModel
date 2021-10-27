package tests.day14_POM;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.DhtmlGoodiesPage;
import utilities.TestBase;

public class C06_MentoringProject extends TestBase {

 /*
    go to url : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
    Fill in capitals by country
     */

    @Test
    public void test(){

        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        DhtmlGoodiesPage dhtmlGoodiesPage=new DhtmlGoodiesPage(driver);

        Actions actions=new Actions(driver);

        actions
                .dragAndDrop(dhtmlGoodiesPage.osloDrag, dhtmlGoodiesPage.norwayBox)
                .dragAndDrop(dhtmlGoodiesPage.stockholmDrag, dhtmlGoodiesPage.swedenBox)
                .dragAndDrop(dhtmlGoodiesPage.washingtonDrag, dhtmlGoodiesPage.unitedStatesBox)
                .dragAndDrop(dhtmlGoodiesPage.copenhagenDrag, dhtmlGoodiesPage.denmarkBox)
                .dragAndDrop(dhtmlGoodiesPage.seoulDrag, dhtmlGoodiesPage.southKoreaBox)
                .dragAndDrop(dhtmlGoodiesPage.romeDrag,dhtmlGoodiesPage.italyBox)
                .dragAndDrop(dhtmlGoodiesPage.madridDrag, dhtmlGoodiesPage.spainBox).perform();

    }
}
