import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Gestures {
    AndroidDriver<AndroidElement> driver;

    @Before
    public void setup() throws MalformedURLException {
        File apkFile = new File("src/test/resources/ApiDemos-debug-newVersion.apk");
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "android");
        dc.setCapability("deviceName", "techtorial");
        dc.setCapability("app", apkFile.getAbsolutePath());

        URL appiumServerUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver<AndroidElement>(appiumServerUrl, dc);
    }


    @Test
    public void tapTest() {

        AndroidElement animationButton = driver.findElementByAccessibilityId("Animation");

        TouchAction touchAction = new TouchAction(driver);

        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(animationButton))).perform();

    }


}
