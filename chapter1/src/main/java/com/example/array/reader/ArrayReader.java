package com.example.array.reader;

import com.example.array.entity.CustomArray;
import com.example.array.exception.CustomArrayException;

import java.util.List;

public interface ArrayReader {

    List<CustomArray> readArraysFromFile(String filePath) throws CustomArrayException;
}