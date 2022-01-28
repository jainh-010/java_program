package com.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.sql.SQLException;
import org.testng.Assert;

public class NewTest {
	test Select = new test();

	@Test
	public void ConnectionOpenTest() throws SQLException {
		Select.initialize();
	}
	
	@DataProvider(name="InputData")
		public Object[][] dataProvFun(){
			return new Object[][] {{31,"", "london"},{35,"Harry",""}};
		}
	
	@DataProvider(name="DeleteData")
	public Object[][] dataProvFun1(){
		return new Object[][] {{26},{0},{30}};
	}
	@DataProvider(name="UpdateData")
	public Object[][] dataProvFun2(){
		return new Object[][] {{50,""},{19,""},{25,"Harry"}};
	}
	
	@Test(dependsOnMethods= {"ConnectionOpenTest"},dataProvider="InputData")
	public void InsertTest(int Id , String Name , String City) throws SQLException {
		Assert.assertEquals(1, Select.insert(Id, Name, City),"Input Error");
	}
	
	@Test(dependsOnMethods= {"ConnectionOpenTest"},dataProvider="UpdateData")
	public void UpdateTest(int Id, String Name) throws SQLException {
		Assert.assertEquals(1, Select.update(Id , Name),"Input Error");
	}
	
	@Test(dependsOnMethods= {"ConnectionOpenTest"},dataProvider="DeleteData")
	public void DeleteTest(int Id) throws SQLException {
		Assert.assertEquals(1, Select.delete(Id),"Input Error");
	}

	@AfterTest
	public void ConnectionCloseTest() throws SQLException {
		Select.shutdown();
	}
}
