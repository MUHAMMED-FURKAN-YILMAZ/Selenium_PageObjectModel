package tests.day17_ExcelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;


public class C01_ReadExcel {

    @Test
    public void test() throws IOException {

        //7. Dosya yolunu bir String degiskene atayalim
        String path="src/test/java/resources/ulkeler.xlsx";

        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fileInputStream=new FileInputStream(path);

        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //10. WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fileInputStream);

        //11. Worksheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet=workbook.getSheet("Sayfa1");

        //12. Row objesi olusturun sheet.getRow(index)
        Row row=sheet.getRow(2);

        //13. Cell objesi olusturun row.getCell(index)
        Cell cell=row.getCell(3);

        System.out.println(cell);
    }

    @Test
    public void test2() throws IOException {
        //7. Dosya yolunu bir String degiskene atayalim
        String path = "src/test/java/resources/ulkeler.xlsx";

        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fileInputStream = new FileInputStream(path);

        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //10. WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fileInputStream);


        //11. Worksheet objesi olusturun workbook.getSheetAt(index)


        //12. Row objesi olusturun sheet.getRow(index)


        //13. Cell objesi olusturun row.getCell(index)
        Cell cell = workbook.getSheet("Sayfa1").getRow(5).getCell(3);

        System.out.println(cell);


        //secilen hucredeki yazinin Luanda oldugunu test edin

        //Assert.assertEquals(cell, "Luanda");
// cell'in data type'i -> Cell
// Luanda ise -> String
//Data type'lari farkli oldugu icin bu ikisi equal olamaz

        Assert.assertEquals(cell.toString(), "Luanda"); // ikisi ayni sonucu verir
        Assert.assertEquals(cell.getStringCellValue(), "Luanda");
// Cell data turu yazdirilabilir ancak String methodlari ile kullanilamaz
// String Manipulation yapmak icin Cell data type'ini String'e Cast yapmaliyiz


        // index'i 3 olan satirdaki index'i 2 olan hücredeki yaziyi buyuk Harfle yazdirin
        Cell cell1=workbook.getSheet("Sayfa1").getRow(3).getCell(2);
        System.out.println(cell1.getStringCellValue().toUpperCase());


// getLastRowNum() bize son satirin index'ini verir
// getPhysicalNumberOfRows() fiili olarak kullanilan satir sayisini verir
        System.out.println(workbook.getSheet("Sayfa1").getLastRowNum());//190-> index'i veriyor(satir 191 )
        System.out.println(workbook.getSheet("Sayfa1").getPhysicalNumberOfRows());//191->physical olarak kullanilan satiri veriyor
        System.out.println(workbook.getSheet("Sayfa1").getFirstRowNum());//0 -> kullanilan il index

        System.out.println(workbook.getSheet("Sayfa2").getLastRowNum());//10->son index'i bu (satir 11 )
        System.out.println(workbook.getSheet("Sayfa2").getPhysicalNumberOfRows());//6-> 6 satir kullanimda
        System.out.println(workbook.getSheet("Sayfa2").getFirstRowNum());//1->kullanilan ilk index

        System.out.println(workbook.getSheet("Sheet1").getLastRowNum());//-1
        System.out.println(workbook.getSheet("Sheet1").getPhysicalNumberOfRows());//0
        System.out.println(workbook.getSheet("Sheet1").getFirstRowNum());//-1
    }


    @Test
    public void test3() throws IOException {
        // tablodaki 2. sutunu bir liste olarak yazdirin
        List<String> ikinciSutun=new ArrayList<>();
        String path = "src/test/java/resources/ulkeler.xlsx";

        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        for (int i = 0; i <= workbook.getSheet("Sayfa1").getLastRowNum() ; i++) {
            ikinciSutun.add(workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString());
        }

        System.out.println(ikinciSutun);



        //A ile baslayan sehirleri liste yapip yazdirin
        List<String> aIleBaslayansehirler = new ArrayList<>();
        for (String each:ikinciSutun) {
            if (each.startsWith("A")){
                aIleBaslayansehirler.add(each);
            }
        }
        System.out.println(aIleBaslayansehirler);

// eger tum datayi java'da kullanilabilir bir collection'a cevirmek istersek
// en uygun yapi map olur
// map icin unique degerlere sahip bir sutunu key
// geriye kalan tum sutunlari ise virgulle ayrilan String'ler olarak value yapmaliyiz
        // key=Turkey  value=Ankara, Turkiye, Ankara

        Map<String,String> ülkelerMap= new HashMap<>();
        String key="";
        String value="";
        for (int i = 0; i <= workbook.getSheet("Sayfa1").getLastRowNum() ; i++) {
            key=workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            value=workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()+", "+
                  workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()+", "+
                  workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();

            ülkelerMap.put(key,value);
        }

        System.out.println(ülkelerMap);

        // Biz java methodlarini ve collections'i kullanarak excel'deki datalari
        // manipule edebilecegimiz java ortamina alabiliriz

    }


}
