package Utilities;

import java.util.Random;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;

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
	public String getFakeFirstname()
	{
		Faker faker =new Faker();
		Address address=faker.address();
		String text= address.firstName();
		return text;
	}
	public String getFakeLastname()
	{
		Faker faker =new Faker();
		Address address=faker.address();
		String text= address.lastName();
		return text;
	}
}
