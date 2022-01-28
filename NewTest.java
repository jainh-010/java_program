package com.test;
import org.testng.annotations.Test;

import java.sql.SQLException;

import org.testng.Assert;

public class NewTest {
	
  @Test
  public void InsertTest() throws SQLException {
	  test Select = new test();
	  
	  Assert.assertEquals(1,Select.insert(10,"LOL","Bikaner"));
  }
}


