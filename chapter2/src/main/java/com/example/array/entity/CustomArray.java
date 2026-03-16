package com.example.array.entity;

import com.example.array.observer.ArrayObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomArray {

    private final String id;
    private int[] data;
    private final List<ArrayObserver> observers = new ArrayList<>();

    public CustomArray(int[] data) {
        this.id = UUID.randomUUID().toString();
        this.data = data.clone();
    }

    public String getId() {
        return id;
    }

    public int[] getData() {
        return data.clone();
    }

    public void setData(int[] data) {
        this.data = data.clone();
        notifyObservers();
    }

    public void setElement(int index, int value) {
        this.data[index] = value;
        notifyObservers();
    }

    public int length() {
        return data.length;
    }

    public void addObserver(ArrayObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (ArrayObserver observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CustomArray{id='");
        sb.append(id);
        sb.append("', data=[");
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