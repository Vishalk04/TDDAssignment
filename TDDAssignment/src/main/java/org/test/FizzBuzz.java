package org.test;

public class FizzBuzz {
	
	
	public String fizzBuzzCalculator(int input){
			
	
		return  (input%3==0 && input%5 ==0) ? "FizzBuzz": input%5==0 ? "Buzz": input%3 == 0? "Fizz" : String.valueOf(input);
		
	}

}
