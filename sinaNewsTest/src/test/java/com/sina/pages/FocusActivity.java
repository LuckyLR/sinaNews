package com.sina.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/*
 * 使用页面对象的标准模型来封装
 * 这样把 元素以及元素操作方法（即逻辑行为）抽象出来。
 */
public class FocusActivity {
	
	private AndroidDriver<AndroidElement> driver;
	
	//定位体育频道
	@FindBy(xpath="//*[@resource-id='com.sina.news:id/ach'][@text='体育']")
	private AndroidElement channel_sport;
	
	//定位第三个tab
	@FindBy(xpath="//*[@resource-id='com.sina.news:id/aip']/android.widget.LinearLayout[3]")
	private AndroidElement tab_three;
	
	//定位关注按钮
	@FindBy(xpath="//html/body/main/div/div[1]/section/aside[1]/span[2]/a/b[2]")
	private AndroidElement focus_btn;
	
	//定位取消关注弹窗上的“确定”按钮
	@AndroidFindBy(id="com.sina.news:id/m1")
	private AndroidElement confirm_btn;
	
	//定位取消关注弹窗上的“取消”按钮
	@AndroidFindBy(id="com.sina.news:id/m3")
	private AndroidElement cancel_btn;
	
	//点赞
	@FindBy(xpath="//html/body/main/div/div[1]/section/aside[1]/span[1]/a/div")
	private AndroidElement dz_btn;
	
	//定位返回按钮
	@AndroidFindBy(id="com.sina.news:id/ri")
	private AndroidElement return_btn;
	
	public FocusActivity(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//切换到体育频道
	public void clickSport() {
		channel_sport.click();
	}
	
	//点击第三个tab
	public void clickTb() {
		tab_three.click();
	}
	
	//点击关注按钮
	public void clickFocus() {
		driver.context("WEBVIEW_com.sina.news");	
		focus_btn.click();
		if(focus_btn.getText().equals("已关注")) {
			driver.context("NATIVE_APP");
			//先点击取消按钮
			cancel_btn.click();
			driver.context("WEBVIEW_com.sina.news");	
			//点击“已关注”按钮
			focus_btn.click();
			driver.context("NATIVE_APP");
		    //点击弹窗上的确定按钮
			confirm_btn.click();				
		}
	}
	
	//点击点赞按钮
	public void clickDz() {
		driver.context("WEBVIEW_com.sina.news");
		dz_btn.click();
	}
	
	//点击返回按钮
	public void clickReturn() {
		driver.context("NATIVE_APP");
		return_btn.click();
	}
	
	

}
