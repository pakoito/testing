package com.pobla.intercom.tools;


/**
 * Created by Pobla on 03/03/2014.
 */
public class Quicksort {
    private int[] array;


    public void sort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        this.array = array;
        quicksort(0, array.length - 1);
    }

    private void quicksort(int low, int high) {
        int i = low, j = high;
        int pivot = array[low + (high - low) / 2];
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}