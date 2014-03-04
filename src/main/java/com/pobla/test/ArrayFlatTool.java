package com.pobla.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pobla on 03/03/2014.
 */
public class ArrayFlatTool {

    public static int[] flat(int[][] listOfArrays) {

        if (listOfArrays == null) {
            return null;
        }

        int length = 0;
        for (int[] array : listOfArrays) {
            length += array.length;
        }
        int[] flattenedArray = new int[length];

        int index = 0;
        for (int[] array : listOfArrays) {
            for (int element : array) {
                flattenedArray[index] = element;
                index++;
            }
        }
        return flattenedArray;

    }

    public static Integer[] flatWithCollections(int[][] listOfArray) {

        if (listOfArray == null) {
            return null;
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int[] array : listOfArray) {
            for (int element : array) {
                list.add(element);
            }
        }

        Integer[] totalResult = new Integer[list.size()];
        return list.toArray(totalResult);

    }
}
