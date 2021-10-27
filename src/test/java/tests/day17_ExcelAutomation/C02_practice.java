package tests.day17_ExcelAutomation;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C02_practice {

    //Yeni bir test method olusturalim readExcel2()

    @Test
    public void test() throws IOException {

        String path="src/test/java/resources/ulkeler.xlsx";

        FileInputStream fileInputStream = new FileInputStream(path);

        Workbook workbook= WorkbookFactory.create(fileInputStream);

        //- 1.satirdaki 2.hucreye gidelim ve yazdiralim
        //- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String row1Cell2=workbook.getSheet("Sayfa1").getRow(0).getCell(1).getStringCellValue();
        System.out.println(row1Cell2);

        //- 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        String row2Cell4 =workbook.getSheet("Sayfa1").getRow(1).getCell(3).getStringCellValue();
        String kabil="Kabil";

        Assert.assertEquals(row2Cell4,kabil,"baskent hatali");

        //- Satir sayisini bulalim
        System.out.println("Sayfa1'in satir sayisi: "+workbook.getSheet("Sayfa1").getLastRowNum());

        //- Fiziki olarak kullanilan satir sayisini bulun
        System.out.println("Fiziki olarak kullanilan satir sayisi: "+workbook.getSheet("Sayfa1").getPhysicalNumberOfRows());

        //- Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedeli
        Map<String,String> map=new HashMap<>();
        String key="";
        String value="";

        for (int i = 0; i <=workbook.getSheet("Sayfa1").getLastRowNum() ; i++) {
            key=workbook.getSheet("Sayfa1").getRow(i).getCell(0).getStringCellValue();
            value=workbook.getSheet("Sayfa1").getRow(i).getCell(1).getStringCellValue();

            map.put(key,value);
        }

        System.out.println(map);

    }
}
