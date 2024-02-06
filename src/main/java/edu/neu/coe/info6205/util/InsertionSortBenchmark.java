package edu.neu.coe.info6205.util;

import edu.neu.coe.info6205.sort.elementary.InsertionSort;


import java.util.Arrays;
import java.util.Random;

public class InsertionSortBenchmark {

    private static void warmup(InsertionSort<Integer> sorter, Integer[] array) {   // warm-up

        int warmupIterations = 10;
        for (int i = 0; i < warmupIterations; i++) {
            Integer[] tempArray = array.clone();
            sorter.sort(tempArray, 0, tempArray.length);
        }
    }


    public static void main(String[] args) {
        Benchmark_Timer<Integer[]> timer = new Benchmark_Timer<>(
                "InsertionSort Benchmark",
                null,
                arr -> {
                    InsertionSort<Integer> sorter = new InsertionSort<>();
                    warmup(sorter, arr.clone());

                    sorter.sort(arr.clone(), 0, arr.length);
                },
                null
        );

        int[] sizes = {100, 200, 400, 800, 1600}; // Array sizes to test
        for (int size : sizes) {
            System.out.println("Array Size: " + size);

            // Generate and benchmark random arrays
            Integer[] randomArray = generateRandomArray(size);
            double randomTime = timer.runFromSupplier(() -> randomArray, 10);
            System.out.println("Random Array: " + randomTime + " ms");

            // Ordered arrays
            Integer[] orderedArray = generateOrderedArray(size);
            double orderedTime = timer.runFromSupplier(() -> orderedArray, 10);
            System.out.println("Ordered Array: " + orderedTime + " ms");

            // Partially ordered arrays
            Integer[] partiallyOrderedArray = generatePartiallyOrderedArray(size, size / 2); // Half ordered
            double partiallyOrderedTime = timer.runFromSupplier(() -> partiallyOrderedArray, 10);
            System.out.println("Partially Ordered Array: " + partiallyOrderedTime + " ms");

            //Reverse ordered arrays
            Integer[] reverseOrderedArray = generateReverseOrderedArray(size);
            double reverseOrderedTime = timer.runFromSupplier(() -> reverseOrderedArray, 10);
            System.out.println("Reverse Ordered Array: " + reverseOrderedTime + " ms");

            System.out.println();
        }
    }



    private static Integer[] generateRandomArray(int size) {
        Random random = new Random();
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
        }
        return array;
    }

    private static Integer[] generateOrderedArray(int size) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    private static Integer[] generatePartiallyOrderedArray(int size, int orderedSize) {
        Integer[] array = generateOrderedArray(orderedSize);
        Random random = new Random();
        for (int i = orderedSize; i < size; i++) {
            array = Arrays.copyOf(array, array.length + 1);
            array[i] = random.nextInt(size);
        }
        return array;
    }

    private static Integer[] generateReverseOrderedArray(int size) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i;
        }
        return array;
    }
}
