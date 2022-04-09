package pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;

public class HomePage {


    AndroidDriver<AndroidElement> driver;

    public HomePage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='App']")
    AndroidElement appButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Views']")
    public AndroidElement viewsButton;


    public void appButtonTap(){
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(TapOptions
                .tapOptions()
                .withElement(ElementOption.element(appButton)))
                .perform();
    }

}
