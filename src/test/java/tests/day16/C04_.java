package tests.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.Driver;

import java.util.List;

public class C04_ {
    //● Bir class oluşturun : D18_WebTables

    QAConcortPage qaConcortPage=new QAConcortPage();

    @Test (priority = -1)
    public void login(){
        //● login() metodun oluşturun ve oturum açın.
        //● https://qa-environment.concorthotel.com/ /admin/HotelRoomAdmin adresine gidin
        //○ Username : manager ○ Password : Manager1!

        qaConcortPage.concortHotelLogin();

        qaConcortPage.hotelManagementLİnk.click();
        qaConcortPage.hotelRoomsLink.click();
    }

    @Test (dependsOnMethods ="login" )
    public void table(){
        //● table() metodu oluşturun
        //○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        //○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        System.out.println(qaConcortPage.basliklarListesi.size());
   //     qaConcortPage.basliklarListesi.stream().forEach(t->System.out.println(t.getText()));

        for (int i = 0; i <qaConcortPage.basliklarListesi.size() ; i++) {
            System.out.println(i+1+". satir: "+qaConcortPage.basliklarListesi.get(i).getText());
        }

    }

    @Test (dependsOnMethods ="login" )
    public void printRows(){
        //● printRows() metodu oluşturun //tr
        //○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        //○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        //○ 4.satirdaki(row) elementleri konsolda yazdırın.
    }

    @Test (dependsOnMethods ="login" )
    public void printCells(){
        //● printCells() metodu oluşturun //td
        //○ table body’sinde bulunan toplam hücre(cell) sayısını bulun.
        //○ Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
        System.out.println(qaConcortPage.tablodakiTumTdList.size());
        System.out.println(qaConcortPage.tBodyTumu.getText());

    }

    @Test(dependsOnMethods = "login")
    public void printColumns() {
        //○ table body’sinde bulunan toplam sutun(column) sayısını bulun.
        int columnNumberInTableBody = Driver.getDriver().findElements(By.xpath("//tbody//tr[1]//td")).size();
        System.out.println("Column number in table body is: " + columnNumberInTableBody);
        System.out.println("-------------------------------------------------------------------------");
        //○ Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
        for (int i = 1; i < columnNumberInTableBody + 1; i++) {
            List<WebElement> eachColumnElements = Driver.getDriver().findElements(By.xpath("//tbody//td[" + i + "]"));
            System.out.println(i + ". Column's Elemnts are: ");
            System.out.println("---------------------------");
            eachColumnElements.stream().forEach(t -> System.out.println(t.getText()));
            System.out.println();
        }

    }


}
