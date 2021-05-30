package testNG.dependsOnMethods;

import org.testng.annotations.Test;

public class testCases {
	//packageName.ClassName.methodName
	@Test(dependsOnMethods = {"testNG.dependsOnMethods.testCases1.createLead"})
	public void editLead() {
		System.out.println("edit Lead");

	}

	@Test(dependsOnMethods = { "testNG.dependsOnMethods.testCases1.createLead", "testNG.dependsOnMethods.testCases1.editLead" })
	public void deleteLead() {
		System.out.println("delete Lead");

	}
	@Test
	public void createLead() {
		System.out.println("Create Lead");
	//	throw new NoSuchElementException();
	}
	@Test(dependsOnMethods = {"testNG.dependsOnMethods.testCases1.editLead"})
	public void duplicateLead() {
		System.out.println("duplicate lead");

	}
	@Test
	public void mergeLead() {
		System.out.println("merge lead");

	}
}
