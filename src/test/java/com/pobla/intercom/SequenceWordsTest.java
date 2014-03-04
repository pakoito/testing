package com.pobla.intercom;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.pobla.intercom.tools.Node;

/**
 * Created by Pobla on 04/03/2014.
 */
public class SequenceWordsTest {

    private static final Logger log = Logger.getLogger(SequenceWordsTest.class);

    @Test
    public void test() {
    	
        Node result = new SequenceWords().findSequence("dog", "cat");
        
        log.info(result);
    }
    
    @Test
    public void test1() {
    	System.out.println("----------------TEST1----------------");
        Node result = new SequenceWords().findSequence("abc", "zef");
        
    }

}
