package testNG.day1;

import org.testng.annotations.Test;

public class learnAttributes {
		@Test(priority = -1)
		public void createLead() {
			System.out.println("CREATE LEAD");
		}
		@Test
		public void EditLead() {
			System.out.println("EDIT LEAD");
		}
		@Test(priority = 1)
		public void mergeLead() {
			System.out.println("MERGE LEAD");
		}
		@Test(priority =3)
		public void deleteLead() {
			System.out.println("DELETE LEAD");
		}
		@Test(priority = 2 , enabled =false)
		public void duplicateeLead() {
			System.out.println("DUPLICATE LEAD");
		}
		
	}