package novelhealthcare;

import java.security.NoSuchAlgorithmException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class ForTesting 
{
	public static void main(String[] args) 
	{
		try 
		{
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(8);
			String encode =  encoder.encode("Yugandhar");
			System.out.println(encode);
			/*MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update("Yuga".getBytes());
			byte[] encode = messageDigest.digest();
			String string = new String(encode);
			System.out.println(string);
			System.out.println(Base64.getEncoder().encodeToString(encode));*/
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
