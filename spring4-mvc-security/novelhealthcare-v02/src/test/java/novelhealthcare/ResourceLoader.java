package novelhealthcare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

public class ResourceLoader 
{
	public static void main(String[] args) 
	{
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		ResourceBundle resourceBundle = (ResourceBundle)classPathXmlApplicationContext.getBean("resourceBundle");
				
		Resource resource = resourceBundle.getBaseName();
		try 
		{
			InputStream inputStream = resource.getInputStream();
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			String string = null;
			while((string=bufferedReader.readLine())!=null)
			{
				System.out.println(string);
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
