package com.pobla.intercom;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

/**
 * Created by Pobla on 03/03/2014.
 */
public class TopNTest {


    @Test
    public void testFindN() throws Exception {
        TopN topN = new TopN();

        /*Test data: file with numbers from 0 to 999*/
        InputStream is = new FileInputStream(new File("src/test/resources/data_test.txt"));

        final int N = 5;

        int[] result = topN.findN(is, N);

        assertNotNull(result);
        assertEquals("Data size is different from expected", N, result.length);

        /*This 5 values have been manually added to the random data*/
        int[] expected = {1001, 1002, 1003, 1004, 1005};
        assertArrayEquals("Resulting array is different from expected", expected, result);


    }

    @Test
    public void testFindNByteAarrayIS() throws Exception {
        TopN topN = new TopN();

        final int N = 2;

        String buffer = "14,12, ,54, 21, \n, 232,999, \n, 653, 432, 4, 267,\n 21,43, 988 ,12,32\n, 32, 54,1, 32,  43, 12,651,";

        InputStream is = new ByteArrayInputStream(buffer.getBytes());


        int[] result = topN.findN(is, N);

        assertNotNull(result);
        assertEquals("Data size is different from expected", N, result.length);


        int[] expected = {988, 999};
        assertArrayEquals("Resulting array is different from expected", expected, result);


    }


    @Test
    public void testFindNParamNull() throws IOException {
        TopN topN = new TopN();

        InputStream is = null;
        final int N = 5;

        int[] result = topN.findN(is, N);
        assertNull(result);

    }

    @Test
    public void testFindNBadN() throws IOException {
        TopN topN = new TopN();

        /*Test data: file with numbers from 0 to 999*/
        InputStream is = new FileInputStream(new File("src/test/resources/data_test.txt"));

        int[] result = topN.findN(is, -1);
        assertNull(result);

    }
}
