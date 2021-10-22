package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class QAConcortPage {

    WebDriver driver;

    public QAConcortPage (){

        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(linkText = "Log in")
    public WebElement firstlogInLink;

    @FindBy (id ="UserName")
    public WebElement userNameBox;

    @FindBy(id = "Password")
    public WebElement passwordBox;

    @FindBy(id = "btnSubmit")
    public  WebElement logInButton;

    @FindBy (xpath = "//span[text()='ListOfUsers']")
    public WebElement isLoginPass;

    @FindBy (xpath = "//*[.='Try again please']")
    public WebElement isLoginFailed;

    @FindBy(xpath = "//span[text()='Hotel Management']")
    public WebElement hotelManagementLİnk;

    @FindBy(partialLinkText = "Hotel List")
    public WebElement hotelListLink;

    @FindBy(xpath = "//span[text()='Add Hotel ']")
    public WebElement addHotelLinkButton;

    @FindBy(id = "Code")
    public WebElement addHotelCodeBox;

    @FindBy(id="IDGroup")
    public WebElement addHotelDropdown;

    @FindBy(id="btnSubmit")
    public WebElement addHotelSave;

    @FindBy(xpath="//div[@class='bootbox-body']")
    public WebElement addHotelSuccesfullText;

    @FindBy(xpath="//button[@class='btn btn-primary']")
    public WebElement addHotelAllertOk;

    @FindBy(partialLinkText = "Hotel Rooms")
    public WebElement hotelRoomsLink;

    @FindBy(xpath = "//span[text()='Add Hotelroom ']")
    public WebElement addHotelRoomButton;

    @FindBy(id="IDHotel")
    public WebElement addRoomIdDropDown;

    @FindBy(id = "IDGroupRoomType")
    public WebElement addRoomTypeDropDown;

    @FindBy(id = "btnSubmit")
    public  WebElement addRoomSaveButton;

    @FindBy(xpath="//div[@class='bootbox-body']")
    public WebElement addRoomSuccessfulText;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement addRoomAlertOkButton;

    @FindBy(linkText="Hotelrooms")
    public WebElement addRoomHotelRoomsLink;

    @FindBy(xpath = "//span[text()='List Of Hotelrooms']")
    public WebElement addRoomHotelRoomListText;

    @FindBy(xpath = "//thead/tr[1]/th")
    public List<WebElement> basliklarListesi;

    @FindBy(xpath = "//tbody")
    public WebElement tBodyTumu;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> satirlarListesi;

    @FindBy(xpath = "//tbody//tr[1]")
    public WebElement birinciSatir;

    @FindBy(xpath = "//tbody//tr//td[4]")
    public List<WebElement> dordoncuSutunListesi;

    @FindBy(xpath="//table//tr[4]")
    public WebElement dorduncuSatir;

    @FindBy(xpath = "//tbody//tr//td")
    public List<WebElement> tablodakiTumTdList;

    @FindBy(xpath = "//table//th")
    public List<WebElement> tablodakiTumThList;

    @FindBy(xpath = "//tbody//tr/td[5]")
    public List<WebElement> besinciSutunListesi;


    public void concortHotelLogin(){
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.firstlogInLink.click();
        qaConcortPage.userNameBox.sendKeys(ConfigReader.getProperty("CHQAValidUsername"));
        qaConcortPage.passwordBox.sendKeys(ConfigReader.getProperty("CHQAValidPassword"));
        qaConcortPage.logInButton.click();
    }

    public String printData(int satir, int sutun) {
    // ornekteki haliyle 3. satir, 5. sutundaki elemani yazdiralim
    // String xpath= //tbody//tr[3]//td[5]
    String xpath= "//tbody//tr["+satir+"]//td["+sutun+"]";

    //@FindBy notasyonu parametreli calismadigi icin onceki yontemle locate edelim
        String istenenData = Driver.getDriver().findElement(By.xpath(xpath)).getText();
        System.out.println("Satir no: "+satir+", sutun no: "+sutun+"'deki data: "+istenenData);

        return istenenData;
    }

}
