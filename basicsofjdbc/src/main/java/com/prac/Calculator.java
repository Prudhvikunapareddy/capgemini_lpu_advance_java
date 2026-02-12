package com.prac;

public class Calculator {
	public static int add(int a,int b) {
		return a+b;
	}
	public static String reverseString(String data) {
		String rev = "";
		for(int i =data.length()-1;i>=0;i--) {
			rev = rev+data.charAt(i);
		}
		return rev;
		
	}
	public static int fac(int n) {
		int fact = 1;
		for(int i=1;i<=n;i++) {
			fact =fact*i;
		}
		return fact;
	}
	public static boolean palindrome(int num) {
		int orginal = num;
		int reverse=0;
		while(num>0) {
			int digit = num%10;
			reverse = reverse*10+digit;
			num = num/10;
		}
		return orginal == reverse;
		
	}

}
