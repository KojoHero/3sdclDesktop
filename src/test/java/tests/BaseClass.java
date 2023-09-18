package tests;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;

public class BaseClass {
    static WindowsDriver<WindowsElement> driver;

    @BeforeTest
    public void setup() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability("app", "\"C:\\Program Files (x86)\\3 Steps Dare Co. Ltd\\E-ADAPP QA Demo\\EADAPPDemo.exe\"");
            capabilities.setCapability("deviceName", "WindowsPC");
            capabilities.setCapability("platformName", "Windows");

            driver = new WindowsDriver<>(new URL("http://127.0.0.1:4723/wd/hub/"), capabilities);
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }

    @AfterSuite
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
