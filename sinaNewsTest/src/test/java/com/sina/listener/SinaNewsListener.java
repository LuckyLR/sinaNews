package com.sina.listener;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
/*
 * 监听器：测试用例执行失败时自动截屏
 */
public class SinaNewsListener extends TestListenerAdapter{
	private AndroidDriver<AndroidElement> driver;
	@SuppressWarnings("unchecked")
	@Override
	public void onTestFailure(ITestResult tr) {
		String directory="screenshot";
		String filename=tr.getTestClass().getName()+"."+tr.getMethod().getMethodName()+"_"
				+new SimpleDateFormat("yyyy-MM-dd.HHmmss.SSS").format(new Date())+".png";
		
		try {
			//通过反射获取到执行的那个driver
			driver=(AndroidDriver<AndroidElement>)tr.getTestClass().getRealClass().getField("driver").get(tr.getInstance());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		//自动截屏
		File file=driver.getScreenshotAs(OutputType.FILE);
		File dir=new File(directory);
		if(!dir.exists()) {
			dir.mkdir();
		}
		File png=new File(dir, filename);
		file.renameTo(png);
	}

}
