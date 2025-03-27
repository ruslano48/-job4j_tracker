package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int minLenght = Math.min(left.length(), right.length());
        for (int i = 0; i < minLenght; i++) {
            int comparison = Character.compare(left.charAt(i), right.charAt(i));
            if (comparison != 0) {
                return comparison;
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}