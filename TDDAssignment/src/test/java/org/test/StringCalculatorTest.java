package org.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;

import org.apache.log4j.Logger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StringCalculatorTest {

	@InjectMocks
	private StringCalculator stringCalculator;

	@Mock
	private Logger loggerMock;

	@Test
	public void shouldReturnZeroWhenInputEmpty() {

		assertEquals(0, stringCalculator.add(""));

	}

	@Test
	public void ShouldReturnSameNumberWhenInputStringIsSingleNumber() {

		assertEquals(1, stringCalculator.add("1"));

	}

	@Test
	public void shouldReturnAdditionWhenInputStringIsTwoNumbers() {

		assertEquals(3, stringCalculator.add("1,2"));

	}

	@Test
	public void shouldReturnAdditionWhenInputStringIsMultipleNumbers() {

		assertEquals(15, stringCalculator.add("1,2,3,4,5"));
	}

	@Test
	public void shouldRetrunAdditionWhenInputIncludeNewLine() {

		assertEquals(15, stringCalculator.add("1\n2,3\n4\n5"));

	}

	@Test
	public void shouldReturnAdditionWhenInputSupportDifferentDelimeter() {

		assertEquals(3, stringCalculator.add("//;\n1;2"));

	}

	@Test
	public void shouldReturnAdditionExcludingNumberGreaterThan1000() {
		assertEquals(2, stringCalculator.add("2,1001"));

	}

	@Test
	public void ShouldLoggedTheAdditionResult() {

		Mockito.doNothing().when(loggerMock).info(any(String.class));
		stringCalculator.add("1,2");
		Mockito.verify(loggerMock).info(any(String.class));

	}
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none(); 
	
	@Test
	public void shouldThrowExceptionWhenInputIncludeNegativeValues(){
		
		expectedException.expect(RuntimeException.class);
		expectedException.expectMessage("negativeNotAllowed -1, -2");
		stringCalculator.add("-1,-2,3");
				
	}
	

}
