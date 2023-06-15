import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity5 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/input-events");
        System.out.println("Home page title: " + driver.getTitle());
        Actions builder = new Actions(driver);
        builder.click().pause(1000).build().perform();
        System.out.println(driver.findElement(By.className("active")).getText());
        builder.doubleClick().pause(1000).build().perform();
        System.out.println(driver.findElement(By.className("active")).getText());
        builder.contextClick().pause(1000).build().perform();
        System.out.println(driver.findElement(By.className("active")).getText());
        driver.close();
    }
}
