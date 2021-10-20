package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DhtmlGoodiesPage {

    WebDriver driver;

    public DhtmlGoodiesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy (id = "box1")
    public WebElement osloDrag;

    @FindBy (id = "box2")
    public WebElement stockholmDrag;

    @FindBy (id = "box3")
    public WebElement washingtonDrag;

    @FindBy (id = "box4")
    public WebElement copenhagenDrag;

    @FindBy (id = "box5")
    public WebElement seoulDrag;

    @FindBy (id = "box6")
    public WebElement romeDrag;

    @FindBy (id = "box7")
    public WebElement madridDrag;



    @FindBy (id = "box101")
    public WebElement norwayBox;

    @FindBy (id = "box102")
    public WebElement swedenBox;

    @FindBy (id = "box103")
    public WebElement unitedStatesBox;

    @FindBy (id = "box104")
    public WebElement denmarkBox;

    @FindBy (id = "box105")
    public WebElement southKoreaBox;

    @FindBy (id = "box106")
    public WebElement italyBox;

    @FindBy (id = "box107")
    public WebElement spainBox;


}
