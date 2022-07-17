package lazyboywu.leetcode.problems.offerII.p0041MovingAverage;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;


import java.math.BigDecimal;
import java.math.RoundingMode;
/**
 * TODO
 *
 * @author lazyboywu
 * @since
 */
public class MovingAverage {

    int size = 0;
    int count = 0;
    int[] ints;
    double sum = 0;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        this.ints = new int[size];
    }

    public double next(int val) {

        int index = count % size;

        if (count >= size) {
            sum -= ints[index];
        }

        ints[index] = val;
        count++;

        sum += val;

        double result;
        if (count < size) {
            result = sum / count;
        } else {
            result = sum / size;
        }

        return result;
    }
}
