package com.sina.super_sports.test;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidElement;

public class FocusTestDemo extends BaseTest{
	@Test
	public void testFocus() {
		//切到体育频道
		driver.findElementByXPath("//*[@resource-id='com.sina.news:id/aa8'][@text='体育']").click();		
		//点击第三个tab
		driver.findElementByXPath("//*[@resource-id='com.sina.news:id/afu']/android.widget.LinearLayout[3]").click();
		
		System.out.println(driver.getContextHandles());//[NATIVE_APP, WEBVIEW_stetho_com.sina.news, WEBVIEW_com.sina.news]
				
		driver.context("WEBVIEW_com.sina.news");	
		AndroidElement element=driver.findElementByXPath("//html/body/main/div/div[1]/section/aside[1]/span[2]/a/b[2]");
		element.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(element.getText().equals("已关注")) {
			driver.context("NATIVE_APP");
			//点击弹窗上的确定按钮
			driver.findElementById("com.sina.news:id/l7").click();
			
		}

		driver.context("NATIVE_APP");
		//点击左上角的返回
		driver.findElementById("com.sina.news:id/qa").click();
	}


}
