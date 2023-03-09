package genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetryAnalyser_Class implements IRetryAnalyzer{

	int count = 0;
	int n = 5;

	public boolean retry(ITestResult result) {
		if (count<n) {
			count++;
			return true;
		} else {
			return false;
		}
	}
}
