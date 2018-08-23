package org.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FizzBuzzTest {
	
	FizzBuzz fizzBuzz = new FizzBuzz();

	@Test
	public void ShouldReturnFizzIfInputNumberIsDivisibleBy3(){
		
		assertEquals("Fizz", fizzBuzz.fizzBuzzCalculator(3));
		
	}
	
	@Test
	public void ShoudReturnBuzzIfInputNumberIsDivisibleBy5(){
		assertEquals("Buzz", fizzBuzz.fizzBuzzCalculator(5));
	}
	
	@Test
	public void shouldReturnFizzBuzzWhenInputNumberIsDivisbleBy3And4(){
		assertEquals("FizzBuzz", fizzBuzz.fizzBuzzCalculator(15));
	}
	
	@Test
	public void shouldReturnSameNumberIfInputNumberIsNotDivisibleBy3And5(){
		assertEquals("4", fizzBuzz.fizzBuzzCalculator(4));
	}
}
