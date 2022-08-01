package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class GoogleHome {
    WebDriver driver;
    public GoogleHome(WebDriver driver) {
        this.driver = driver;
    }
    By searchBox = By.xpath("//input[@name='q']");
    By searchBtn = By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@name='btnK' and @class='gNO89b']");
    By googleLogo = By.xpath("//img[@class='lnXdpd']");

    public void search(String searchWord) {

        driver.findElement(searchBox).sendKeys(searchWord);
        driver.findElement(googleLogo).click();
        driver.findElement(searchBtn).click();
    }
}