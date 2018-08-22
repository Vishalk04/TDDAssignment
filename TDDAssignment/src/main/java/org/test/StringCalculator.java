package org.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

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

			List<Integer> negativeInputNumbers = Arrays.asList(input.split(delimiter)).stream().map( i -> Integer.valueOf(i)).filter( i -> i < 0).collect(Collectors.toList());
			
			if(!negativeInputNumbers.isEmpty()){
				String negativeNumbers = negativeInputNumbers.toString();
				throw new RuntimeException("negativeNotAllowed "+negativeInputNumbers.toString().substring(1, negativeNumbers.length()-1));
			}
			
			result = Arrays.asList(input.split(delimiter)).stream().mapToInt(i -> Integer.valueOf(i)).filter(i -> i <= 1000).sum();
			
		}
		
		logger.info(String.valueOf(result));
		
		return result;
	}
	
}
