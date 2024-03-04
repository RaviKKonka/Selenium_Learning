package com.solutions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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

		num = 34567;
		StringBuilder sb = new StringBuilder(String.valueOf(num));
		System.out.println(sb.reverse());

		num = 87656;
		StringBuffer sb1 = new StringBuffer(String.valueOf(num));
		System.out.println(sb1.reverse());
	}

	@Test
	void reverseString() {
		String str = "Testing";
		String rev = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			rev = rev + str.charAt(i);
		}
		System.out.println(rev);

		str = "Ravi K";
		StringBuilder sb = new StringBuilder(str);
		System.out.println(sb.reverse());

		str = "Test Ravi";
		StringBuffer sb1 = new StringBuffer(str);
		System.out.println(sb1.reverse());
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
		int[] a = { 12, 33, 78 };
		int[] b = { 12, 33, 78 };
		boolean flag = Arrays.equals(a, b);
		if (flag)
			System.out.println("Arrays are Equal");
		else
			System.out.println("Arrays are Not Equal");
	}

	@Test
	void dupicatesInArray() {
		int num[] = { 12, 44, 66, 23, 44, 65, 90, 12 };
		for (int i = 0; i < num.length; i++) {
			for (int j = i + 1; j < num.length; j++) {
				if (num[i] == num[j]) {
					System.out.println("Duplicate Number >> " + num[i]);
				}
			}
		}
	}

	@Test
	public void arraylist() {
		ArrayList<String> arrlist = new ArrayList<>();
		arrlist.add("Testing");// this will add Testing to the list
		arrlist.add(0, "Selenium");// this will add Selenium at first position (as array starts with 0)
		arrlist.add("Java");
		arrlist.add("lucky");
		arrlist.add("ABC");
		arrlist.add("XYZ");
		arrlist.set(3, "Loadrunner");// this will replace lucky with Loadrunner (as lucky is in index 3)
		arrlist.remove(4);
		arrlist.remove("XYZ");
		System.out.println(arrlist);
		System.out.println("Number of elements in ArrayList: " + arrlist.size());// it will show the size/length of
																					// array
		// Iterating Array List (to print only strings(not in array))
		System.out.println("All Data: ");
		for (String str : arrlist)
			System.out.println(str);
	}

	@Test
	void sortArray() {
		ArrayList<String> fruits = new ArrayList<String>();
		fruits.add("Banana");
		fruits.add("Mango");
		fruits.add("Orange");
		fruits.add(2, "Apple");
		Collections.sort(fruits); // Sort Ascending Order
		System.out.println(fruits);
		Collections.reverse(fruits); // Sort in Descending Order
		System.out.println(fruits);

		for (String fruit : fruits)
			System.out.println("Fruit Name >> " + fruit);
	}

	@Test
	void arrayToArrayList() {
		String array[] = { "bangalore", "Hyderabad", "Paris", "Brussels" };
		ArrayList<String> arrayList = new ArrayList<String>();
		Collections.addAll(arrayList, array);
		arrayList.add("Frisco");
		arrayList.add("Dallas");
		arrayList.add(4, "Brea");
		System.out.println(arrayList);
	}

	@Test
	void compareTwoStrings() {
		String str1 = "Ravi";
		String str2 = "Testing";
		int results = str1.compareTo(str2);
		if (results == 0)
			System.out.println("Strings are Equal");
		else
			System.out.println("Strings are Not Equal");
	}

	@Test
	void splitExample() {
		String name = "I am Ravi";
		String name1[] = name.split(" ");
		for (String value : name1)
			System.out.println(value);
	}

	@Test
	void replaceExample() {
		String name = "Ravi342Test";
		name = name.replace("342", " ");
		System.out.println(name);
	}

	@Test
	void replaceAll() {
		String name = "kjlsfjlfOHH^&&}45455{{}{}|><>?#$^^@!!";
		name = name.replaceAll("[^a-zA-Z0-9]", ""); // will keep letters and numbers
		System.out.println(name);
		name = "kjlsfjlfOHH^&&}45455{{}{}|><>?#$^^@!!";
		name = name.replaceAll("[a-zA-Z0-9]", ""); // will remove letters and numbers
		System.out.println(name);
	}

	@Test
	void avarageElementsArray() {

		int num[] = { 12, 55, 98, 23, 97, 44 };
		float avg = 0;
		for (int value : num) {
			avg = avg + value;
		}
		avg = avg / num.length;
		System.out.println("Avg >> " + avg);
	}

	@Test
	void smallestElementArray() {
		int num[] = { 12, 55, 98, 23, 97, 44 };
		int min = Integer.MAX_VALUE;
		for (int value : num) {
			if (value < min) {
				min = value;
			}
		}
		System.out.println("Smallest Value in Array >> " + min);
	}

	@Test
	void largestElementArray() {
		int num[] = { 12, 55, 98, 23, 97, 44 };
		int max = Integer.MIN_VALUE;
		for (int value : num) {
			if (value > max) {
				max = value;
			}
		}
		System.out.println("Smallest Value in Array >> " + max);
	}

	@Test
	void secondLargestNumber() {
		int num[] = { 140, 34, 87, 23, 89, 11, 9 };
		Arrays.sort(num);
		System.out.println(num[num.length - 2]);
	}

	@Test
	void subStringExample() {
		String str = "Selenium Java Testing";
		System.out.println(str.substring(9));
		System.out.println(str.substring(0, 8));
		System.out.println(str.subSequence(9, 13));
		System.out.println(str.substring(3, 4));
	}

	@Test
	void trimExample() {
		String str = " Ravi Konka ";
		System.out.println(str.trim());
	}

	@Test
	void stringContainsExample() {
		String str = "Testing Java";
		if (str.contains("Java"))
			System.out.println("String Contains the Java");
		else
			System.out.println("String is not contains the Java");
	}

	@Test
	void arrayConvertToString() {
		int num[] = { 12, 52, 63, 78 };
		System.out.println(Arrays.toString(num));
	}

	@Test
	void addNewNumberArray() {
		Integer[] num = { 12, 52, 63, 78, 44 };
		ArrayList<Integer> numList = new ArrayList<Integer>(Arrays.asList(num));
		numList.add(55);
		System.out.println(numList);
	}

	@Test
	void addNewStringToArray() {
		String[] str = { "Banana", "Apple", "Mango" };
		ArrayList<String> newStr = new ArrayList<String>(Arrays.asList(str));
		newStr.add("Orange");
		System.out.println(newStr);
	}

	@Test
	void toLowerCase() {
		String str = "Ravi Konka";
		System.out.println(str.toLowerCase());
	}

	@Test
	void toUpperCase() {
		String str = "Ravi Konka";
		System.out.println(str.toUpperCase());
	}

	@Test
	void indexOf() {
		String str = "Testing";
		System.out.println(str.indexOf("i"));
	}

	@Test
	void stringFuntions() {
		String str = "Java";
		System.out.println(str.startsWith("J")); // returns True
		System.out.println(str.endsWith("a")); // returns True
		str = "^J..a$";
		boolean str1 = "Java".matches(str); // returns True
		System.out.println(str1);
		str = ""; // string length will be Zero
		System.out.println(str.isEmpty()); // returns True
		str = " "; // String length is not zero, but value is blank
		System.out.println(str.isBlank()); // returns True

		String a = "I", b = "Love", c = "You";
		System.out.println(String.join(" ", a, b, c));
	}


	@Test
	void replaceFirst() {

		String str1 = "bbtecaatest";
		System.out.println(str1.replaceFirst("aa", "zz")); // replace aa with zz
		String str2 = "Java8434testing1234";
		String regexp = "\\d+"; // regex for sequence of digits
		System.out.println(str2.replaceFirst(regexp, " ")); // replace 8434 with space

	}
	
	@Test
	void createFileWriteReadFile() throws Exception {
		String fileName = "test.text";
		File file = new File(fileName);
		boolean result = file.createNewFile();
		if(result) {
			FileWriter fw = new FileWriter(fileName);
			fw.write("url = https://www.google.com/;");
			fw.close();
		}
		Properties myProp = new Properties();
		FileInputStream fi = new FileInputStream(fileName);
		myProp.load(fi);
		System.out.println(myProp.getProperty("url"));
		
		
		Scanner sc = new Scanner(fileName);
		while(sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		}
		sc.close();
	}
	
	@Test
	void jsonParse() throws Exception {
		JSONParser jper = new JSONParser(); 
		Object obj = jper.parse(new FileReader("test.json"));
		JSONObject jobj = (JSONObject) obj;
		System.out.println(jobj.get("title"));
	}
	
	@Test
	void concatenateTwoArrays() {
		int[] array1 = {1,5,22,89};
		int[] array2 = {44,89,12,13};
		int[] result = new int[array1.length + array2.length];
		System.arraycopy(array1, 0, result, 0, array1.length);
		System.arraycopy(array2, 0, result, array1.length, array2.length);
		System.out.println(Arrays.toString(result));
		
	}
	
	@Test
	void iterateHashMap() {
		HashMap<Integer,String> HM = new HashMap<Integer,String>();
		HM.put(1, "Java");
		HM.put(2, "Selenium");
		HM.put(3, "SQL");
		HM.put(4, "MongoDB");
		
		for(Map.Entry me: HM.entrySet()) {
			System.out.println("Key is: " + me.getKey() + " Value is >> " + me.getValue());
			System.out.println(me.setValue(HM));
			
		}
	}
	
}
