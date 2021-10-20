package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    //1- Properties objesi olusturmaliyiz

    static Properties properties;



    //2- Bu class'in amaci configuration.properties dosyasini okumak ve oradaki
    //   key-value ikililerini kullanarak istedigimiz key'e ait value'yu bize getirmek

    static {
        String path="configuration.properties";
        try {
            FileInputStream fileInputStream=new FileInputStream(path);
            properties=new Properties();
            properties.load(fileInputStream);

        } catch (FileNotFoundException e) { // ioException parent oldugu icin bu catc istenirse silinebilir
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    //3- Test class'larindan configReader class'ina ulasip yukaridaki islemleri
    //   yapmamizi saglayacak bir method olusturacagiz

    public static String getProperty(String key){

        String value=properties.getProperty(key);
        return value;
    }

}
