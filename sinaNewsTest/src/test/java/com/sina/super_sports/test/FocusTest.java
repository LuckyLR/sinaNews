package com.sina.super_sports.test;

import org.testng.annotations.Test;

import com.sina.pages.FocusActivity;

/*
 * 用例步骤核心业务逻辑部分
 */
public class FocusTest extends BaseTest{
	
	@Test(description="切到体育频道，然后点击第三个tab，进入页面点击关注，如果是已关注，点击弹窗上的“取消”按钮，再次点关注，然后点弹窗上的确定按钮，点赞，然后再返回")
	public void focusTest() {
		FocusActivity focusActivity=new FocusActivity(driver);
		focusActivity.clickSport();
		focusActivity.clickTb();
		focusActivity.clickDz();
		focusActivity.clickFocus();	
		focusActivity.clickReturn();
	}
	

}
