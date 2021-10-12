import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class uiAutomatorTest extends capabilities {

    public static void main(String[] args) throws MalformedURLException {

        AndroidDriver<AndroidElement> driver = capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);

        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();

        // Count clickable element
        int count = driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size();
        System.out.println(count);
    }
}
