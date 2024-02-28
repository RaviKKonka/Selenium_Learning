package com.solutions;

import org.testng.annotations.Test;

public class AllNewSamples {

	@Test
	void swapNumbers() {
		int a = 20;
		int b = 10;
		b = (a+b)-(a=b);
		System.out.println("a value >> " + a + " b value >> " + b);
	}
	
	@Test
	void reverseNumber() {
		int num = 123456;
		int rev = 0;
		while(num>0) {
			rev = rev*10 + num%10;
			num = num/10;
		}
		System.out.println(rev);
	}
	
	@Test
	void reverseString() {
		String str = "Testing";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
