package com.maveric.assi.Assign;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Demo1 {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("deviceName","deepali");
		cap.setCapability("app", "D:\\apps\\khan-academy-7-3-2.apk");
	//	cap.setCapability("udid", "");
		
		AndroidDriver driver=new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Search tab\"]")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Search\"]")).sendKeys("Indian history");
		driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.widget.Button/android.view.ViewGroup[2]/android.widget.TextView[1]")).click();
		
		
	/*	Map<String, Object> map = new HashMap<String, Object>();
		map.put("strategy", "-android uiautomator");
		map.put("selector", "UiSelector().textContains(\"Art of Asia\").index(0)");

		driver.executeScript("mobile: scroll", map);
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().textContains(\"Art of Asia\").index(0)")).click();

		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("strategy", "-android uiautomator");
		map1.put("selector", "UiSelector().textContains(\"South As\")");

		driver.executeScript("mobile: scroll", map1);
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().textContains(\"South Asia\")")).click();

       */ 


	}

}
