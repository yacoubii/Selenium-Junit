import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page {
    private final WebDriver webDriver;
    @FindBy(id = "cookie_tout_accepter_1")
    private WebElement cookie;
    @FindBy(id = "sept")
    private WebElement sept;
    @FindBy(id = "addition")
    private WebElement addition;
    @FindBy(id = "huit")
    private WebElement huit;
    @FindBy(id = "egale")
    private WebElement egale;
    @FindBy(id = "total")
    private WebElement total;

    public Page(WebDriver webDriver) {
        this.webDriver=webDriver;
        PageFactory.initElements(webDriver,this);
    }
    public String performCalculation(){
        cookie.click();
        sept.click();
        addition.click();
        huit.click();
        egale.click();
        return total.getText();
    }

}
