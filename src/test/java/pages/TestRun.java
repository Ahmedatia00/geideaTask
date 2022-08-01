package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class TestRun {
    WebDriver driver;

    @BeforeTest
    public void beforetest(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        //Adding implicit wait to prevent timing out as a result of not finding an element instantly and to increase efficiency
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Maximizing window for a better view
        driver.manage().window().maximize();
    }

    @Test
    public void returnPageNumber() {
        GoogleHome page = new GoogleHome(driver);
        page.search("Mercedes A Class");

        GoogleSearchResults page2 = new GoogleSearchResults(driver);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Scroll down till the bottom of the page
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        page2.pageNumber();
    }


    @AfterTest
    public void aftertest() throws InterruptedException{
        driver.quit();
    }
}
