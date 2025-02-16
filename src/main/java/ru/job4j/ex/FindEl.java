package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                return i;
            }
        }
        throw new ElementNotFoundException("Element not found: " + key);
    }

    public static void main(String[] args) {
        String[] array = {"1", "2", "3"};
        String searchKey = "4";
        try {
            int index = indexOf(array, searchKey);
            System.out.println("Element found at index: " + index);
        } catch (ElementNotFoundException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}