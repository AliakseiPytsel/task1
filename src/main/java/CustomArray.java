package com.example.array.entity;

public class CustomArray {

    private int[] data;

    public CustomArray(int[] data) {
        this.data = data.clone();
    }

    public int[] getData() {
        return data.clone();
    }

    public void setData(int[] data) {
        this.data = data.clone();
    }

    public int length() {
        return data.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CustomArray{data=[");
        for (int i = 0; i < data.length; i++) {
            sb.append(data[i]);
            if (i < data.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]}");
        return sb.toString();
    }
}