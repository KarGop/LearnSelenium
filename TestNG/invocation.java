package testNG.day2;

import org.testng.annotations.Test;

public class invocation {
	//Run same TC multiple times
	@Test(priority = 1, invocationCount=5)
	public void createLead() {
		System.out.println("CREATE LEAD");
	}
	//Run TC with default priority=0
	@Test
	public void EditLead() {
		System.out.println("EDIT LEAD");
	}
}
