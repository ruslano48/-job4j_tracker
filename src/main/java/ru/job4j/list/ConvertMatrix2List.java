package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] arrey) {
        List<Integer> list = new ArrayList<>();
        for (int[] row : arrey) {
            for (int cell : row) {
                list.add(cell);

            }
        }
            return list;
        }
    }