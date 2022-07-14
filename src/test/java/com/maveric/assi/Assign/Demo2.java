package com.maveric.assi.Assign;

public class Demo2 {

	import java.io.File;
	import java.net.MalformedURLException;
	import java.net.URL;
	import java.time.Duration;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;

	import org.openqa.selenium.Dimension;
	import org.openqa.selenium.Point;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.interactions.Pause;
	import org.openqa.selenium.interactions.PointerInput;
	import org.openqa.selenium.remote.DesiredCapabilities;

	import io.appium.java_client.AppiumBy;
	import io.appium.java_client.TouchAction;
	import io.appium.java_client.android.AndroidDriver;
	import io.appium.java_client.service.local.AppiumDriverLocalService;
	import io.appium.java_client.service.local.AppiumServiceBuilder;
	import io.appium.java_client.service.local.flags.GeneralServerFlag;
	import io.appium.java_client.touch.WaitOptions;
	import io.appium.java_client.touch.offset.PointOption;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
			
			AppiumServiceBuilder builder=new AppiumServiceBuilder()
	                .usingAnyFreePort()
	                .withLogFile(new File("appium_log.log"))
	                .withArgument(GeneralServerFlag.RELAXED_SECURITY)
	                .withArgument(GeneralServerFlag.BASEPATH,"/wd/hub");
	        
	        
	        AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
	        
	        service.start();
	        
	        System.out.println("-----------------------------------");
	        System.out.println(service.getUrl());
	        System.out.println(service.isRunning());
	        System.out.println("-----------------------------------");
	        //declare desired cap
	        //connect khan academy app 
	        //can do automation
	        
			DesiredCapabilities cap=new DesiredCapabilities();
	        cap.setCapability("platformName", "android");
	        cap.setCapability("deviceName", "bikram");  
	        //installing khan_academy app in to mobile device
	       // cap.setCapability("app","D:\\appium app\\khan-academy-7-3-2.apk" );
	        //pointing to specific device to run the script
	        cap.setCapability("udid","emulator-5554");
	        
	        //opening the existing app
	        cap.setCapability("appPackage", "org.khanacademy.android");
	        cap.setCapability("appActivity", "org.khanacademy.android.ui.library.MainActivity");
	        cap.setCapability("noReset", true);
	        //for initiating appium server mannual with port number 4723 using appium server tool
	       // AndroidDriver driver=new AndroidDriver(new URL("http://localhost:4723/wd/hub"),cap);
	        
	        //for starting appium server with random port automatically
	        AndroidDriver driver=new AndroidDriver(service,cap);
	        
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	         try
	         {
	        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).click();
	         }
	         catch (Exception e)
	         {
	        	 
	         }
	         
	       /*  if(driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).size()>0)
	         {
	        	 driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).click();
	         }                                   
	     */
	          //locating a element using androidUIAutomator      
	         driver.findElement(AppiumBy.androidUIAutomator("UiSelector().text(\"Sign in\")")).click();
	        
	         driver.findElement(AppiumBy.androidUIAutomator("UiSelector().text(\"Sign in\")")).click();
	         driver.findElement(AppiumBy.androidUIAutomator("UiSelector().text(\"Enter an e-mail address or username\")")).sendKeys("wefhewfdheoidj@gmail.com");
	         driver.findElement(AppiumBy.androidUIAutomator("UiSelector().text(\"Password\")")).sendKeys("qwerty123");
	         driver.findElement(AppiumBy.androidUIAutomator("UiSelector().text(\"Sign in\").index(0)")).click();
	         String error = driver.findElement(AppiumBy.androidUIAutomator("UiSelector().text(\"There was an issue signing in\").index(0)")).getText();
	         System.out.println(error);
	         
	         driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Back\"]/android.widget.ImageView")).click();
	         
	         driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Sign up with email\"]/android.view.ViewGroup/android.widget.TextView")).click();
	         driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"First name\"]")).sendKeys("Bikram Keshari");
	         driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Last name\"]")).sendKeys("Jena");
	         driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Birthday\"]/android.widget.TextView")).click();
	         
	         driver.findElement(AppiumBy.xpath("(//*[@resource-id ='android:id/numberpicker_input'])[1] ")).click();
	         driver.findElement(AppiumBy.xpath("(//*[@resource-id ='android:id/numberpicker_input']) [1]")).clear();
	         driver.findElement(AppiumBy.xpath("(//*[@resource-id ='android:id/numberpicker_input'])[1] ")).sendKeys("Jan");
	         
	         driver.findElement(AppiumBy.xpath("(//*[@resource-id ='android:id/numberpicker_input'])[2] ")).click();
	         driver.findElement(AppiumBy.xpath("(//*[@resource-id ='android:id/numberpicker_input']) [2]")).clear();
	         driver.findElement(AppiumBy.xpath("(//*[@resource-id ='android:id/numberpicker_input'])[2] ")).sendKeys("24");
	         
	         driver.findElement(AppiumBy.xpath("(//*[@resource-id ='android:id/numberpicker_input'])[3] ")).click();
	         driver.findElement(AppiumBy.xpath("(//*[@resource-id ='android:id/numberpicker_input']) [3]")).clear();
	         driver.findElement(AppiumBy.xpath("(//*[@resource-id ='android:id/numberpicker_input'])[3] ")).sendKeys("1995");
	         
	       /*  List<WebElement> elements= driver.findElements(AppiumBy.xpath("(//*[@resource-id ='android:id/numberpicker_input']"));
	         String text1=- elements.get(0).getText();
	         System.out.println(text1);
	         
	         if(text1.length()==3)
	        {
	                 elements.get(0).click();
	                elements.get(0).clear();
	                elements.get(0).sendKeys("Jan");
	         }
	         else
	         {
	        	     elements.get(1).click();
	                 elements.get(1).clear();
	                 elements.get(1).sendKeys("24");
	         }
	         
	         if(text1.length()==2)
	         {
	        	     elements.get(0).click();
	                 elements.get(0).clear();
	                 elements.get(0).sendKeys("24");
	         }
	         else
	         {
	        	     elements.get(1).click();
	                elements.get(1).clear();
	                elements.get(1).sendKeys("Jan");
	         }
	    
	         
	         elements.get(2).click();
	         elements.get(2).clear();
	         elements.get(2).sendKeys("1995"); */
	       
	         driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='OK']")).click();
	         driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Email address\"]")).sendKeys("bikramkj15@gmail.com");
	         driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Password\"]")).sendKeys("qwerty123");
	         driver.findElement(AppiumBy.xpath("(//android.widget.ImageView[@index='0'])[2]")).click();
	         driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='CREATE']")).click(); 
	        
	         driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Settings\"]")).click();
	         driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Sign out']")).click();
	         driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='SIGN OUT']")).click();
	         driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Sign in']")).click();
	         driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Sign in']")).click();
	         driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Enter an e-mail address or username\"]")).sendKeys("bikramkj15@gmail.com");
	         driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Password\"]")).sendKeys("qwerty123");
	         driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Sign in\"]/android.widget.TextView")).click();
	         
	       //  driver.findElement(AppiumBy.id("org.khanacademy.android:id/tab_bar_button_search")).click();
	         
	         driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Search']")).click();
	         driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Arts and humanities']")).click();
	         
	       //scroll to a element and click using UiScrollable
	         String visibleText = "Art of Asia";        
	         driver.findElement(AppiumBy.androidUIAutomator
	         ("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"" + visibleText + "\").instance(0))")).click();
	         
	        /* Map<String,Object> map=new HashMap<String,Object>();
	         map.put("strategy", "-android uiautomator");
	         map.put("selector", "UiSelector().text(\"Art of Asia\")");
	         
	         driver.executeScript("mobile: scroll", map);
	         
	         driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Art of Asia']")).click();
	         */
	         
	       //scroll to a element and click using mobile command 
	         Map<String,Object> map1=new HashMap<String,Object>();
	         map1.put("strategy", "-android uiautomator");
	         map1.put("selector", "UiSelector().text(\"South Asia\")");
	                       
	         driver.executeScript("mobile: scroll", map1);
	         driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='South Asia']")).click();
	         
	         Thread.sleep(5000);
	         
	         //scroll using actions (1)old
	          
	         TouchAction action = (new TouchAction(driver));
	     
	         action.press(PointOption.point(971, 1276))
	         .waitAction(WaitOptions.waitOptions(Duration.ofMillis(600)))
	         .moveTo(PointOption.point(982, 1045))
	         .release()
	         .perform();
	         
	       //tap action old
	         //       action.tap(PointOption.point(600,900)).perform();
	        
	        //longpress action old
	                // action.longPress(PointOption.point(600,900)).perform();
	         
	        //scroll using actions (2)new
	         
	         Thread.sleep(5000);
	         
	         PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH, "finger");

	         Actions action1 = new Actions(driver);
	         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
	         while(driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='Three Hindu gods']")).size()==0)
	         {  
	                 action1.
	                 tick(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), 971, 1276))
	                 .tick(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
	                 
	                 
	                 .tick(new Pause(finger, Duration.ofMillis(600)))
	                 
	                 .tick(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), 982, 1045))
	                 .tick(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()))
	                 
	                 .build().perform();
	         }    
	         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	         driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Three Hindu gods']")).click();
	         
	        Point p= driver.findElement(AppiumBy.xpath("//android.view.View[@text='The Hindu preserver']")).getLocation();
	         System.out.println(p.x) ;
	         System.out.println(p.y) ;
	       //Long press on   The Hindu preserver
	         
	         PointerInput fingerLongpress=new PointerInput(PointerInput.Kind.TOUCH, "finger");

	         Actions actionLongpress = new Actions(driver);
	         
	         actionLongpress.
	         tick(fingerLongpress.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), p.x, p.y))
	         .tick(fingerLongpress.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
	                  
	         .tick(new Pause(fingerLongpress, Duration.ofMillis(3000)))
	         
	         .tick(fingerLongpress.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()))
	         
	         .build().perform();
 	         
	         //Tap 4 times on The Hindu preserver
	         PointerInput fingermultiplepress=new PointerInput(PointerInput.Kind.TOUCH, "finger");

	         Actions actionmultiplepress = new Actions(driver);
	         
	         for(int i=0;i<=4;i++)
	         {
	        	 actionmultiplepress.
	             tick(fingermultiplepress.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), p.x, p.y))
	             .tick(fingermultiplepress.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
	                      
	             .tick(new Pause(fingermultiplepress, Duration.ofMillis(600)))
	             
	             .tick(fingermultiplepress.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()))
	             
	             .build().perform();
	         }
	         //to get the current page dimension
	        Dimension dim= driver.manage().window().getSize();
	        System.out.println(dim.width);
	        System.out.println(dim.height);
	        
	       //to get the info using mobile commands 
	        String info= driver.executeScript("mobile: deviceInfo").toString();
	        System.out.println(info);
	        String batteryinfo= driver.executeScript("mobile: batteryInfo").toString();
	        System.out.println(batteryinfo);
	        
	        String timeinfo= driver.executeScript("mobile: getDeviceTime").toString();
	        System.out.println(timeinfo);
	        
	        Map<String,Object> map3=new HashMap<String,Object>();
	        map3.put("max", 2);
	        
	        String sms = driver.executeScript("mobile: listSms", map3).toString();
	        System.out.println(sms);
	        
	        driver.quit();
	        service.stop();
		}

}


