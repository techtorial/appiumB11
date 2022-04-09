package step_defs;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.CustomAdapterPage;
import pages.ExpandableListPage;
import pages.HomePage;
import pages.ViewsPage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ApiDemosStepDefs {

    AndroidDriver<AndroidElement> driver;

    @Given("I have APIDemos application launched")
    public void i_have_api_demos_application_launched() throws MalformedURLException {
        File apkFile = new File("src/test/resources/ApiDemos-debug-newVersion.apk");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "techtorial");
        desiredCapabilities.setPlatform(Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.APP, apkFile.getAbsolutePath());

        URL serverUrl = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<AndroidElement>(serverUrl, desiredCapabilities);
    }

    @When("I navigate to {string} page")
    public void i_navigate_to_views_expandable_list_custom_adapter_page(String path) {

        HomePage homePage = new HomePage(driver);
        homePage.viewsButton.click();

        ViewsPage viewsPage = new ViewsPage(driver);
        viewsPage.expandableList.click();

        ExpandableListPage expandableListPage = new ExpandableListPage(driver);
        expandableListPage.customAdapter.click();


    }

    @When("I long press on Dog Names button for {int} seconds")
    public void i_long_press_on_dog_names_button_for_seconds(Integer int1) {
        TouchAction touchAction = new TouchAction(driver);
        CustomAdapterPage customAdapterPage = new CustomAdapterPage(driver);
        touchAction.longPress(LongPressOptions.longPressOptions().withDuration(Duration.ofSeconds(2))
                .withElement(ElementOption.element(customAdapterPage.dogNamesButton))).perform();

    }

    @Then("new menu with {string} option should pop up")
    public void new_menu_with_option_should_pop_up(String expectedText) {
        CustomAdapterPage customAdapterPage = new CustomAdapterPage(driver);
        String actualText = customAdapterPage.sampleMenu.getText();

        Assert.assertEquals(expectedText, actualText);

    }


}
