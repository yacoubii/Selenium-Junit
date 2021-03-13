import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

public class Demo {
    public static void main(String args []){
        String chromeDriverPath = "C:\\chromedriver.exe" ;
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver",chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu", "--window-size=1920,1200","--ignore- certificate-errors");
        WebDriver driver;
        driver = new ChromeDriver(options);
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

        driver.quit();

    }
}
