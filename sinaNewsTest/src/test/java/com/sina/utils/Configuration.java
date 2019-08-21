package com.sina.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
 * 读取sinanews_config.properties数据文件
 */
public class Configuration {
	private Properties prop=new Properties();
	//读取数据文件
	public Configuration(String configFile) {
		InputStream is=this.getClass().getClassLoader().getResourceAsStream(configFile);
		try {
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//通过key获取value
	public String getConfig(String key) {
		String value=prop.getProperty(key);
		return value;
	}

}
