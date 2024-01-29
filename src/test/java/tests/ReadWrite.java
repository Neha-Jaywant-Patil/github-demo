package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadWrite {

	public static void main(String[] args) throws IOException {
		File file = new File("src/test/resources/properties/testdata.properties");
		Properties prop = new Properties();
		FileInputStream inputstream = new FileInputStream(file);

		prop.load(inputstream);
		System.out.println(prop.getProperty("browser"));
		System.out.println(prop.getProperty("url"));

		FileOutputStream outputstream = new FileOutputStream(file);
	
		prop.setProperty("PhNumber", "34566789");
		prop.store(outputstream, "Customer Phone naumber");

	}

}
