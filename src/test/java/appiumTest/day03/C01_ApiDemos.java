package appiumTest.day03;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class C01_ApiDemos {

    //1. Apidemos'u açıyoruz
    //2. Views'a tıklıyoruz
    //3. Expandable Lists'e tıklıyoruz
    //4. Custom Adapter'a tıklıyoruz
    //5. People Names'e tıklayıp isimleri alıyoruz
    @Test
    public void ApiDemosTest() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel3");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\user\\IdeaProjects\\selenium-projects\\com.GuiderSoftAppium\\src\\app\\apidemos.apk");
        AndroidDriver<AndroidElement> driver=new AndroidDriver<>(new URL("http:127.0.0.1:4723/wd/hub"),desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@text=\"Views\"]")).click();
        //driver.findElementByAccessibilityId("Views"); bu sekildede locate edilebilir

        driver.findElement(By.xpath("//*[@text=\"Expandable Lists\"]")).click();
        driver.findElement(By.xpath("//*[@text=\"1. Custom Adapter\"]")).click();
        driver.findElement(By.xpath("//*[@text=\"People Names\"]")).click();

        List<AndroidElement> list=driver.findElements(By.className("android.widget.TextView"));

        for (int i = 2; i <6 ; i++) {
            System.out.println("list.get(i).getText() = " + list.get(i).getText());
        }


    }
}
