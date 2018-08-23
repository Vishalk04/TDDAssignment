package org.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PasswordVarifierTest {

	PasswordVarifier passwordVarifier = new PasswordVarifier();

	@Ignore
	@Test
	public void ShouldReturnTrueWhenInputIsGreaterThan8Char() {
		// assertFalse(passwordVarifier.verify("qwert"));
		assertTrue(passwordVarifier.verify("qweqw"));

	}

	@Ignore
	@Test
	public void shouldReturnFalseWhenInputIsNull() {

		assertFalse(passwordVarifier.verify(""));

	}

	@Ignore
	@Test
	public void shouldRetrunTrueWhenPasswordIsNotNull() {
		assertTrue(passwordVarifier.verify("qertQWWQEWERE1"));
	}

	@Ignore
	@Test
	public void shoudReturnTrueWhenInputContainAtLeast1UpperCaseLetter() {

		assertTrue(passwordVarifier.verify("1qwertssyuiF"));

	}

	@Ignore
	@Test
	public void shouldReturnTrueWhenInputContainAtLeast1LowerCaseLetter() {
		assertTrue(passwordVarifier.verify("1QWERTYUIOOe"));
	}

	@Ignore
	@Test
	public void shouldReturnTrueWhenInputContainAtLeast1Number() {
		assertTrue(passwordVarifier.verify("qertQWWQEWERE1"));
	}

	@Ignore
	@Test
	public void testVerify() {
		assertTrue(passwordVarifier.verify("qweqweQWE123123456"));
	}

	@Test
	public void shoudReturnTrueIfAtLeast3ConditionMet() {

		assertTrue(passwordVarifier.verify("qweqweQWE123123456"));

	}

	@Test
	public void shouldReturnTrueIfLowerCaseConditionMet() {

		assertTrue(passwordVarifier.verify("qQWE123123456"));

	}
	
	

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Ignore
	@Test
	public void shoudReturnFalseIfAtLeast3ConditionNotMet() {

		exception.expect(RuntimeException.class);
		exception.expectMessage("At Least 3 Condition are not met");
		assertTrue(passwordVarifier.verify("qweqw"));

	}

	@Ignore
	@Test
	public void shouldReturnTrueIfLowerCaseConditionNotMet() {

		exception.expect(RuntimeException.class);
		exception.expectMessage("Lower case condition does not met");
		assertTrue(passwordVarifier.verify("QWE123123456"));

	}

}
