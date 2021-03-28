package rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws IOException {
		
		Properties config=new Properties();
		Properties objectRepo=new Properties();
		
		String filePath = System.getProperty("user.dir")+"/src/test/resources/properties/config.properties";
		FileInputStream fis=new FileInputStream(filePath);
		config.load(fis);
		
		String filePath1 = System.getProperty("user.dir")+"/src/test/resources/properties/objectRepo.properties";
		FileInputStream fis1=new FileInputStream(filePath1);
		objectRepo.load(fis1);
		
		System.out.println(config.getProperty("browser"));	

		System.out.println(objectRepo.getProperty("bmlBtn"));	
	
	
	
	}

}
