package TestScript;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer
{
int counter=0;
int retrylimit=4;

	@Override
	public boolean retry(ITestResult result) {
		if(counter<retrylimit)
		{
			counter ++;
			return true;
		}
		return false;
	}

}
