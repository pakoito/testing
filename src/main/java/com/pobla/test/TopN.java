package com.pobla.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.apache.log4j.Logger;

import com.pobla.test.tools.Quicksort;


/**
 * Created by Pobla on 03/03/2014.
 */
public class TopN {

    private static final Logger log = Logger.getLogger(TopN.class);


    private String separator = ",";

    public int[] findN(InputStream is, final int n) throws IOException {

        if (is == null || n <= 0) {
            return null;
        }

        //Implementation of quick sort algorithm for sorting the array.
        Quicksort quicksort = new Quicksort();
        //Reference to the array that will be returned.
        int[] topN = new int[0];


        BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        String line;

        while ((line = br.readLine()) != null) {
            int[] numbersInLine = getNumbers(line);
            //Concatenate the highest number we have from previous lines with the new set.
            topN = ArrayFlatTool.flat(new int[][]{numbersInLine, topN});
            //Sort the new array and select the N highest number.
            quicksort.sort(topN);
            if (topN.length > n) {
                topN = Arrays.copyOfRange(topN, topN.length - n, topN.length);
            }


        }

        return topN;


    }

    private int[] getNumbers(String line) {

        String[] numbersString = line.split(separator);
        int[] numbers = new int[numbersString.length];
        for (int i = 0; i < numbersString.length; i++) {
            try {
                if (numbersString[i].length() == 0) {
                    continue;
                }
                numbers[i] = Integer.parseInt(numbersString[i].trim());
            } catch (Exception ex) {
                log.warn(String.format("Ignored string <%s>, bad format", numbersString[i]));
            }


        }
        return numbers;
    }

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }
}
