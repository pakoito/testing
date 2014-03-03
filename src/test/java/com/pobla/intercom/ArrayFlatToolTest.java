package com.pobla.intercom;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static junit.framework.TestCase.assertNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Pobla on 03/03/2014.
 */
public class ArrayFlatToolTest {
    @Test
    public void testFlat() throws Exception {
        int[][] testData = {{1, 23, 43, 54}, {1, 2, 4}, {5, 65, 12, 1, 5, 4}};

        int[] result = ArrayFlatTool.flat(testData);

        int[] expected = {1, 23, 43, 54, 1, 2, 4, 5, 65, 12, 1, 5, 4};

        assertNotNull("Resulting array is null", result);
        assertTrue(String.format("Resulting array <%s> is different from expected <%s>", Arrays.toString(result), Arrays.toString(expected)), Arrays.equals(result, expected));

    }

    @Test
    public void testFlatNullInput() throws Exception {
        int[] result = ArrayFlatTool.flat(null);
        assertNull("Resulting result is not null", result);

    }


    @Test
    public void testFlatWithCollections() throws Exception {
        int[][] testData = {{1, 23, 43, 54}, {1, 2, 4}, {5, 65, 12, 1, 5, 4}};

        Integer[] result = ArrayFlatTool.flatWithCollections(testData);

        Integer[] expected = {1, 23, 43, 54, 1, 2, 4, 5, 65, 12, 1, 5, 4};

        assertNotNull("Resulting array is null", result);
        assertTrue(String.format("Resulting array <%s> is different from expected <%s>", Arrays.toString(result), Arrays.toString(expected)), Arrays.equals(result, expected));

    }

    @Test
    public void testFlatWithCollectionsNullInput() throws Exception {
        int[][] testData = null;

        Integer[] result = ArrayFlatTool.flatWithCollections(testData);

        assertNull("Resulting result is not null", result);
    }
}
