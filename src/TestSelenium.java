import com.google.common.io.Files;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

public class TestSelenium {
    private  WebDriver driver;
    @Before
    public void init(){
        String chromeDriverPath = "C:\\chromedriver.exe" ;
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver",chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu", "--window-size=1920,1200","--ignore- certificate-errors","--headless");
        driver = new ChromeDriver(options);
    }

    @Test
    public void demo(){
        driver.get("https://google.com");
        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.sendKeys("test");
        searchBar.sendKeys(Keys.ENTER);

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(screenshot,new File("test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   /* @Test
    public void calculatrice(){
        driver.get("https://www.ma-calculatrice.fr");
        driver.findElement(By.id("cookie_tout_accepter_1")).click();
        driver.findElement(By.id("sept")).click();
        driver.findElement(By.id("addition")).click();
        driver.findElement(By.id("huit")).click();
        driver.findElement(By.id("egale")).click();
        String total = driver.findElement(By.id("total")).getText();
        Assert.assertEquals(total,"15");
    }*/

    @Test
    public void calculatrice(){
        driver.get("https://www.ma-calculatrice.fr");
        Page p = new Page(driver);
        Assert.assertEquals(p.performCalculation(),"15");
    }

    @After
    public void quit(){
        if (driver!=null){
            driver.quit();
        }

    }
}
