package com.solutions;

import java.util.Arrays;

import org.testng.annotations.Test;

public class AllNewSamples {

	@Test
	void swapNumbers() {
		int a = 20;
		int b = 10;
		b = (a + b) - (a = b);
		System.out.println("a value >> " + a + " b value >> " + b);
	}

	@Test
	void reverseNumber() {
		int num = 123456;
		int rev = 0;
		while (num > 0) {
			rev = rev * 10 + num % 10;
			num = num / 10;
		}
		System.out.println(rev);
	}

	@Test
	void reverseString() {
		String str = "Testing";
		String rev = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			rev = rev + str.charAt(i);
		}
		System.out.println(rev);
	}

	@Test
	void palindromeNumber() {
		int num = 1234321;
		int original = num;
		int rev = 0;
		while (num > 0) {
			rev = rev * 10 + num % 10;
			num = num / 10;
		}

		if (original == rev)
			System.out.println("Palindrome Number");
		else
			System.out.println("Not a Palindrome Number");
	}

	@Test
	void palindromeString() {
		String str = "RavivaR";
		String Original = str, rev = "";
		for (int i = str.length() - 1; i >= 0; i--)
			rev = rev + str.charAt(i);
		if (Original.equals(rev))
			System.out.println("PalindromeString");
		else
			System.out.println("Not a PalindromeString");
	}

	@Test
	void countNumberofDigits() {
		int num = 123456;
		int count = 0;
		while (num > 0) {
			count++;
			num = num / 10;
		}
		System.out.println(count);
	}

	@Test
	void sumOfDigits() {
		int num = 12345;
		int sum = 0;
		while (num > 0) {
			sum = sum + num % 10;
			num = num / 10;
		}
		System.out.println(sum);
	}

	@Test
	void oddEvenNumbers() {
		int num = 1234567;
		int temp;
		String odd = "";
		String even = "";
		while (num > 0) {
			temp = num % 10;

			if (temp % 2 == 0)
				even = even + " " + temp;
			else
				odd = odd + " " + temp;
			num = num / 10;
		}
		System.out.println("even number >> " + even);
		System.out.println("odd number >> " + odd);
	}

	@Test
	void fibonacciSeries() {
		int a = 0, b = 1;
		int feb = 0;
		System.out.print(a + " " + b);
		for (int i = 0; i < 10; i++) {
			feb = a + b;
			a = b;
			b = feb;
			System.out.print(" " + feb);
		}
		System.out.println();
	}

	@Test
	void primeNumber() {
		int num = 29;
		boolean flag = false;
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				flag = true;
				break;
			}
		}
		if (!flag)
			System.out.println("Prime Number");
		else
			System.out.println("Not a Prime Number");

	}

	@Test
	void factorialOfANumber() {
		int num = 5;
		int fact = 1;
		for (int i = 1; i <= num; i++) {
			fact = fact * i;
		}
		System.out.println(fact);
	}

	@Test
	void printStarsIncrease() {
		for (int i = 1; i < 6; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	@Test
	void largestNumberArray() {
		int[] num = { 12, 44, 23, 21, 43, 55 };
		int large = Integer.MIN_VALUE;
		for (int value : num) {
			if (large < value)
				large = value;
		}
		System.out.println(large);
	}

	@Test
	void findMaxMinArray() {
		int[] num = { 12, 44, 23, 21, 43, 55 };
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int value : num) {
			if (max < value)
				max = value;
			if (min > value)
				min = value;
		}
		System.out.println("Max Value >> " + max);
		System.out.println("Min Value >> " + min);
	}
	
	@Test
	void equalityOfArray() {
		int[] a = {12,33,78};
		int[] b = {12,33,78};
		boolean flag = Arrays.equals(a, b);
		if(flag)
			System.out.println("Arrays are Equal");
		else
			System.out.println("Arrays are Not Equal");
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
