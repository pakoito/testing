package com.pobla.test.tools;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NodeTest {

	@Test
	public void testNotEqualsObject() {
		Node test1 = new Node("test1");
		Node test2 = new Node("test2");

		assertNotEquals(test1, test2);
		assertNotEquals(test1, null);
		assertNotEquals(test1, "test1");
	}

	@Test
	public void testEqualsObject() {
		Node test1 = new Node("test1");
		Node test2 = new Node("test1");

		assertEquals(test1, test2);

	}

	@Test
	public void testIsValidNeighbor() {
		Node test1 = new Node("test");

		assertFalse("Different number of letters",
				test1.isValidNeighbor("test1"));
		assertTrue("One difference", test1.isValidNeighbor("t3st"));
		assertFalse("Two difference", test1.isValidNeighbor("t3st1"));
		assertFalse("Null comparasion ", test1.isValidNeighbor(null));

	}

}
