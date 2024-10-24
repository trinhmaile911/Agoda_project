package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BasePage {
    public static WebDriver driver;
    private String url;
    private Properties prop;
    public BasePage() throws IOException {
        prop = new Properties();
        FileInputStream data = new FileInputStream("/Users/trinhle/Desktop/BanVien/Project/Agoda_project/src/main/java/resources/config.properties");
        prop.load(data);
    }
    public WebDriver getDriver(){
        if (prop.getProperty("browser").equals("chrome")){
            ChromeOptions disableNotificationOptions = new ChromeOptions().addArguments("--disable-notifications");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(disableNotificationOptions);
        } else if (prop.getProperty("browser").equals("firefox")){
            driver = new FirefoxDriver();
        } else if (prop.getProperty("browser").equals("ie")){
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        return driver;
    }
    public String getUrl(){
        url = prop.getProperty("url");
        return url;
    }
}
