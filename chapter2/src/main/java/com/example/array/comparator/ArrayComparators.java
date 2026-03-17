package com.example.array.comparator;

import com.example.array.entity.CustomArray;
import java.util.Comparator;

public class ArrayComparators {

    private ArrayComparators() {
    }

    public static Comparator<CustomArray> byId() {
        return Comparator.comparing(CustomArray::getId);
    }

    public static Comparator<CustomArray> byLength() {
        return Comparator.comparingInt(CustomArray::length);
    }

    public static Comparator<CustomArray> byFirstElement() {
        return (first, second) -> {
            int[] firstData = first.getData();
            int[] secondData = second.getData();
            return Integer.compare(firstData[0], secondData[0]);
        };
    }
}