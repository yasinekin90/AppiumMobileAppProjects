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
import java.util.concurrent.TimeUnit;

public class C02_HesapMakinesi {

    //adb shell  settings get secure android_id: CMD ye yazınca cihazın kimligini bulmaya yarar

    //8 ile 7 yi çarpıp sonucunu konsola yazdıralım
    @Test
    public void calcTest() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"7.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        desiredCapabilities.setCapability("appPackage","com.android.calculator2");
        desiredCapabilities.setCapability("appActivity","com.android.calculator2.Calculator");
        AndroidDriver<AndroidElement> driver=new AndroidDriver<>(new URL("http:127.0.0.1:4723/wd/hub"),desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@text=\"8\"]")).click();
        driver.findElement(By.xpath("//*[@text=\"7\"]")).click();

        driver.findElement(By.xpath("//*[@text=\"×\"]")).click();

        driver.findElement(By.xpath("//*[@text=\"3\"]")).click();
        driver.findElement(By.xpath("//*[@text=\"2\"]")).click();


        driver.findElement(By.xpath("//*[@text=\"=\"]")).click();

        WebElement result=driver.findElement(By.id("com.android.calculator2:id/result"));

        System.out.println("result.getText() = " + result.getText());


    }
}
