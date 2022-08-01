package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
public class GoogleSearchResults {
    WebDriver driver;
    public GoogleSearchResults(WebDriver driver) {
        this.driver = driver;
    }
    By nextPageBtn = By.xpath("//a[@id='pnnext']//span[@class='SJajHc NVbCr']");
    By allResults = By.xpath("//div[@class='GyAeWb']");
    public void pageNumber(){

        int pageNumber = 1;
        String engine = "the engine";
        String horsepower = "horsepower";
        boolean stopper = true;

        while(stopper){

            String allResultsText = driver.findElement(allResults).getText();

            if(allResultsText.contains(engine) | allResultsText.contains(horsepower)) {
                stopper = false;
                System.out.println("The result you are looking for is at page number "+pageNumber);
            }
            else {
                pageNumber+=1;
                if(driver.findElements(nextPageBtn).size() == 0) {
                    System.out.println("The result you are looking for does not exist");
                    stopper = false;
                    Assert.assertTrue(stopper);
                } else driver.findElement(nextPageBtn).click();
            }
        }
    }
}