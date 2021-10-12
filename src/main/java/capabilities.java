import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class capabilities {

    public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {
        // Appium server and port (4723)
        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        // Setting apk path and name
        File appDir = new File("src/main/resources");
        File app = new File(appDir,"APIDemos-debug.apk");

        // Setting Capabilities to Appium
        DesiredCapabilities desCap = new DesiredCapabilities();
        // Setting Device
        desCap.setCapability(MobileCapabilityType.DEVICE_NAME, "PIXEL 4 API 30");
        // Setting App
        desCap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        // UIAutomator2 for Android
        desCap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

        //Android Driver
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(url, desCap);

        // Setting timeout
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);

        return driver;
    }
}
