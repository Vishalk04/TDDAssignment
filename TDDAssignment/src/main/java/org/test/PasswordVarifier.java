package org.test;

import java.util.regex.Pattern;

public class PasswordVarifier {

	public boolean verify(String password) {

		boolean lowercaseFlag = false;		
		boolean result = false;
		
		boolean nullFlag = false;
		boolean lengthFlag = false;
		boolean uppercaseFlag = false;
		boolean digitFlag = false;
		
		
		
		int count = 0;
		
		if (password != null || !password.isEmpty()) {
			nullFlag = true;
			count += 1;
		}

		if (password.length() > 8) {
			lengthFlag = true;
			count += 1;
		}
		
		
		if(Pattern.matches(".*\\d+.*", password)){
			digitFlag = true;
			count+=1;
		}
		
		if(Pattern.matches(".*[A-Z].*", password)){
				count+=1;
				uppercaseFlag = true;
		}
		if(Pattern.matches(".*[a-z].*", password)){
			lowercaseFlag = true;
		}
			
	
/*
		for (int i = 0; i < password.length(); i++) {

			if (Character.isUpperCase(password.charAt(i)) && !uppercaseFlag) {
				uppercaseFlag = true;
				count += 1;
			}

			if (Character.isLowerCase(password.charAt(i)))
				lowercaseFlag = true;

			if (Character.isDigit(password.charAt(i))) {
				count += 1;
				digitFlag = true;
			}

		}*/

		if (lowercaseFlag) {
			if (count > 2) {
				result = true;
			} else {
				throw new RuntimeException("At Least 3 Condition are not met");
			}
		} else {
			throw new RuntimeException("Lower case condition does not met");
		}
		
		//result = uppercaseFlag && lowercaseFlag && digitFlag && lengthFlag && nullFlag ;
		return result;
		
	}

}
