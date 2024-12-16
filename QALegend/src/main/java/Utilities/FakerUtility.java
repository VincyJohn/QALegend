package Utilities;

import java.util.Random;

public class FakerUtility 
{
	public static int randomNumberGenerator()
	{
		Random rand= new Random();
		int randomnumber=rand.nextInt(100000);
		return randomnumber;
		
	}
	public static String randomEmailGenerator()
	{
		Random rand= new Random();
		int randomnumber=rand.nextInt(100000);
		String emailId="newemail"+randomnumber+"@gmail.com";
				return emailId;
	}
}
