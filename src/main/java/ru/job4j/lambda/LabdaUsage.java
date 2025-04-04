package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LabdaUsage {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("eeeee", "a", "ccc", "dddd", "bb");
        Comparator<String> comparator = (left, right) -> Integer.compare(right.length(), left.length());
        strings.sort(comparator);
        for (String string : strings) {
            System.out.println(string);
        }
    }

        Comparator<String> comparator = (left, right) -> {
            System.out.println("compare - " + left + " (" + left.length() + ") : "
                    + right + " (" + right.length() + ")");
            return Integer.compare(right.length(), left.length());
        };
    }
