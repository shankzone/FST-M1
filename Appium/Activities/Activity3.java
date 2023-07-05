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

public class Activity3 {

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
    public void add(){
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("plus")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_9")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        String addRes = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final")).getText();
        System.out.println(addRes);
        Assert.assertEquals(addRes,"14");

    }

    @Test
    public void subtract(){
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_1")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_0")).click();
        driver.findElement(AppiumBy.accessibilityId("minus")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        String subRes = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final")).getText();
        System.out.println(subRes);
        Assert.assertEquals(subRes,"5");
    }

    @Test
    public void multiply(){
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_1")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_0")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_0")).click();
        driver.findElement(AppiumBy.accessibilityId("multiply")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        String mulRes = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final")).getText();
        System.out.println(mulRes);
        Assert.assertEquals(mulRes,"500");
    }

    @Test
    public void divide(){
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_5")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_0")).click();
        driver.findElement(AppiumBy.accessibilityId("divide")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_2")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        String divRes = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final")).getText();
        System.out.println(divRes);
        Assert.assertEquals(divRes,"25");
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
