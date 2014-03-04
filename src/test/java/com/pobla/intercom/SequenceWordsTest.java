package com.pobla.intercom;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created by Pobla on 04/03/2014.
 */
public class SequenceWordsTest {

    private static final Logger log = Logger.getLogger(SequenceWordsTest.class);

    @Test
    public void test() {
        String ola = new SequenceWords().findSequence("dog", "cat");
        log.info(ola);
    }

}
