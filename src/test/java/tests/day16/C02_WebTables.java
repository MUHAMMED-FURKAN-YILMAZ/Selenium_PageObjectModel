package tests.day16;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.Driver;

public class C02_WebTables {

    @Test
    public void test() throws InterruptedException {
        //Bir class oluşturun : C02_WebTables
        //● login() metodun oluşturun ve oturum açın.
        //● https://www.concorthotel.com//admin/HotelRoomAdmin adresine gidin
        // ○ Username : manager
        // ○ Password : Manager1!
        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.concortHotelLogin();

        qaConcortPage.hotelManagementLİnk.click();
        qaConcortPage.hotelRoomsLink.click();

        //● table() metodu oluşturun
        // ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        System.out.println("Tablodaki sutun sayisi "+qaConcortPage.basliklarListesi.size());


        // ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        System.out.println("**********"+qaConcortPage.tBodyTumu.getText());
// Eger tum tablo body'sini hucrelere ayirmadan tek bir String olarak gormek istersek
// tum body'i tek bir Webelement olarak locate edebiliriz
// Bu yaklasim, tabloda HAPPY HOTEL var mi gibi sorular icin ideal bir cozum olur

        Thread.sleep(1000);

        Assert.assertTrue(qaConcortPage.tBodyTumu.getText().contains("HAPPY HOTEL"));



        for (WebElement each: qaConcortPage.basliklarListesi) {
            System.out.println(each.getText());
        }
        // qaConcortPage.basliklarListesi.stream().forEach(t->System.out.println(t.getText()));


        //● printRows() metodu oluşturun //tr
        // ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        System.out.println("Tablodaki satir sayisi "+qaConcortPage.satirlarListesi.size());

        // ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        System.out.println(qaConcortPage.birinciSatir.getText());

        // eger tum satirlari yazdirmak istersek
        for(int i=0; i<qaConcortPage.satirlarListesi.size(); i++){
            System.out.println(i+1+". satir :"+qaConcortPage.satirlarListesi.get(i).getText());
        }

        // ○ 4.satirdaki(row) elementleri konsolda yazdırın.
        for (WebElement each: qaConcortPage.dordoncuSutunListesi) {
            System.out.println(each.getText());
        }

        Driver.closeDriver();
    }

}
