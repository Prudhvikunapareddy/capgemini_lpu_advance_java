package com.parameterized;


public class Program {
	public boolean isPalindrome(String str) {
		String rev = new StringBuilder(str).reverse().toString();
	
		if(str.equals(rev)) {
			return true;
		}else {
			return false;
		}
		
	}
	public int add(int a,int b) {
		return a+b;
	}

}
