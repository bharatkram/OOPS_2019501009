/**
 * Given an array of integers Find the mean, median, mode, standard deviation
 * and variance.
 *
 * Mean
 * Input : [1,2,3,4,5]
 * Output : 3.0
 *
 * Median
 * Input : [1,2,3,4,5]
 * Output : 3.0
 *
 * Mode
 * Input : [1,1,2,2,3]
 * Output : [1,2]
 *
 * Variance
 * Input : [1,2,3,4,5]
 * Output : 2.0
 *
 * Standard Deviation
 * Input : [1,2,3,4,5]
 * Output : 1.41421356
 *
 * @author Siva Sankar
 * @author Bharat Ram Koppu
 */

import java.util.*;

public final class Stats {
    /**
     * Empty Constructor.
    */
    private Stats() {
        //Empty Constructor
    }

    /**
     * This method should return the mean of the elements of the array.
     * If the arr is empty (length is 0), return the mean as 0.
     * @param arr the input array contians elements.
     * @return the mean of the array.
     */
    public static double mean(final int[] arr) {
        //  Your code goes here....
        double sum = 0.0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum/arr.length;
    }

    /**
     * This method returns the median of the elements of the array.
     * Prerequisite : The array should be sorted to find the median.
     *
     * Hint : Arrays.sort(arr) sorts the elements of the array.
     *
     * @param arr the input array contains random elements (not in sorted order)
     * @return the median of the elements of the array.
     */
    public static double median(int[] arr) {
        //  Your code goes here...
        Arrays.sort(arr);

        if (arr.length %2 != 0) {
            return arr[arr.length/2];
        }
        return (arr[arr.length/2] + arr[(arr.length/2) - 1]) / 2.0;
    }

    /**
     * This method returns the mode of the array. If there is no mode, then it returns
     * 0 as the mode.
     *
     * @param arr the input array.
     * @return the mode of the array, 0 otherwise if there is no mode.
     */
    public static int mode(int[] arr) {
        //  Your code goes here....
        int count = 0;
        int maxCount = 0;
        float maxCountNumber = 0.0f;
        int modeNumbers = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count += 1;
                }
            }
            if (count > maxCount && i != maxCountNumber) {
                maxCount = count;
                maxCountNumber = i;
                modeNumbers = 1;
            }
            else if (count = maxCount && i != maxCountNumber) {
                modeNumbers += 1;
            }
        }
        if (modeNumbers > 1) {
            return 0;
        }
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count += 1;
                }
            }
            if (count == maxCount) {
                return arr[i];
            }
        }
    }

    /**
     * This method returns the variance of the input array.
     * Make use of the mean functon which has already written.
     *
     * @param arr the input array
     * @return the variance of the array.
     */
    public static double variance(int[] arr) {
        //  Your code goes here....
        double median = median(arr);
        double variance = 0.0;
        for (int i = 0; i < arr.length; i++) {
            variance = Math.pow(median - arr[i], 2);
        }
        variance /= arr.length;
        return variance;
    }

    /**
     * This method returns the standard deviation of the array.
     * Hint : You can find the square root using Math.sqrt() method.
     * @param arr the input array
     * @return the standard deviation of the input array.
     */
    public static double standardDeviation(int[] arr) {
        //  Your code goes here....
        double variance = variance(arr);
        double std = Math.sqrt(variance);
        return std;
    }
}
