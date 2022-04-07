import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Intro {


    @Test
    public void test1() throws MalformedURLException {

        File apkFile = new File("src/test/resources/ApiDemos-debug-newVersion.apk");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "techtorial");
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("app", apkFile.getAbsolutePath());

        URL serverUrl = new URL("http://localhost:4723/wd/hub");

        AndroidDriver<AndroidElement> driver =
                new AndroidDriver<AndroidElement>(serverUrl, desiredCapabilities);

        AndroidElement appButton = driver.findElement(By.xpath("//android.widget.TextView[@text='App']"));
        appButton.click();
    }


    @Test
    public void test2() throws MalformedURLException {

        File apkFile = new File("src/test/resources/ApiDemos-debug-newVersion.apk");
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "android");
        dc.setCapability("deviceName", "techtorial");
        dc.setCapability("app", apkFile.getAbsolutePath());

        URL appiumServerUrl = new URL("http://localhost:4723/wd/hub");

        AndroidDriver<AndroidElement> driver =
                new AndroidDriver<AndroidElement>(appiumServerUrl, dc);

        List<AndroidElement> listOfElements = driver.findElements(By.id("android:id/text1"));
        for (AndroidElement element : listOfElements) {
            System.out.println(element.getText());
        }


        AndroidElement mediaButton = driver.findElementByAccessibilityId("Media");
        mediaButton.click();




    }


}
