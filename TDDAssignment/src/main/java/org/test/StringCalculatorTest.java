package org.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;


import org.apache.log4j.Logger;





@RunWith(MockitoJUnitRunner.class)
//@PrepareForTest({LoggerFactory.class})
public class StringCalculatorTest {


	@InjectMocks 
	private StringCalculator  stringCalculator; 
	
	@Mock
	private Logger loggerMock;
	
	
	@Test
	public void shouldReturnZeroWhenInputEmpty(){

		assertEquals(0, stringCalculator.add(""));
		
	}
	
	@Test
	public void ShouldReturnSameNumberWhenInputStringIsSingleNumber(){
		
		assertEquals(1, stringCalculator.add("1"));
	
	}
	
	@Test
	public void shouldReturnAdditionWhenInputStringIsTwoNumbers(){
		
		
		assertEquals(3, stringCalculator.add("1,2"));
		
	}
	
	@Test
	public void shouldReturnAdditionWhenInputStringIsMultipleNumbers(){
		
		assertEquals(15, stringCalculator.add("1,2,3,4,5"));
	}
	
	@Test
	public void shouldRetrunAdditionWhenInputIncludeNewLine(){
			
		assertEquals(15, stringCalculator.add("1\n2,3\n4\n5"));
		
	}
	
	@Test
	public void shouldReturnAdditionWhenInputSupportDifferentDelimeter(){
		
		assertEquals(3, stringCalculator.add("//;\n1;2"));
		
	}
	
	@Test
	public void shouldReturnAdditionExcludingNumberGreaterThan1000(){
		assertEquals(2, stringCalculator.add("2,1001"));
		
	}
	
	@Test
	public void ShouldLoggedTheAdditionResult(){
		
		//Logger loggerMock =  Mockito.mock(Logger.class);
		
		   //when(loggerMock.isDebugEnabled()).thenReturn(false);
	        Mockito.doNothing().when(loggerMock).info(any(String.class));
		
	        
	        //Mockito.when(loggerMock).info(Mockito.any(String.class))//loggerMock.info(any(String.class)))
	        stringCalculator.add("1,2");
	        
	        Mockito.verify(loggerMock).info(any(String.class));
		
		
	}
	
	
}
