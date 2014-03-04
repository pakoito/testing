package com.pobla.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.HashSet;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import com.pobla.test.tools.Node;

/**
 * Created by Pobla on 04/03/2014.
 */
public class SequenceWordsTest {

	
	private static HashSet<String> diccionary = new HashSet<String>();

	//Random data with an available path for the tests.
	@BeforeClass
	public static void initClass() {
		diccionary.add("dog");
		diccionary.add("cod");
		diccionary.add("cot");
		diccionary.add("cat");
		diccionary.add("dat");
		diccionary.add("qog");
		diccionary.add("wog");
		diccionary.add("eog");
		diccionary.add("rot");
		diccionary.add("tot");
		diccionary.add("yot");
		diccionary.add("czg");
		diccionary.add("cxg");
		diccionary.add("ccg");
		diccionary.add("cvg");
		diccionary.add("dow");
		diccionary.add("cog");
		diccionary.add("daw");
		diccionary.add("dqq");
		diccionary.add("cag");
		diccionary.add("dhe");
		diccionary.add("poi");
		diccionary.add("zxw");
		diccionary.add("wqx");
		diccionary.add("cat");
		diccionary.add("cat");
		diccionary.add("cyw");
		diccionary.add("cgq");
		diccionary.add("csg");
		diccionary.add("xod");
		diccionary.add("czw");
		diccionary.add("vat");
		diccionary.add("bog");

	}

	@Test
	public void testFindSequence() {
		Node goal = new SequenceWords().findSequence("dog", "cat", diccionary);
		assertEquals("Node is different from expected", "cat", goal.getData());
		
		goal = new SequenceWords().findSequence("cat", "dog", diccionary);
		assertEquals("Node is different from expected", "dog", goal.getData());

	}

	@Test
	public void testUnableSequence() {
		Node goal = new SequenceWords().findSequence("dog", "zef", diccionary);
		assertNull("Node is not null as expected", goal);

	}

	@Test
	public void testBadInput() {
		Node goal = new SequenceWords().findSequence(null, "cat", diccionary);
		assertNull("Node is not null as expected", goal);
		
		goal = new SequenceWords().findSequence("dog", null, diccionary);
		assertNull("Node is not null as expected", goal);
		
		goal = new SequenceWords().findSequence("dog", "cat", null);
		assertNull("Node is not null as expected", goal);
	}
	
	

}
