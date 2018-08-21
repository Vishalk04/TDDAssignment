package org.test;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;



public class StringCalculator {
	
	private Logger logger = Logger.getLogger(StringCalculator.class);

	
	public int add(String input) {

		int result = 0;
		String delimiter = "\n|,";	
		
		
		if (input.length() > 0) {
		
			if(input.startsWith("//")){
				delimiter =  input.substring(2, input.indexOf("\n"));
				input = input.substring(input.indexOf("\n")+1);
			}
				
			List<String> inputStrings = Arrays.asList(input.split(delimiter));
			result = inputStrings.stream().mapToInt(i -> Integer.valueOf(i)).filter(i -> i <= 1000).sum();
			
		}
		
		logger.info(String.valueOf(result));
		
		return result;
	}
	
}
