package com.in28Minutes.mockito.Mockitodemo;

import static org.junit.Assert.*;

import org.junit.Test;

public class SomeBussinessTest {

	@Test
	public void test() {
		
		SomeBusinessImpl sm= new SomeBusinessImpl(new dataprovider());
         int result = sm.findGreatestFromAllData();	
 	assertEquals(36, result);
	}

}


class dataprovider implements DataService
{

	@Override
	public int[] retrieveAllData() {
		// TODO Auto-generated method stub
		return new int[] {25,36,14};
	}

	
	
	
}
