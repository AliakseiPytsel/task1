package com.example.array.warehouse;

public class ArrayStatistics {

    private final int min;
    private final int max;
    private final long sum;
    private final double average;

    public ArrayStatistics(int min, int max, long sum, double average) {
        this.min = min;
        this.max = max;
        this.sum = sum;
        this.average = average;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public long getSum() {
        return sum;
    }

    public double getAverage() {
        return average;
    }

    @Override
    public String toString() {
        return "ArrayStatistics{min=" + min
                + ", max=" + max
                + ", sum=" + sum
                + ", average=" + average + "}";
    }
}