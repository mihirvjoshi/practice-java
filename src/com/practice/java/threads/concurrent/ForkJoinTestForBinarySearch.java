package com.practice.java.threads.concurrent;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinTestForBinarySearch {

    static final int ARRAY_SIZE = 1000;
    static final int THRESHOLD = 10;

    static final int MIN_VALUE = 0;
    static final int MAX_VALUE = 100;

    static Random rand = new Random();


    // a function for retrieving a random int in a specific range
    public static int randInt(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }

    static volatile boolean result = false;
    static int[] array = new int[ARRAY_SIZE];
    static int target;

    @SuppressWarnings("serial")
    static class MyAction extends RecursiveAction {

        int startIndex, endIndex;

        public MyAction(int startIndex, int endIndex) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        // if the target integer was not found yet: we first check whether 
        // the entries to search are too few. In that case, we perform a 
        // sequential search and update the result if the target was found. 
        // Otherwise, we break the search into two parts and invoke the 
        // search in these two tasks.
        @Override
        protected void compute() {
            if (!result) {
                if (endIndex-startIndex<THRESHOLD) { 
                    // sequential search in case of smaller array
                    for (int i=startIndex ; i<endIndex ; i++) {
                        if (array[i]==target) {
                            result = true;
                        }
                    }
                } else {
                    int middleIndex = (startIndex + endIndex) / 2;
                    RecursiveAction action1 = new MyAction(startIndex, middleIndex);
                    RecursiveAction action2 = new MyAction(middleIndex+1, endIndex);
                    invokeAll(Arrays.asList(action1,action2));
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        for (int i=0 ; i<ARRAY_SIZE ; i++) {
            array[i] = randInt(MIN_VALUE, MAX_VALUE);
        }
        target = randInt(MIN_VALUE, MAX_VALUE);
        System.out.println("Target to be searched is ::" + target);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new MyAction(0,ARRAY_SIZE));
        System.out.println(result);
    }

}