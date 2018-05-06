package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import arraysAndStrings.StringMethods;

public class StringMethodsTest {


	@Test
	public void testIsUniqueCharacters() {
		StringMethods s = new StringMethods();
		assertTrue(s.isUniqueCharacters("tiger"));
		assertFalse(s.isUniqueCharacters("catterpillar"));
	}

	@Test
	public void testIsPermutation() {
		StringMethods s = new StringMethods();
		assertFalse(s.isPermutation("abc", "abcd"));
		assertTrue(s.isPermutation("hello", "llohe"));
	}

	@Test
	public void testReplaceSpaces() {
		StringMethods s = new StringMethods();
		assertTrue(s.replaceSpaces("Mr John Smith  ", "%20").equals("Mr%20John%20Smith"));
	}

}
