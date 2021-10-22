package tests.day16;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.Driver;

public class C03_WebTablesHomework1 {
    //Sayfa 193

    //● Bir class oluşturun : D18_WebTables

    QAConcortPage qaConcortPage=new QAConcortPage();




    @BeforeClass
    public void login(){
        //● login() metodun oluşturun ve oturum açın.
        //● https://www.concorthotel.com/ /admin/HotelRoomAdmin adresine gidin
        //○ Username : manager ○ Password : Manager1!

        qaConcortPage.concortHotelLogin();
    }

    @Test
    public void table(){
        //● table() metodu oluşturun
        //○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        //○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.

        System.out.println("Table'in sutun sayisi "+qaConcortPage.basliklarListesi.size());
        qaConcortPage.basliklarListesi.stream().forEach(t->System.out.println(t.getText()));

    }

    @Test
    public void printRows(){
//● printRows() metodu oluşturun //tr
        //○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        //○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        //○ 4.satirdaki(row) elementleri konsolda yazdırın.

        System.out.println("Toplam satir sayisi "+qaConcortPage.satirlarListesi.size());
        for (int i = 0; i < qaConcortPage.satirlarListesi.size(); i++) {
            System.out.println(i+1+". satir: "+qaConcortPage.satirlarListesi.get(i).getText());
        }

        System.out.println("Dorduncu satir "+qaConcortPage.dorduncuSatir.getText());

    }

    @Test
    public void printCells() {
        //● printCells() metodu oluşturun //td
        //○ table body’sinde bulunan toplam hücre(cell) sayısını bulun.
        //○ Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
        System.out.println("Tablo body'sindeki tüm hücrelerin sayisi : "+qaConcortPage.tablodakiTumTdList.size());

       // Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),5);
        wait.until(ExpectedConditions.visibilityOf(qaConcortPage.tBodyTumu));

        System.out.println("Tablo body'si : \n"+qaConcortPage.tBodyTumu.getText());

    }

    @Test
    public void printColumns(){
//● printColumns() metodu oluşturun
        //○ table body’sinde bulunan toplam sutun(column) sayısını bulun.
        //○ Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
        //○ 5.column daki elementleri konsolda yazdırın.

        System.out.println("Table body'sinin sutun sayisi "+qaConcortPage.basliklarListesi.size());
        qaConcortPage.basliklarListesi.stream().forEach(t->System.out.println(t.getText()));
        System.out.println("***********************************");
        qaConcortPage.besinciSutunListesi.stream().forEach(t->System.out.println(t.getText()));


    }

}
