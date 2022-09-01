package appiumTest.day02;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class C01_AppiumTest {
//adb shell getprop ro.build.version.release => version bulmak için
// emulator -list-avds => cihaz ismini de bu kod sayesinde buluruz.


    @Test
    public void test01() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel3");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\user\\IdeaProjects\\selenium-projects\\com.GuiderSoftAppium\\src\\app\\Duolingo language lessons_v5.70.4_apkpure.com.apk");
        AndroidDriver<AndroidElement> driver=new AndroidDriver<>(new URL("http:127.0.0.1:4723/wd/hub"),desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement getStarted=driver.findElement(By.id("com.duolingo:id/introFlowNewUserButton"));

        String getStartedText=getStarted.getText();
        System.out.println("getStartedText = " + getStartedText);
        getStarted.click();

        WebElement continuee = driver.findElement(By.id("com.duolingo:id/continueButton"));
         continuee.click();
        WebElement element = driver.findElement(By.xpath("//*[@text=\"CONTINUE\"]"));
        element.click();

        TouchAction touchAction=new TouchAction(driver);
        Thread.sleep(5000);


       /* touchAction.longPress(PointOption.point(607, 1767))
                .moveTo(PointOption.point(666, 778))
                .release()
                .perform();*/

        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"German\").instance(0))").click();



        driver.findElement(By.xpath("//*[@text=\"German\"]")).click();
        driver.findElement(By.id("com.duolingo:id/continueButton")).click();


        driver.findElement(By.xpath("//*[@text=\"App store\"]")).click();
        driver.findElement(By.id("com.duolingo:id/continueButton")).click();


        driver.findElement(By.xpath("//*[@text=\"I’m new to German\"]")).click();
        driver.findElement(By.id("com.duolingo:id/continueButton")).click();

        driver.findElement(By.xpath("//*[@text=\"Spend time productively\"]")).click();
        driver.findElement(By.id("com.duolingo:id/continueButton")).click();
        driver.findElement(By.id("com.duolingo:id/continueButton")).click();


        driver.findElement(By.id("com.duolingo:id/xpGoalOptionRegular")).click();
        driver.findElement(By.id("com.duolingo:id/continueButton")).click();

        driver.findElement(By.id("com.duolingo:id/startBasicsButton")).click();
        driver.findElement(By.id("com.duolingo:id/continueButton")).click();


        WebElement option1=driver.findElement(By.xpath("//*[@text=\"tea\"]"));

      String expText="tea";
      String actText=option1.getText();

        Assert.assertEquals(expText,actText);


    }

}
