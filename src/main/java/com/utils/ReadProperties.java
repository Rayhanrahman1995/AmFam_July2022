package com.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

	Properties properties;
	
	public ReadProperties() {
		loadProoerties();
	}
	
	private void loadProoerties() {
		InputStream inputStream=getClass().getClassLoader().getResourceAsStream("environment.properties");
		properties=new Properties();
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getProperty(String key) {
		if(key !=null) {
		return properties.getProperty(key);
		}else {
			return null;
		}
	}
	
	public long getWaitProperty(String key) {
		if(key !=null) {
			return Long.parseLong(properties.getProperty(key));
			}else {
				return 0;
			}
	}
	
	
	// debugging
	public static void main(String[] args) {
		ReadProperties readProperties=new ReadProperties();
	    String url=readProperties.getProperty("url");
	    System.out.println(url);
	    String url1=readProperties.getProperty(null);
	    System.out.println(url1);
	}
		
}
