package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item("New Item");
        Item item1 = new Item(1, "New item");

        LocalDateTime createdDate = item.getCreated();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");

        String formattedDate = createdDate.format(formatter);
        System.out.println("Item created on: " + formattedDate);
        System.out.println(item);
        System.out.println(item1);
    }
}