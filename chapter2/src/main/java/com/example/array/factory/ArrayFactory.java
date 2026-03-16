package com.example.array.factory;

import com.example.array.entity.CustomArray;
import com.example.array.exception.CustomArrayException;

public interface ArrayFactory {

    CustomArray createArray(int[] data) throws CustomArrayException;
}