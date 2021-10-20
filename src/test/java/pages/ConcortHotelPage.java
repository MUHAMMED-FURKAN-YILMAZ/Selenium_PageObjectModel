package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConcortHotelPage {

    WebDriver driver;

    public ConcortHotelPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
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


}
