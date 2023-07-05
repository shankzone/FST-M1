package appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {

    WebDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options opts = new UiAutomator2Options();
        opts.setPlatformName("android");
        opts.setAutomationName("UiAutomator2");
        opts.setAppPackage("com.google.android.calculator");
        opts.setAppActivity("com.android.calculator2.Calculator");
        opts.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, opts);
    }

    @Test
    public void activity(){
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_2")).click();
        driver.findElement(AppiumBy.accessibilityId("multiply")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_6")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        String res = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final")).getText();

        Assert.assertEquals(res,"12");
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
