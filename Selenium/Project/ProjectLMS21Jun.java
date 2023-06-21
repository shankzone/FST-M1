import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProjectLMS21Jun {

    WebDriver driver;
    String username = "root";
    String password = "pa$$w0rd";

    @BeforeClass
    public void beforeMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void getTitle() {
        String title = driver.getTitle();

        //Print the title of the page
        System.out.println("Page title is: " + title);
        Assert.assertEquals(title, "Alchemy LMS – An LMS Application");

    }

    @Test
    public void getHeading() {
        String heading = driver.findElement(By.className("uagb-ifb-title")).getText();

        //Print the title of the page
        System.out.println("Page Heading is: " + heading);
        Assert.assertEquals(heading, "Learn from Industry Experts");
    }

    @Test
    public void firstInfoBox() {
        String text = driver.findElement(By.xpath("//h3[text()=' Actionable Training ']")).getText();
        System.out.println("Page text in first info box is: " + text);
        Assert.assertEquals(text, "Actionable Training");
    }

    @Test
    public void secondMostPopularCourse() {
        String text1 = driver.findElement(By.xpath("//h3[text()='Email Marketing Strategies']")).getText();
        System.out.println("Page text in first info box is: " + text1);
        Assert.assertEquals(text1, "Email Marketing Strategies");

    }

    @Test
    public void navigateToAnotherPage() {
        driver.findElement(By.xpath("//*[text()='My Account']")).click();
        String myAcctTitle = driver.getTitle();
        System.out.println("My Account Page title is: " + myAcctTitle);
        String myAcct = driver.findElement(By.xpath("//h1[text()='  My Account    ']")).getText();
        System.out.println("My Account Page heading is: " + myAcct);
        Assert.assertEquals(myAcct, "My Account");

    }

    @Test
    public void login() {
        navigateToAnotherPage();
        driver.findElement(By.xpath("//*[contains(@class,'ld-login ld-login ld-login-text ld-login-button ld-button')]")).click();
        driver.findElement(By.id("user_login")).sendKeys(username);
        driver.findElement(By.id("user_pass")).sendKeys(password);
        driver.findElement(By.id("wp-submit")).click();
        String loggedInPageTitle = driver.getTitle();
        System.out.println("Logged in page title is: " + loggedInPageTitle);
        String user = driver.findElement(By.xpath("/html/body/div[2]/div/ul[2]/li[2]/a/span")).getText();
        System.out.println("Logged in user is: " + user);
        Assert.assertEquals(user, "root");
    }

    @Test
    public void countNoOfCourses() {
        driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div/div/div[3]/div/nav/div/ul/li[2]/a")).click();
        String titleAllCourses = driver.getTitle();
        System.out.println("All courses page title is: " + titleAllCourses);
        Assert.assertEquals(driver.getTitle(), "All Courses – Alchemy LMS");
        int mycount = driver.findElements(By.xpath("//div[contains(@class, 'ld_course_grid col-sm-8 col-md-4')]")).size();
        System.out.println("Count of the course is : " + mycount);
    }

    @Test
    public void contactAdmin() {
        driver.findElement(By.xpath("//*[contains(@href,'https://alchemy.hguy.co/lms/contact/')]")).click();
        System.out.println("you have reach contact-us page");
        driver.findElement(By.id("wpforms-8-field_0")).sendKeys("Shashank Shanker");
        driver.findElement(By.id("wpforms-8-field_1")).sendKeys("shashank.shanker@ibm.com");
        driver.findElement(By.id("wpforms-8-field_3")).sendKeys("Help Required with courses...");
        driver.findElement(By.id("wpforms-8-field_2")).sendKeys("How are you doing today");
        driver.findElement(By.id("wpforms-submit-8")).click();
        System.out.println("you have successfully submitted query");
        String message = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/article/div/section[4]/div[2]/div[2]/div[2]/div[2]/p")).getText();
        System.out.println("After submission, this message has been displayed:" + message);
    }

    @Test
    public void completeSimpleLesson() {
        login();
        countNoOfCourses();
        driver.findElement(By.xpath("//*[contains(@href,'https://alchemy.hguy.co/lms/courses/social-media-marketing/')]")).click();
        
    }


    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
