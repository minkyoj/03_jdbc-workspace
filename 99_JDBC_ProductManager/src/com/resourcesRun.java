package com;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class resourcesRun {

	public static void main(String[] args) {
		
		Properties prop = new Properties();
		
		try {
			prop.store(new FileOutputStream("resources/driver.properties"), "properties Test");
			prop.storeToXML(new FileOutputStream("resources/query.xml"), "properties Test");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
