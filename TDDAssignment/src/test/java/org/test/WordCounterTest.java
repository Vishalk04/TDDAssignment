package org.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class WordCounterTest {

	WordCounter wordCounter = new WordCounter();
	
	@Test
	public void shouldReturnUniqWordsWithCountWhenInputIsDelimitedString(){
		
		assertEquals("boom=2, bang=1", wordCounter.getWordCount("boom bang boom"));
		
	}
	
	 @Test
	 public void shouldReturnEmptyStringWhenInputIsEmptyString(){
		 assertEquals("", wordCounter.getWordCount(""));
	 }
	 
	 @Test
	 public void shouldReturnEmptyStringWhenInputIsNull(){
		 assertEquals("", wordCounter.getWordCount(null));
	 }
	 
		 
	
}
